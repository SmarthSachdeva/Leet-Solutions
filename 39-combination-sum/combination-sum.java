class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(0 , candidates , target , list , new ArrayList<>());

        return list;
    }

    public void helper(int i , int[] arr , int tar , List<List<Integer>> ans, List<Integer> list){
        if(i == arr.length){
            if(tar == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(tar - arr[i] >= 0){
            list.add(arr[i]);
            helper(i , arr , tar - arr[i] , ans , list);
            list.remove(list.size()-1);
        }

        helper(i + 1 , arr , tar , ans , list);
    }
}