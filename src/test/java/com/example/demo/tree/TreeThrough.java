package com.example.demo.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://www.jianshu.com/p/456af5480cee
 * 深度遍历有前序、中序以及后序三种遍历方法
 * 广度遍历即我们平常所说的层次遍历
 * <p>
 * <p>
 * 先序：考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根左右)
 * <p>
 * 中序：考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左根右)
 * <p>
 * 后序：考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左右根)
 */
public class TreeThrough {
    private BinaryTreeNode root;


    // 递归前序遍历
    public void preOrder(BinaryTreeNode current) {
        if (current != null) {
            System.out.println(current.info);
            preOrder(current.llink);
            preOrder(current.rlink);
        }
    }




    // 非递归前序遍历
    public void nonRecursivePreOrder() {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!stack.isEmpty())) {
            if (current != null) {
                System.out.println(current.info);
                stack.push(current);
                current = current.llink;
            } else {
                current = (BinaryTreeNode) stack.peek();
                stack.pop();
                current = current.rlink;
            }
        }
    }

    public static void preorderTraversal(TreeNode root) {
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                System.out.print(node.value + " ");
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }

//    public void qianXu(BinaryTreeNode current) {
//        if (current != null) {
//            System.out.println(current.info);
//            preOrder(current.llink);
//            preOrder(current.rlink);
//        }
//    }

    public void nonRecursiveQianxu() {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current;
        current = root;
        if (current != null || !stack.isEmpty()) {
            if (current != null) {
                System.out.println(current.info);
                stack.push(current);
                current = current.llink;
            } else {
                current = stack.pop();
                current = current.rlink;
            }
        }
    }


    // 递归中序遍历
    public void inOrder(BinaryTreeNode current) {
        if (current != null) {
            inOrder(current.llink);
            System.out.println(current.info);
            inOrder(current.rlink);
        }
    }

    // 非递归中序遍历
    public void nonRecursiveInOrder() {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!stack.empty())) {
            if (current != null) {
                stack.push(current);
                current = current.llink;
            } else {
                current = (BinaryTreeNode) stack.peek();
                stack.pop();
                System.out.println(current.info);
                current = current.rlink;
            }
        }
    }


    // 递归后序遍历
    public void postOrder(BinaryTreeNode current) {
        if (current != null) {
            postOrder(current.llink);
            postOrder(current.rlink);
            System.out.println(current.info);
        }
    }

    // 非递归后序遍历
    public void notRecursivePostOrder() {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!stack.isEmpty())) {
            if (current != null) {
                current.isFirst = true;
                stack.push(current);
                current = current.llink;
            } else {
                current = stack.peek();
                stack.pop();
                if (current.isFirst) {
                    current.isFirst = false;
                    stack.push(current);
                    current = current.rlink;
                } else {
                    System.out.println(current.info);
                    current = null;
                }
            }
        }
    }

    // 树的层次遍历
    public void bfs() {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!queue.isEmpty())) {
            if (current != null) {
                System.out.println(current.info);
                queue.add(current.llink);
                queue.add(current.rlink);
                current = queue.poll();
            } else {
                current = queue.poll();
            }
        }
    }

    public class BinaryTreeNode {
        private BinaryTreeNode llink = null;
        private BinaryTreeNode rlink = null;
        private int info;
        private boolean isFirst;

        public BinaryTreeNode(int info) {
            this.info = info;
        }
    }

    public void initTree() {
        root = new BinaryTreeNode(1);
        root.llink = new BinaryTreeNode(2);
        root.rlink = new BinaryTreeNode(3);
        root.llink.llink = null;
        root.llink.rlink = new BinaryTreeNode(4);
        root.rlink.llink = new BinaryTreeNode(11);
        root.rlink.rlink = new BinaryTreeNode(111);
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public static void main(String[] args) {
        TreeThrough tree = new TreeThrough();
        tree.initTree();
//        tree.nonRecursiveInOrder();
        tree.preOrder(tree.getRoot());
        tree.nonRecursivePreOrder();
        // tree.inOrder(tree.getRoot());
        // tree.nonRecursiveInOrder();
        // tree.postOrder(tree.getRoot());
        // tree.notRecursivePostOrder();
//        tree.bfs();
    }
}