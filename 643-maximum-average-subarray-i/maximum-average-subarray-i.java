class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0 , max = 0;
        int i = 0 , j = 0;

        while(j < k){
            sum += nums[j];
            j++;
        }

        max = sum; 

        while(j < nums.length){
            
            sum -= nums[i];
            sum += nums[j];

            max = Math.max(max ,sum);

            i++;j++;
        }
        
        return (double)max/k;
    }
}