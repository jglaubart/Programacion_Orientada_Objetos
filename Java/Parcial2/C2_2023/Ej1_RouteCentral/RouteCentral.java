package Parcial2.C2_2023.Ej1_RouteCentral;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class RouteCentral {
    //Map<Desde , Map<Destino, costo>>
    private final Map<String, Map<String, Integer>> routes = new HashMap<>();
    private final Function<Integer, Integer> twoWayCostFunction;

    public RouteCentral(Function<Integer, Integer> twoWayCostFunction) {
        this.twoWayCostFunction = twoWayCostFunction;
    }

    public void addOneWayRoute(String from, String to, int cost) {
        routes.putIfAbsent(from, new HashMap<>());
        routes.get(from).putIfAbsent(to, cost);
    }

    public void addTwoWayRoute(String e1, String e2, int cost) {
        int singleCost = twoWayCostFunction.apply(cost);
        addOneWayRoute(e1, e2, singleCost);
        addOneWayRoute(e2, e1, singleCost);
    }

    private void checkRoute(String from, String to) {
        if (!routes.containsKey(from) || !routes.get(from).containsKey(to)) {
            throw new IllegalArgumentException("Route does not exists.");
        }
    }
    public int getDirectRouteMiles(String from, String to) {
        checkRoute(from, to);
        return routes.get(from).get(to);
    }

    public void changeRouteCost(String from, String to, int cost) {
        checkRoute(from, to);
        routes.get(from).put(to, cost);
    }


    public int getOneStopRouteMiles(String from, String stop, String to) {
        checkRoute(from, stop);
        checkRoute(stop, to);
        int r1 = getDirectRouteMiles(from, stop);
        int r2 = getDirectRouteMiles(stop, to);
        return r1+r2;
    }

}
