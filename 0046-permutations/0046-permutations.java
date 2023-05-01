class Solution {
    private void helper(int i , int[] nums , List<List<Integer>> ans){
        if(i == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int k = 0 ; k < nums.length ; k++){
                ds.add(nums[k]);
            }

            ans.add(ds);
            return;
        }
        for(int ind = i ; ind < nums.length ; ind++){
            swap(ind , i , nums);
            helper(i+1 , nums, ans);
            swap(ind , i , nums );
        }
    }
    public void swap(int i , int j , int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper( 0 , nums , ans);

        return ans;
    }
}