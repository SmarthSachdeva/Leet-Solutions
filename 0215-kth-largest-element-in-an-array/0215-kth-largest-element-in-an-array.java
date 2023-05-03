class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] temp = nums;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    
        for(int i = 0 ; i < nums.length ; i++){
            pq.add(temp[i]);
        }

        int vl = 0;
        while(k != 0){
            vl = pq.remove();
            k--;
        }

        return vl;
    }
}