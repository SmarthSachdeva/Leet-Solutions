class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Deque<Integer> st = new LinkedList<>();
        int n = nums1.length;
        long sum = 0, ans = 0;
        int nums[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        Arrays.sort(nums, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            sum += nums[n-i-1][0];
            pq.add(nums[n-i-1][0]);
        }
        ans = sum * nums[n-k][1];
        for(int i = n - k - 1; i >= 0 ; i--){
            if(pq.peek() < nums[i][0]){
                // System.out.println(i + "  " + pq.peek() + "  " + ans);
                sum += nums[i][0];
                pq.add(nums[i][0]);
                sum -= pq.poll();
                ans = Math.max(ans, sum * nums[i][1]);
            }
        }
        return ans;
    }
}