class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidSubBST(root, null, null);
    }
    public boolean isValidSubBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;

        if (isValidSubBST(node.left, min, node.val) == false)
            return false;
        if (isValidSubBST(node.right, node.val, max) == false) 
            return false;

        return true;
    }
}