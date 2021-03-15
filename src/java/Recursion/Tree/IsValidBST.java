package Recursion.Tree;
//98
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
}

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode node, Integer up, Integer down) {
        if (node == null) {
            return true;
        }

        if (down != null && node.val < down) {
            return false;
        }
        if (up != null && node.val > up) {
            return false;
        }

        return dfs(node.left, node.val, down) && dfs(node.right, up, node.val);
    }
}
