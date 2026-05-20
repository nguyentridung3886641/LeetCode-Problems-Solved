class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return maxMinDepth(root) >= 0;
    }
    public int maxMinDepth(TreeNode node) {
        if (node == null) return 0;

        int left = maxMinDepth(node.left);
        if (left == - 1) return -1;
        
        int right = maxMinDepth(node.right);
        if (right == -1) return -1;

        return (Math.abs(left - right) <= 1) ? 1 + Math.max(left, right) : -1;
    }
}