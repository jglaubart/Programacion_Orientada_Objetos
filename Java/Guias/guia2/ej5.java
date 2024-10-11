package Guias.guia2;

public class ej5 {
    public static void main(String[] args) {
        StringBuilder frase = new StringBuilder();
        for(String s : args){
            frase.append(s.toLowerCase());    //creo la frase uniendo todos los strings en uno
        }
        if(Palindromo(frase.toString())){
            System.out.println("Es Palindromo");
        } else{
            System.out.println("No es Palindromo");
        }
    }

    private static boolean Palindromo(String frase){
        int largo = frase.length();
        for(int i=0; i<largo; i++){
            if(frase.charAt(i) != frase.charAt(largo-1-i)){
                return false;
            }
        }
        return true;
    }
}