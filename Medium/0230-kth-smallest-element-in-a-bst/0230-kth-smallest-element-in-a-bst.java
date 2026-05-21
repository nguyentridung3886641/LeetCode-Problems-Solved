class Solution {
    int count = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }
    public void dfs(TreeNode node, int k) {
        if (node == null || count >= k) return;

        dfs(node.left, k);

        ++count;
        if (count == k) res = node.val;
        
        dfs(node.right, k);
    }
}