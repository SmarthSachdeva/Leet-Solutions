class Solution {
    public int singleNonDuplicate(int[] nums) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int n : nums){
            if(hm.containsKey(n)){
                hm.put(n , -1);
            }else{
                hm.put(n , 1);
            }
        }
        int ans = 0;
        for(int vl : hm.keySet()){
            if(hm.get(vl)==1) ans = vl;
        }

        return ans;
    }
}