class Solution {
    int[][] dp = new int[2][50005];

//     method to get the highest score of alice , if both play optimally
    public int score(int alice, int [] stoneValue, int ind){
        int n = stoneValue.length;
        if(ind >= n)
            return 0;
    
        if(dp[alice][ind] != Integer.MIN_VALUE)
            return dp[alice][ind];
        
        int res = 0, i = 0, j = ind, sum = 0;
//         if its alice turm then we want max res, so store min_value as there are negative values also, else store max_value in res
        res = alice == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for(i = 0; i < 3 && j + i < n;i++){
            int recursive = score(1-alice, stoneValue, j+i+1);
            sum+=stoneValue[j+i];
            if(alice == 1){
                res = Math.max(res, sum+recursive);
            }else{
                res = Math.min(res, recursive);
            }
        }
        dp[alice][ind] = res;
        return res;
    }
    
//     method to get the highest score of bob can reach if both play optimally
    public int scoreBob(int alice, int [] stoneValue, int ind){
        int n = stoneValue.length;
        if(ind >= n)
            return 0;
        if(dp[alice][ind] != Integer.MIN_VALUE)
            return dp[alice][ind];
        
        int res = 0, i = 0, j = ind, sum = 0;
//      if its alice turm then we want min res, so store max_value, else store min_value in res
 // as we are solving for bob and there may be negative numbers too because 
// if we used 0 then its always greater than zero but we have take the max in the array
        res =  alice == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        for(i = 0; i < 3 && j + i < n;i++){
            int recursive = scoreBob(1-alice, stoneValue, j+i+1);
            sum+=stoneValue[j+i];
            if(alice == 1){
                res = Math.min(res, recursive);
            }else{
                res = Math.max(res, sum+recursive);
            }
        }
        dp[alice][ind] = res;
        return res;
    }
    
    public String stoneGameIII(int[] stoneValue) {
        for(int[] ar : dp)
            Arrays.fill(ar, Integer.MIN_VALUE);
        
        int alice = score(1, stoneValue, 0);
        for(int[] ar : dp)
            Arrays.fill(ar, Integer.MIN_VALUE);
        int bob = scoreBob(1, stoneValue, 0);
        // System.out.println(alice+" new score "+bob);
        return alice == bob ? "Tie" : (alice > bob ? "Alice" : "Bob");
        
    }
}