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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> main = new ArrayDeque<>();
        Queue<TreeNode> helper = new ArrayDeque<>();
        
        main.add(root);
        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while(!main.isEmpty()){
            TreeNode rem = main.poll();
            list2.add(rem.val);
            
            if(rem.left != null) helper.add(rem.left);
            if(rem.right != null) helper.add(rem.right);
            
            if(main.size() == 0){
                main = helper;
                helper= new ArrayDeque<>();
                list.add(list2);
                list2 = new ArrayList<>();
            }
        }
        Collections.reverse(list);
        return list;
    }
}