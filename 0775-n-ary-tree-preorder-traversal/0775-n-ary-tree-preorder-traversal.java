/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void helper(List<Integer> list , Node root){
        list.add(root.val);
        for(Node c : root.children){
            helper(list , c);
        }
    }
    public List<Integer> preorder(Node root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(list , root);
        return list;
    }
}