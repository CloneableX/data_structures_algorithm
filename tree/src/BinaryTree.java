package com.clo.dsa.tree;

/**
 * com.clo.dsa.tree.BinaryTree
 *
 * @author Cloneable
 * @date 2019/8/10 17:05:10
 * @description
 */
public class BinaryTree {
    private class Node {
        private Node left;
        private Node right;
        private int data;


        public Node(int data) {
            this.data = data;
        }

        public void buildChildren(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    public Node root;

    public BinaryTree(int[] nodes) {
        root = buildTree(1, nodes);
    }

    private Node buildTree(int currIndex, int[] nodes) {
        if(currIndex >= nodes.length || nodes[currIndex] < 0) {
            return null;
        }

        Node node  = new Node(nodes[currIndex]);
        node.buildChildren(buildTree(currIndex * 2, nodes),buildTree(currIndex * 2 + 1, nodes));

        return node;
    }

    public void printNodesBefore(Node node) {
        if(node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return;
        }

        System.out.print(node.data + " ");
        System.out.print(node.data + "'s left:");
        printNodesBefore(node.left);
        System.out.print(node.data + "'s right:");
        printNodesBefore(node.right);
    }

    public void printNodesIn(Node node) {
        if(node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return;
        }

        System.out.print(node.data + "'s left:");
        printNodesIn(node.left);
        System.out.print(node.data + " ");
        System.out.print(node.data + "'s right:");
        printNodesIn(node.right);
    }

    public void printNodesAfter(Node node) {
        if(node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return;
        }

        System.out.print(node.data + "'s left:");
        printNodesAfter(node.left);
        System.out.print(node.data + "'s right:");
        printNodesAfter(node.right);
        System.out.print(node.data + " ");
    }
}
