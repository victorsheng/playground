package com.example.demo.tree;

public class SubTree {
    public static boolean IsSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null)//必须先判断pRoot2
            return true;
        if (root1 == null)
            return false;
        if (root1.value != root2.value)
            return false;
        return IsSubTree(root1.left, root2.left) && IsSubTree(root1.right, root2.right);


    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.value == root2.value)//判断根节点是否相等，如果相等进一步判断他们的子树是否也相等
                result = IsSubTree(root1, root2);
            if (!result)//如果之前根节点不相等，继续遍历整个树
                result = (HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2));

        }
        return result;

    }
}
