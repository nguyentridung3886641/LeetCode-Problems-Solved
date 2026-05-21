class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curNode = root;

        if (p.val <= curNode.val && q.val >= curNode.val) return curNode;
        if (p.val >= curNode.val && q.val <= curNode.val) return curNode;

        if (p.val < curNode.val && q.val < curNode.val)
            curNode = lowestCommonAncestor(root.left, p, q);
        else
            curNode = lowestCommonAncestor(root.right, p, q);

        return curNode;
    }
}