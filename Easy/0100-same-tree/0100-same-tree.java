class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p == null && q == null) return true;
        if (isSameTree(p.left, q.left) == false) return false;
        if (isSameTree(p.right, q.right) == false) return false;
        return p.val == q.val;
    }
}