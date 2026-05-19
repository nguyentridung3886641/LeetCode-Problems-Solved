class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return root.val == subRoot.val && isSameTree(root, subRoot)
            || isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }
    public boolean isSameTree(TreeNode q, TreeNode p) {
        if (q == null && p != null || q != null && p == null) return false;
        if (q == null && p == null) return true;
        if (isSameTree(q.left, p.left) == false) return false;
        if (isSameTree(q.right, p.right) == false) return false;
        return q.val == p.val;
    }
}