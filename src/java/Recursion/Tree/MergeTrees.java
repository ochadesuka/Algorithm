package Recursion.Tree;
//617
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode newRoot = new TreeNode(0);
        return merge(newRoot, root1, root2);
    }

    public TreeNode merge(TreeNode node, TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return null;
        }

        if (r1 != null && r2 != null) {
            node = new TreeNode(r1.val + r2.val);
            node.left = merge(node.left, r1.left, r2.left);
            node.right = merge(node.right, r1.right, r2.right);
        }else if(r1 != null && r2 == null) {
            node = new TreeNode(r1.val);
            node.left = merge(node.left, r1.left, null);
            node.right = merge(node.right, r1.right, null);
        }else if (r1 == null && r2 != null) {
            node = new TreeNode(r2.val);
            node.left = merge(node.left, null, r2.left);
            node.right = merge(node.right, null, r2.right);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(3);
        r1.right = new TreeNode(2);
        r1.left.left = new TreeNode(5);

        TreeNode r2 = new TreeNode(2);
        r2.left = new TreeNode(1);
        r2.right = new TreeNode(3);
        r2.left.right = new TreeNode(4);
        r2.right.right = new TreeNode(7);

        MergeTrees m = new MergeTrees();
        System.out.println(m.mergeTrees(r1, r2).val);
    }
}
