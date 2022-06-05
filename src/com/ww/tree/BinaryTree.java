package com.ww.tree;

import java.util.Arrays;
import java.util.LinkedList;

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
     * 前序遍历
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

    public static void main(String[] args) {
        LinkedList inputList = new LinkedList(Arrays.asList(new Integer[]{1, 4, 9, null, null, 2, null, null, 8, null, 5}));
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createBinaryTree(inputList);
        System.out.println(root.getData());
        System.out.println("前序遍历：");
        binaryTree.preOrderTraveral(root);
        System.out.println("中序遍历");
        binaryTree.inOrderTraveral(root);
        System.out.println("后续遍历");
        binaryTree.postOrderTraveral(root);
    }
}
