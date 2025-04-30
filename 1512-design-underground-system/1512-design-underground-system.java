class UndergroundSystem {
    private class Customer{
        int id;
        String startStation;
        String endStation;
        int startTime;
        int endTime;
        Customer(int id, String stationName, int t){
            this.id = id;
            this.startStation = stationName;
            this.endStation = "";
            this.startTime = t;
            this.endTime = -1;
        }
    }
    List<Customer> customerList;
    public UndergroundSystem() {
        customerList = new ArrayList<>();
    }
    public void checkIn(int id, String stationName, int t) {
        Customer curr = new Customer(id, stationName, t);
        customerList.add(curr);
    }
    public void checkOut(int id, String stationName, int t) {
        int index = customerList.size()-1;
        while(index>=0){
            Customer curr = customerList.get(index);
            if(curr.id == id){
                curr.endStation = stationName;
                curr.endTime = t;
                break;
            }
            index--;
        }
    }
    public double getAverageTime(String startStation, String endStation) {
        int count = 0;
        double sum = 0;
        for(Customer customer : customerList){
            if(customer.startStation.equals(startStation) && customer.endStation.equals(endStation)){
                sum+= customer.endTime - customer.startTime;
                count++;
            }
        }
        if(count ==0) return 0;
        return sum/count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */