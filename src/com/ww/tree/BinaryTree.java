package com.ww.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树：
 * 满二叉树：一个二叉树所有非叶子节点都存在左右孩子，并且叶子节点都在统一层级。
 * 完全二叉树：如果有12个元素，这12个元素按照满二叉树排列即可。
 * 链式存储结构实现
 *      每个node包括：data,left,right
 * 数组实现：
 *      按照层级顺序把二叉树的节点放到数组对应位置，如果某一节点的左孩子或者右孩子为空，相应位置应该空出来
 *      父节点的下标为parent，则左孩子下标为：2*parent+1，右孩子下标为2*parent+2
 *      孩子节点下标为child，则父节点坐标为：（child-1）/2
 * 主要应用：
 *      查抄操作：二叉查找树（binary search tree）
 *                  如果左子树不为空，则左子树所有节点的值均小于跟节点的值
 *                  如果右子树不为空，则右子树所有节点的值均大于跟节点的值
 *                  左右子树也都是二叉查找树
 *              对于一个节点分布均匀的二叉查找树，搜索节点的时间复杂度为O（logn）,树的深度
 *      维持相对顺序：二叉排序树（binary sort tree）
 *                  二叉树自平衡：红黑树，AVL树，树堆
 *遍历：
 *      深度优先：前序遍历，中序遍历，后序遍历
 *      广度优先：层序遍历
 */
public class BinaryTree {
    /**
     * 递归构建二叉树
     * 没有的节点请用null占位
     * @param inputList
     * @return
     */
    public TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();//取出list中的第一个元素
        if (data != null) {//如果为空则返回，不继续构建，
            node = new TreeNode(data);
            node.setLeftChild(createBinaryTree(inputList));//构建左子树
            node.setRightChild(createBinaryTree(inputList));//构建右子树
        }
        return node;
    }

    /**
     * 前序遍历（递归）
     * @param node
     */
    public void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData()+" ");//先打印跟节点
        preOrderTraveral(node.getLeftChild());//遍历左子树
        preOrderTraveral(node.getRightChild());//遍历右子树
    }

    /**
     * 前序遍历（非递归）
     * 使用栈的回朔特点，递归模式都可以使用栈
     * 1。输出节点信息
     * 2。节点入栈
     * 3。访问节点左孩子，有左孩子回到第一步，没有左孩子并且栈内存在元素则取出栈顶元素，访问右孩子，重复第一步
     * @param root
     */
    public void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();//创建栈存储节点
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {//节点不为空或者栈不为空。
            while (node != null) {//循环访问左孩子并入栈
                System.out.print(node.getData() + " ");
                stack.push(node);//将该节点压入栈中
                node = node.getLeftChild();//遍历左孩子
            }
            if (!stack.isEmpty()) {//没有左孩子时，出栈，并访问右孩子
                node = stack.pop();
                node = node.getRightChild();
            }
        }
    }
    /**
     * 中序遍历
     * @param node
     */
    public void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.getLeftChild());
        System.out.print(node.getData());
        inOrderTraveral(node.getRightChild());
    }

    /**
     * 中序遍历（栈）
     * @param root
     */
    public void inOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeftChild();
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.getData());
                node = node.getRightChild();
            }
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.getLeftChild());
        postOrderTraveral(node.getRightChild());
        System.out.print(node.getData());
    }

    /**
     * 后续遍历（非递归）
     *
     * @param root
     */
    public void postOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode re = null;//避免遍历已经遍历过的左子树
        while (node != null || !stack.isEmpty()) {
            while (node != null) {//遍历到最左的节点
                stack.push(node);
                node = node.getLeftChild();
            }
            if (!stack.isEmpty()) {//栈内还有元素
                node = stack.peek();//拿到栈顶元素
                TreeNode right = node.getRightChild();//获取栈顶的左孩子
                if (right != null && right != re) {//右孩子不为空，并且不等于上一个输出的节点
                    stack.push(right);//右孩子入栈
                    node = right.getLeftChild();//遍历以右孩子为根节点的子树
                } else {//右孩子为空，证明栈顶元素无子节点或者是右节点
                    node = stack.pop();//栈顶元素出栈
                    System.out.print(node.getData());
                    re = node;//记录输出的节点
                    node = null;//当前节点打印完毕，置空
                }

            }
        }
    }

    /**
     * 层级遍历：
     * 使用队列
     * @param root
     */
    public void levelOrderTraveral(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();//创建队列
        queue.offer(root);//根节点进入队列
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();//出队列
            System.out.print(node.getData());//输出数据
            if (node.getLeftChild() != null) {//左孩子非空，左孩子进入队列
                queue.offer(node.getLeftChild());
            }
            if (node.getRightChild() != null) {//右孩子非空，右孩子进入队列
                queue.offer(node.getRightChild());
            }
        }
    }


    public static void main(String[] args) {
        LinkedList inputList = new LinkedList(Arrays.asList(new Integer[]{1, 4, 9, null, null, 2, null, null, 8, null, 5}));
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createBinaryTree(inputList);
        System.out.println(root.getData());
        System.out.println("前序遍历：");
        binaryTree.preOrderTraveral(root);
        System.out.println();
        binaryTree.preOrderTraveralWithStack(root);
        System.out.println();
        System.out.println("中序遍历");
        binaryTree.inOrderTraveral(root);
        System.out.println();
        binaryTree.inOrderTraveralWithStack(root);
        System.out.println();
        System.out.println("后续遍历");
        binaryTree.postOrderTraveral(root);
        System.out.println();
        binaryTree.postOrderTraveralWithStack(root);
        System.out.println();
        System.out.println("层级遍历");
        binaryTree.levelOrderTraveral(root);
    }
}
