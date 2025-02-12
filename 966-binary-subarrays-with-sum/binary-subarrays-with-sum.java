class Solution {
    // Helper function to count subarrays with sum <= goal
    public int numSubarraysWithSumHelper(int[] nums, int goal) {
        if(goal < 0) return 0;
        
        int cnt = 0 , sum = 0;
        int i = 0 , j = 0;
        
        for( ; j < nums.length ; j++){
            sum += nums[j];
            
            // If sum <= goal, count all subarrays that end at j
            while (sum > goal) {
                sum -= nums[i];
                i++;
            }
            cnt += j - i + 1;  // Add the number of subarrays with sum <= goal
        }
        return cnt;
    }
    
    // Main function to count subarrays with sum == goal
    public int numSubarraysWithSum(int[] arr, int goal) {
        // Corrected the semicolon issue and the logic
        int res = numSubarraysWithSumHelper(arr , goal) - numSubarraysWithSumHelper(arr , goal - 1);
        return res;
    }
}
