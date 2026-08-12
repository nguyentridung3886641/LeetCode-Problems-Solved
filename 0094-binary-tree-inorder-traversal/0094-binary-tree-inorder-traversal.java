class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        listNode(root);
        return list;
    }
    public TreeNode listNode(TreeNode root) {
        if (root == null) return null;
        
        root.left = listNode(root.left);
        list.add(root.val);
        root.right = listNode(root.right);

        return root;
    }
}