class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length ; // row
        int m = matrix[0].length ; // column

        int low = 0 , high = n * m - 1;

        while(low <= high){
            int mid = (low + high) / 2 ;

            int midVal = matrix[mid / m][mid % m];

            if(target == midVal){
                return true;
            }
            else{
                if(target >= midVal){
                    // move low
                    low = mid + 1;
                }
                else{
                    // move high
                    high = mid - 1;
                }
            }

        }

        return false;
    }
}