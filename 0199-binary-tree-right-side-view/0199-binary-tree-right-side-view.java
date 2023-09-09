class Solution {
    public List<List<Integer>> linewise(TreeNode root){
        Queue<TreeNode> main = new ArrayDeque<>();
        Queue<TreeNode> helper = new ArrayDeque<>();

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        main.add(root);

        while(main.size()>0){
            TreeNode rem = main.poll();
            temp.add(rem.val);

            if(rem.left!=null) helper.add(rem.left);
            if(rem.right!=null) helper.add(rem.right);

            if(main.size() == 0){
                main = helper;
                list.add(temp);

                helper = new ArrayDeque<>();
                temp = new ArrayList<>();
            }
        }
        return list;
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> list = linewise(root);
        List<Integer> ans = new ArrayList<>();

        for(List<Integer> temp : list){
            ans.add(temp.get(temp.size()-1));
        }

        return ans;
    }
}