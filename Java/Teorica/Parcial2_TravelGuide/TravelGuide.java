package Teorica.Parcial2_TravelGuide;

import java.util.*;

public class TravelGuide {

    //Mapa de mapas
    private final Map<String, Map<String, SortedSet<Landmark>>> landmarks;
    public TravelGuide() {
        landmarks = new HashMap<>();
    }

    public void addLandmark(String country, String city, Landmark landmark) {
        landmarks.putIfAbsent(country, new TreeMap<>());
        landmarks.get(country).putIfAbsent(city, new TreeSet<>());
        landmarks.get(country).get(city).add(landmark);
    }

    public int landmarksCount(String country, String city) {
        if(!landmarks.containsKey(country) || !landmarks.get(country).containsKey(city)){
            return 0;
        }
        return landmarks.get(country).get(city).size();
    }

    public int landmarksCount(String country) {
        if(!landmarks.containsKey(country)){
            return 0;
        }
        int ans = 0;
        for (SortedSet<Landmark> city : landmarks.get(country).values()){
            ans += city.size();
        }
        return ans;
    }

    public Collection<Landmark> getLandmarksFromCity(String country,String city) {
        if (!landmarks.containsKey(country) || !landmarks.get(country).containsKey(city) ){
           return new ArrayList<>();
        }
        return landmarks.get(country).get(city);
    }

    public Collection<Landmark> getLandmarksFromCountry(String country) {
        if (!landmarks.containsKey(country)){
            return new ArrayList<>();
        }
        Collection<Landmark> ans = new ArrayList<>();

        for (SortedSet<Landmark> cityLandmarks : landmarks.get(country).values()) {
            ans.addAll(cityLandmarks);
        }

        return ans;
    }

    public void moveLandmark(String country, String fromCity, String toCity, Landmark landmark) {
        if (!landmarks.containsKey(country)){
            throw new TravelGuideException("Country does not exists.");
        }
        if(!landmarks.get(country).containsKey(fromCity) ){
            throw new TravelGuideException("Origin city does not exists in country.");
        }
        if(!landmarks.get(country).get(fromCity).contains(landmark)) {
            throw new TravelGuideException("Landmark does not exists in origin city.");
        }

        landmarks.get(country).get(fromCity).remove(landmark);
        addLandmark(country, toCity, landmark);
    }

}
