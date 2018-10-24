package com.example.demo.tree;

import java.util.Stack;

public class MirrorTree {

    /**
     *
     二叉树的镜像定义：源二叉树
     8
     /  \
     6   10
     / \  / \
     5  7 9 11
     镜像二叉树
     8
     /  \
     10   6
     / \  / \
     11 9 7  5

     *
     */

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public class Solution {
            public void Mirror(TreeNode root) {
                if (root == null || (root.left == null && root.right == null))
                    return;
                //递归
        /*TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);*/
                //非递归
                Stack<TreeNode> stack = new Stack<TreeNode>();
                stack.push(root);
                while (!stack.empty()) {
                    TreeNode tree = stack.peek();
                    stack.pop();
                    if (tree.left != null || tree.right != null) {
                        TreeNode tmp = tree.left;
                        tree.left = tree.right;
                        tree.right = tmp;
                    }
                    if (tree.right != null)
                        stack.push(tree.right);
                    if (tree.left != null)
                        stack.push(tree.left);

                }
            }
        }
    }
}
