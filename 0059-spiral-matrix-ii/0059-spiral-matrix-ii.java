class Solution {
    public int[][] generateMatrix(int n) {
        int rmin = 0 , rmax = n-1;
        int cmin = 0 , cmax = n-1;
        int count = 0 , tne = n*n;

        int[][] ans = new int[n][n];

        int k = 1;
        while(count < tne){

            for(int i = cmin ; i <= cmax && count < tne ; i++){
                count++;
                ans[rmin][i] = k++;
            }

            for(int i = rmin+1 ; i <= rmax && count < tne ; i++){
                count++;
                ans[i][cmax] = k++;
            }

            for(int i = cmax-1 ; i>=cmin&&count<tne ;i--){
                count++;
                ans[cmax][i] = k++;
            }

            for(int i = rmax-1 ; i>=rmin+1 && count<tne ; i--){
                count++;
                ans[i][cmin] = k++;
            }

            cmin++;
            rmin++;
            rmax--;
            cmax--;
        }

        return ans;

    }
}