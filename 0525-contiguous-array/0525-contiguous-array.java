class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int len = 0;
        
        int i = -1 , sum = 0;
        hm.put(sum ,i);

        while(i < nums.length-1){
            i++;
            int vl = nums[i];
            if(vl == 0) vl =-1;
            sum+=vl;

            if(hm.containsKey(sum)){
                int tlen = i - hm.get(sum);
                len = Math.max(len , tlen);
            }else{
                hm.put(sum , i);
            }
        }
        return len;
    }
}