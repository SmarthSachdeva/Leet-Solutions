class Solution {
    public int helper(int nums[] , int k){
        if(k < 0) return 0;
        
        int cnt = 0 ;
        int i = 0 , j = 0;
        
        HashMap<Integer ,Integer> hm = new HashMap<>();
        
        for( ; j < nums.length ; j++){
            
            int vl = nums[j];
            hm.put(vl , hm.getOrDefault(vl , 0) + 1);
            
            while(hm.size() > k){
                int e = nums[i];
                hm.put(e , hm.get(e) - 1);
                if(hm.get(e) == 0){
                    hm.remove(e);
                }
                i++;
            }
            if(hm.size() <= k) {
                cnt += j - i + 1;
            }
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums , k-1);
    }
}