class Solution {
    public void setZeroes(int[][] arr) {
        int ans[][] = new int[arr.length][arr[0].length];
        int temp = Integer.MIN_VALUE+1;

        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = 0 ; j < arr[0].length ; j++) {
                if(arr[i][j] != 0 && arr[i][j] != temp) {
                    ans[i][j] = arr[i][j];
                } else if(arr[i][j] == temp) {
                    continue;
                } else {
                    for(int k = 0 ; k < arr[0].length ; k++) {
                        if(arr[i][k] != 0) arr[i][k] = temp;
                        ans[i][k] = 0;
                    }
                    for(int k = 0 ; k < arr.length ; k++) {
                        if(arr[k][j] != 0) arr[k][j] = temp;
                        
                        ans[k][j] = 0;
                    }
                }
            }
        }
        for(int i = 0 ; i < ans.length ; i++) {
            for(int j = 0 ; j < ans[0].length ; j++) {
                arr[i][j] = ans[i][j];
            }
        }
    }
}