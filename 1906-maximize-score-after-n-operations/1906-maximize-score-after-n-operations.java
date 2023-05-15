class Solution {
    public int maxScore(int[] nums) {
        // return helperRec(nums, 0, 0);

        int dpSize = 1 << nums.length;
        int[] dp = new int[dpSize];
        Arrays.fill(dp, -1);
        return helperMem(nums, 0, 0, dp);
    }
    public int helperRec(int[] nums, int mask, int pairsPicked){
        if(2 * pairsPicked == nums.length) return 0;
        int maxScore = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(((mask >> i) & 1) == 1 || ((mask >> j) & 1) == 1) continue;
                int newMask = mask | (1 << i) | (1 << j);
                int currScore = (pairsPicked + 1) * gcd(nums[i], nums[j]);
                int remainScore = helperRec(nums, newMask, pairsPicked + 1);
                maxScore = Math.max(maxScore, currScore + remainScore); 
            }
        }
        return maxScore;
    }

    public int helperMem(int[] nums, int mask, int pairsPicked, int[] dp){
        if(2 * pairsPicked == nums.length) return 0;
        if(dp[mask] != -1) return dp[mask];
        int maxScore = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(((mask >> i) & 1) == 1 || ((mask >> j) & 1) == 1) continue;
                int newMask = mask | (1 << i) | (1 << j);
                int currScore = (pairsPicked + 1) * gcd(nums[i], nums[j]);
                int remainScore = helperMem(nums, newMask, pairsPicked + 1, dp);
                maxScore = Math.max(maxScore, currScore + remainScore); 
            }
        }
        return dp[mask] = maxScore;
    }


    public int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}