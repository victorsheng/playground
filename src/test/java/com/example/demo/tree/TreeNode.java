package com.example.demo.tree;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    /**
     * 2
     * 3 4
     * 10  3 5
     * @return
     */
    public static TreeNode initTree() {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;

        TreeNode left1 = new TreeNode(10);

        left.left = left1;


        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(5);

        right.left = left2;
        right.right = right2;
        return root;
    }
}
