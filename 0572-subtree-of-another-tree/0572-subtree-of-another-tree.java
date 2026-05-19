class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (root.val == subRoot.val)
            if (isSameTree(root, subRoot) == true) return true;
        if (isSubtree(root.left, subRoot) == true) return true;
        if (isSubtree(root.right, subRoot) == true) return true;
        return false;
    }
    public boolean isSameTree(TreeNode q, TreeNode p) {
        if (q == null && p != null || q != null && p == null) return false;
        if (q == null && p == null) return true;
        if (isSameTree(q.left, p.left) == false) return false;
        if (isSameTree(q.right, p.right) == false) return false;
        return q.val == p.val;
    }
}