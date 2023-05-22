class Solution {
    public int firstOccurance(int[] nums, int target){
        int low = 0 , high = nums.length-1 ;
        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(target  < nums[mid]){
                high = mid-1;
            }else if(target > nums[mid]){
                low = mid+1;
            }else{
                ans = mid;
                high = mid - 1; 
            }
        }
        return ans;
    }
    public int secondOccurance(int[] nums, int target){
        int low = 0 , high = nums.length-1 ;
        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(target  < nums[mid]){
                high = mid-1;
            }else if(target > nums[mid]){
                low = mid+1;
            }else{
                ans = mid;
                low = mid+1; 
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return  new int[]{-1,-1};
        int[] ans = new int[2];
        ans[0] = firstOccurance(nums , target);
        ans[1] = secondOccurance(nums,target);

        return ans;
    }
}