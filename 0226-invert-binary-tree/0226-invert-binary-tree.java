class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode node) {
        //base case: return if node is null
        if (node == null) return;

        //Recursively invert left subtree
        invert(node.left);

        //Recursively invert right subtree
        invert(node.right);

        //Swap left and right children
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}