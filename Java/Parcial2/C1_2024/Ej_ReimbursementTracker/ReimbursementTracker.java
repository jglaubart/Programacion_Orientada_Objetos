package Parcial2.C1_2024.Ej_ReimbursementTracker;

import java.time.YearMonth;
import java.util.*;

public class ReimbursementTracker {
    private final Map<String, Integer> maxPerClient = new HashMap<>();
    private final Map<String, SortedMap<YearMonth, Integer>> monthPerClient = new HashMap<>();

    public void registerClient(String name, int max){
        if (maxPerClient.containsKey(name)){
            throw new IllegalArgumentException("Client already registered.");
        }
        maxPerClient.put(name, max);
        monthPerClient.put(name, new TreeMap<>());
    }

    private void checkClient(String name){
        if (!maxPerClient.containsKey(name)){
            throw new IllegalArgumentException("Client is not registered.");
        }
    }
    public int getRemainingReimbursement(String name, YearMonth month){
        checkClient(name);
        int max = maxPerClient.get(name);
        int reimbursed = monthPerClient.getOrDefault(name, new TreeMap<>()).getOrDefault(month,0);
        return max - reimbursed;
    }

    public void addReimbursement(String name, YearMonth month, int amount){
        checkClient(name);
        if(getRemainingReimbursement(name, month) < amount){
            throw new IllegalArgumentException("Reimbursement surpasses month cap.");
        }
        monthPerClient.get(name).merge(month, amount, Integer::sum);
    }

    public Set<Map.Entry<YearMonth, Integer>> getReimbursements(String name, YearMonth from, YearMonth to){
        checkClient(name);
        return monthPerClient.getOrDefault(name, new TreeMap<>()).subMap(from, to).entrySet();
    }

}
