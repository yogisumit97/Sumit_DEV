class UndergroundSystem {
    HashMap<Integer, Pair<String, Integer>> checkInMap; // id, <start station, startTime>
    HashMap<String, Pair<Double, Integer>> routeMap; // root, <totaltime, total customers>
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();    
    }
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));    
    }
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> currPair = checkInMap.get(id);
        checkInMap.remove(id);
        String routeName = currPair.getKey()+"_"+stationName; // concatenate using delimiter
        int time = t - currPair.getValue();
        Pair<Double, Integer> curr = routeMap.getOrDefault(routeName, new Pair<>(0.0, 0));
        routeMap.put(routeName, new Pair<>(curr.getKey()+time, curr.getValue()+1));
    }
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation+"_"+endStation;
        Pair<Double, Integer> curr =  routeMap.get(route);
        return curr.getKey()/curr.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */