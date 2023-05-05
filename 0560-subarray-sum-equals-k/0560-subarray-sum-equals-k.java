class Solution {
    public int subarraySum(int[] arr, int k) {
      int ans = 0 ;
      HashMap<Integer , Integer> hm = new HashMap<>();
      hm.put(0 , 1);
      int sum = 0;
      for(int i = 0 ; i < arr.length ; i++){
          sum+=arr[i];
          int remsum = sum-k;
          if(hm.containsKey(remsum)){
              ans+=hm.get(remsum);
          }
          hm.put(sum , hm.getOrDefault(sum , 0)+1);
      }
      return ans;  
    }
}