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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       HashMap<TreeNode,TreeNode> map = new HashMap<>();
       mapParent(root,map);
       List<Integer> ans = new ArrayList<>();
       getNodes(target,k,map,new HashSet<>(),ans);
       return ans;
    }
    public void getNodes(TreeNode target, int k, HashMap<TreeNode,TreeNode> map, HashSet<TreeNode> set, List<Integer> list) {
        if(target==null) return;
        if(k==0) {
            list.add(target.val);
            return;
        }
        set.add(target);
        if(map.containsKey(target) && !set.contains(map.get(target))) getNodes(map.get(target),k-1,map,set,list);
        if(!set.contains(target.left)) getNodes(target.left,k-1,map,set,list);
        if(!set.contains(target.right)) getNodes(target.right,k-1,map,set,list);
        
    }
    public void mapParent(TreeNode root, HashMap<TreeNode,TreeNode> map) {
        if(root==null) return;
        if(root.left!=null) map.put(root.left,root);
        if(root.right!=null) map.put(root.right,root);
        mapParent(root.left,map);
        mapParent(root.right,map);
    }
}
    