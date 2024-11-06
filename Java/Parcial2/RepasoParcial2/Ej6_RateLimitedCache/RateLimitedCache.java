package Parcial2.RepasoParcial2.Ej6_RateLimitedCache;

import java.util.HashMap;
import java.util.Map;

public class RateLimitedCache<K, V> extends BaseCache<K, V>{
    private final Map<String, QuotaType> users = new HashMap<>(); // guarda los usuarios registrados
    private final Map<String, Map<String,UserData>> writesAndReads= new HashMap<>(); // guarda los gets y puts de los usuarios
    // Las claves con los valores en si se guardan en super como en BaseCache

    public void register(String user, QuotaType type){
        users.put(user, type);
        writesAndReads.put(user, new HashMap<>());
    }

    private QuotaType validateRegistratedUser(String user){ //veo si el usuario existe
        QuotaType type = users.get(user);
        if(type == null){
            throw new RateLimitedException();
        }
        return type;
    }
    private UserData putData(String user, String date){  //creo al usuario
        //writesAndReads.putIfAbsent(user, new HashMap<>());  //---> no hace falta porque ya lo hice en el register
        writesAndReads.get(user).putIfAbsent(date, new UserData());
        return writesAndReads.get(user).get(date);
    }
    public void put(String user, String date, K key, V value){
        QuotaType type = validateRegistratedUser(user);
        UserData data = putData(user, date);
        if(type.canWrite(data.writes)){
            data.write();
            super.put(user, date, key, value);
        } else throw new RateLimitedException();
    }

    public V get(String user, String date, K key){
        QuotaType type = validateRegistratedUser(user);
        UserData data = putData(user, date);
        if(type.canRead(data.reads)){
            data.read();
            return super.get(user, date, key);
        }
        throw new RateLimitedException();
    }

    public static class UserData{
        private int reads, writes;

        public void read(){
            reads++;
        }
        public void write(){
            writes++;
        }
        public int getReads(){
            return reads;
        }
        public int getWrites(){
            return writes;
        }
    }
}
