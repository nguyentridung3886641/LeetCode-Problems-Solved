import java.util.*;

class Solution {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildSubTree(preorder, 0, inorder.length - 1, map);
    }
    public TreeNode buildSubTree(int[] preorder, int start, int end, HashMap<Integer, Integer> map) {
        if (start > end) return null;

        int rootVal = preorder[index++];
        int inorderIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left = buildSubTree(preorder, start, inorderIndex - 1, map);
        root.right = buildSubTree(preorder, inorderIndex + 1, end, map);

        return root;
    }
}