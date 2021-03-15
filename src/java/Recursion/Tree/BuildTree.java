package Recursion.Tree;

import java.util.Arrays;

//105
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode();
        dfs(root, preorder, 0, inorder);
        return root;
    }

    public void dfs(TreeNode root, int[] preorder, int preIndex, int[] inorder) {
        if (preIndex == preorder.length) {
            return;
        }

        root.val = preorder[preIndex];
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i ++) {
            if (inorder[i] == preorder[preIndex]) {
                rootIndex = i;
            }
        }
        root.left = new TreeNode();


        dfs(root.left, preorder, ++preIndex, Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = new TreeNode();
        if (rootIndex+1 < inorder.length) {
            dfs(root.right,preorder, ++preIndex, Arrays.copyOfRange(inorder, rootIndex+1, inorder.length));
        }
    }
}
