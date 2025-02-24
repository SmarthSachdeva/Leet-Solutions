class Solution {
    public int returnMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int e : arr){
            min = Math.min(min, e);
        }
        return min;
    }

    public int returnMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int e : arr){
            max = Math.max(max, e);
        }
        return max;
    }

    public int minDays(int[] arr, int m, int k) {
        if (arr.length < m * k) return -1;  // Edge case: Not enough flowers

        int low = returnMin(arr), high = returnMax(arr);
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (possible(arr, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean possible(int[] arr, int days, int m, int k) {
        int cnt = 0, noOfB = 0;

        for (int i = 0; i < arr.length; i++) {  // Fix loop range
            if (arr[i] <= days) {
                cnt++;
                if (cnt == k) {  // Only make a bouquet when `cnt` reaches `k`
                    noOfB++;
                    cnt = 0;
                }
            } else {
                cnt = 0;  // Reset count when a flower is unavailable
            }
        }
        return noOfB >= m;
    }
}
