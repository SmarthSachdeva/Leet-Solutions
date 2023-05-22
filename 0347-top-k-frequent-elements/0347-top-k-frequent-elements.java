class Solution {
    static HashMap <Integer , Integer> hm;
    public int[] topKFrequent(int[] nums, int k) {
        hm = new HashMap <>();
        int [] ans = new int [k];
        for(int i = 0 ; i< nums.length ; i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i] , hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i] , 1);
            }
        }
        for(int i = 0; i<k ; i++ ){
            ans[i] = helper();

        }
        return ans;
        // int freq = 0;
        // 

    }
    public int helper(){
        int frequency = 0;
        int var = 0;
        for(Integer key : hm.keySet()){
            if(hm.get(key)>frequency){
                frequency = hm.get(key);
                var = key;
            }
        }
        hm.remove(var);
        return var;
    }
}
