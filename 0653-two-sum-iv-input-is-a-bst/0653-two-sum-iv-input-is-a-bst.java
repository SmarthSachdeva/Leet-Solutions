class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        
        Set<Integer> set = new HashSet<>();
        
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int complement = k - current.val;
            
            if (set.contains(complement)) {
                return true; 
            }
            
            set.add(current.val);
            
            if (current.left != null) {
                queue.add(current.left);
            }
            
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return false;
    }
}
