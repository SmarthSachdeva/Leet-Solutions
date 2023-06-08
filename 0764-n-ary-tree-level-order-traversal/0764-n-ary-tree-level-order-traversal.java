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
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        Queue<Node> main = new ArrayDeque<>();
        Queue<Node> helper = new ArrayDeque<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        main.add(root);

        while(main.size()!=0){
            Node rem = main.remove();
            list.add(rem.val);
            for(Node child : rem.children){
                helper.add(child);
            }

            if(main.size() == 0){
                ans.add(list);
                list = new ArrayList<>();
                main = helper;
                helper = new ArrayDeque<>();
            }
            
        }

        return ans;
    }
}