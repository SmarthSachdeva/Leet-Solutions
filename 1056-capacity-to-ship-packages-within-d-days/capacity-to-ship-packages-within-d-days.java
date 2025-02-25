class Solution {
    private int[] range(int[] arr) {
        int sum = 0;
        int min = arr[0];

        for (int e : arr) {
            sum += e;
            min = Math.max(min, e); // Minimum capacity should be at least the max weight
        }

        return new int[]{sum, min};
    }

    private boolean isPossible(int[] arr, int cap, int days) {
        int wt = 0;
        int cnt = 1; // At least one day required

        for (int e : arr) {
            if (wt + e > cap) {
                cnt++; // New day
                wt = e;
                if (cnt > days) return false;
            } else {
                wt += e;
            }
        }
        return cnt <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int[] range = range(weights);

        int low = range[1], high = range[0];
        int ans = high; // Start with the max sum

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
