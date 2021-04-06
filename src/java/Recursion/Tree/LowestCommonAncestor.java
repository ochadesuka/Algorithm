package Recursion.Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

//236
public class LowestCommonAncestor {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,  p, q);
        return ans;
    }

    public boolean dfs(TreeNode node,  TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean current = node.val == p.val || node.val == q.val;
        boolean inLeft = dfs(node.left,p, q);
        boolean inRight = dfs(node.right, p, q);
        if ((inLeft && inRight) || (current && (inLeft || inRight))) {
            ans = node;
        }
        return inLeft || inRight || current;
    }
}
