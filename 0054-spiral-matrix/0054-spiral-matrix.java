class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rmin = 0, rmax = matrix.length - 1;
        int cmin = 0, cmax = matrix[0].length - 1;
        int te = matrix.length * matrix[0].length;
        int cnt = 0;

        List<Integer> ans = new ArrayList<>();

        while (cnt < te) {
            for(int i = cmin; i <= cmax && cnt < te; i++){
                ans.add(matrix[rmin][i]);
                cnt++;
            }
            for(int i = rmin + 1; i <= rmax && cnt < te; i++){
                ans.add(matrix[i][cmax]);
                cnt++;
            }
            for(int i = cmax - 1; i >= cmin && cnt < te; i--){
                ans.add(matrix[rmax][i]);
                cnt++;
            }
            for(int i = rmax - 1; i >= rmin + 1 && cnt < te; i--){
                ans.add(matrix[i][cmin]);
                cnt++;
            }

            rmin++;
            rmax--;
            cmin++;
            cmax--;
        }
        return ans;
    }
}
