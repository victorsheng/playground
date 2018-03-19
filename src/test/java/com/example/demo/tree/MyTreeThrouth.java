package com.example.demo.tree;

import java.util.Stack;

public class MyTreeThrouth {


    public void pre(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            pre(root.left);
            pre(root.right);
        }
    }

    public void pre2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = root;
        while (now != null || !stack.isEmpty()) {
            while (now != null) {
                stack.push(now);
                System.out.println(now.value);
                now = now.left;
            }

            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                now = pop.right;
            }
        }

    }


    public void bfs(TreeNode root) {

    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.initTree();
        MyTreeThrouth myTreeThrouth = new MyTreeThrouth();
        myTreeThrouth.pre(treeNode);
        myTreeThrouth.pre2(treeNode);
    }
}
