package Recursion.Tree;

import java.util.ArrayList;
import java.util.List;

//102
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        bfs(root, ans, 0);
        return ans;
    }

    public void bfs(TreeNode node, List<List<Integer>> ans, int level) {
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        if(node.left != null) {
            bfs(node.left, ans, level+1);
        }
        if (node.right != null) {
            bfs(node.right, ans, level+1);
        }
    }
}
