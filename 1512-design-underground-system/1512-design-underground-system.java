class UndergroundSystem {
    HashMap<String,HashMap<String,Pair>> data;
    HashMap<Integer,Details> inout;
    public UndergroundSystem() {
        data=new HashMap<>();
        inout=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        inout.put(id,new Details(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        int totaltime=t-inout.get(id).time;
        String startStation=inout.get(id).stationName;
        String endStation=stationName;

        if(!data.containsKey(startStation) || !data.get(startStation).containsKey(endStation)){
            data.putIfAbsent(startStation,new HashMap<>());
            data.get(startStation).put(endStation,new Pair(totaltime,1));
        }
        else{
            Pair p = data.get(startStation).get(endStation);
            p.add(totaltime,1);
            data.get(startStation).put(endStation,p);
        }
        inout.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double avgTime;

        int sum=data.get(startStation).get(endStation).sum;
        int count=data.get(startStation).get(endStation).count;

        avgTime= (double)sum/(double)count;

        return avgTime;
    }
}
class Pair{
    int sum=0;
    int count=0;
    Pair(int s,int c){
        this.sum+=s;
        this.count+=c;
    }
    public void add(int s,int c){
        this.sum+=s;
        this.count+=c;
    }
}
class Details{
    String stationName;
    int time;
    Details(String stationName,int time){
        this.stationName=stationName;
        this.time=time;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */