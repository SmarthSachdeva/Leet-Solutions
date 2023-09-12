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

    public List<List<Integer>> helper(TreeNode root) {
        Queue<TreeNode> main = new ArrayDeque<>();
        Queue<TreeNode> helper = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inans = new ArrayList<>();
        
        if(root == null) return ans;
        main.add(root);

        while(main.size()>0){
            TreeNode rem = main.remove();
            inans.add(rem.val);
            
            if(rem.left != null) helper.add(rem.left);
            if(rem.right != null) helper.add(rem.right);

            if(main.size() == 0){
                ans.add(inans);
                main = helper;
                helper = new ArrayDeque<>();
                inans = new ArrayList<>();
            }
        }
        return ans;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> list = helper(root);
        List<List<Integer>> ans = new ArrayList<>();
        int level = 1;
        for(List<Integer> temp : list){
            if(level%2==0){
                Collections.reverse(temp);
                
            }
            ans.add(temp);
            level++;
        }
        return ans;
    }
}