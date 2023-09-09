class Solution {
    void solve(TreeNode root1, TreeNode root2, int h){
        if(root1==null) return;
        // Swap if level is odd
        if(h%2==1){
            int temp = root1.val;
            root1.val = root2.val;
            root2.val = temp;
        }
        // In first call, left children of root1 is called with right children of root2
        solve(root1.left, root2.right, h+1);
        // In second call, right children of root1 is called with left children of root2
        solve(root1.right, root2.left, h+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        solve(root.left, root.right, 1);
        return root;
    }
}
// Please upvote just in case this solution helped you somehow.
