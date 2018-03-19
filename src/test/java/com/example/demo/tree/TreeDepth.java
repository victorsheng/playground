package com.example.demo.tree;

import java.util.LinkedList;

public class TreeDepth {

    /**
     * 遍历实现
     *
     * @param pRoot
     * @return
     */
    public int depth(TreeNode pRoot) {
        if (pRoot == null)
            return 0;
        return Math.max(depth(pRoot.left), depth(pRoot.right)) + 1;
    }


    /**
     * 非递归实现
     * 相当于按照层次遍历树结构
     *
     * @param root
     * @return
     */
    public int findDeep2(TreeNode root) {
        if (root == null)
            return 0;

        TreeNode current = null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur, last;
        int level = 0;
        while (!queue.isEmpty()) {
            cur = 0;//记录本层已经遍历的节点个数  
            last = queue.size();//当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数  
            while (cur < last)//当还没有遍历到本层最后一个节点时循环
            {
                current = queue.poll();//出队一个元素  
                cur++;
                //把当前节点的左右节点入队（如果存在的话）  
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            level++;//每遍历完一层level+1  
        }
        return level;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree();
        TreeDepth treeDepth = new TreeDepth();
        int depth = treeDepth.findDeep2(root);
        System.out.println(depth);


    }


}
