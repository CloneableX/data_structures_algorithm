package com.clo.dsa.tree;

import org.junit.Test;

/**
 * com.clo.dsa.tree.BinaryTreeTest
 *
 * @author Cloneable
 * @date 2019/8/10 17:27:10
 * @description
 */
public class BinaryTreeTest {
    @Test
    public void printNodesBeforeTest() {
        int[] nodes = new int[]{-1, 5, 3, 8, 7, 2, 9, 6};
        BinaryTree binaryTree = new BinaryTree(nodes);
        binaryTree.printNodesBefore(binaryTree.root);
    }

    @Test
    public void printNodesInTest() {
        int[] nodes = new int[]{-1, 5, 3, 8, 7, 2, 9, 6};
        BinaryTree binaryTree = new BinaryTree(nodes);
        binaryTree.printNodesIn(binaryTree.root);
    }

    @Test
    public void printNodesAfterTest() {
        int[] nodes = new int[]{-1, 5, 3, 8, 7, 2, 9, 6};
        BinaryTree binaryTree = new BinaryTree(nodes);
        binaryTree.printNodesAfter(binaryTree.root);
    }
}
