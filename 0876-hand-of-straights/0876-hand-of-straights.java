class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int h : hand) 
            map.put(h, map.getOrDefault(h, 0) + 1);

        for(int key : map.keySet()){
            heap.add(key);
        }

        while(heap.size() > 0){
            int num = heap.remove();
            int freq = map.get(num);
            if(freq == 0) continue;

            for(int i = 1 ; i < groupSize ; i++){
                num++;
                
                int freq1 = map.getOrDefault(num , 0);

                if(freq1 < freq) return false;
                
                else map.put(num , freq1-freq);
            }
        }

        return true;
    }
}