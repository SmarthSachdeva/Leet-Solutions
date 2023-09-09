class Solution {
    public void helper(TreeNode root, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> list) {
        if (root == null) {
            return;
        }

        currentPath.add(root.val);

        if (root.left == null && root.right == null) {
            // If it's a leaf node, add the currentPath to the result list
            list.add(new ArrayList<>(currentPath));
        } else {
            // Otherwise, continue exploring the left and right subtrees
            helper(root.left, currentPath, list);
            helper(root.right, currentPath, list);
        }

        // Remove the current node from the currentPath before returning to the parent
        currentPath.remove(currentPath.size() - 1);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        helper(root , new ArrayList<>() , list);

        for(ArrayList<Integer> list1 : list){
            int sum = 0;
            for(int vl : list1)
            {
                sum+=vl;
            }
            if(sum == targetSum) return true;
        }

        return false;
    }
}