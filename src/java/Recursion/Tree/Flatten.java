package Recursion.Tree;

import java.util.ArrayList;
import java.util.List;

//114
public class Flatten {
    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        TreeNode newNode = new TreeNode(0);
        TreeNode newNode2 = newNode;
        for (Integer i : list) {
            newNode.right = new TreeNode(i);
            newNode = newNode.right;
        }
        root =  newNode2.right;
    }

    public void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }

    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while(pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.right = next;
                cur.left = null;
            }
            cur = cur.right;
        }
    }



    public static void main(String[] args) {

    }
}
