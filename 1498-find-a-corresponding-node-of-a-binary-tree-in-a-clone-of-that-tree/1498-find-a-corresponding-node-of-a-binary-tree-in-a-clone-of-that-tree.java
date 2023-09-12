/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode o, final TreeNode c, final TreeNode t) {
        return helper(o , c, t);
    }
    public TreeNode helper(TreeNode p1 , TreeNode p2 , TreeNode tar){
        if(p1==null)
        return null;

        if(p1 == tar)
        return p2;

        TreeNode left = helper(p1.left , p2.left , tar);
        if(left!=null)
        return left;

        TreeNode right = helper(p1.right , p2.right , tar);
        if(right!=null)
        return right;

        return null;
    }
}