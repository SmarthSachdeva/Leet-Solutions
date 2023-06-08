/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> main = new ArrayDeque<>();
        Queue<TreeNode> helper = new ArrayDeque<>();

        List<Integer> temp = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        main.add(root);

        while(main.size()!=0){
            TreeNode rem = main.remove();
            temp.add(rem.val);
            if(rem.left!=null) helper.add(rem.left);
            if(rem.right!=null) helper.add(rem.right);

            if(main.size() == 0){
                ans.add(Collections.max(temp));
                temp = new ArrayList<>();
                main = helper;
                helper = new ArrayDeque<>();
            }
        }

        return ans;
    }
}