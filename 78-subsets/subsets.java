class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        helper(0 , nums , new ArrayList<>() , subsets);

        return subsets;
    }

    public void helper(int i , int[] arr ,List<Integer> list, List<List<Integer>> subsets){
        if(i == arr.length){
            subsets.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[i]);
        helper(i+1 , arr , list , subsets);

        list.remove(list.size() - 1);
        helper(i+1 , arr , list , subsets);
    }
}