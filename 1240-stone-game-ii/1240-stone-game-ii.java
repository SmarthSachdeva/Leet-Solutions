class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] prefix = new int[n];
        prefix[n-1]  = piles[n-1];
        for(int i= n-2; i>=0;i--)
            prefix[i] = prefix[i+1] + piles[i];
            int cap= (int) Math.pow(2, Math.floor(Math.log(n)/ Math.log(2)));
            int[][] dp = new int[n][cap+1];
            for(int i=n-1;i >=0;i--)
            {
                for(int j= cap;j>=1;j--)
                {
                    for(int z=1;z <= j*2;z++)
                    {
                        int k = j+ Math.max(0, z-j);
                        if(k > cap)
                            break;
                            dp[i][j] = Math.max(dp[i][j], prefix[i] - (i + z < n? dp[i+z][k]: 0));
                }
                }
            }

            return dp[0][1];
    }
}