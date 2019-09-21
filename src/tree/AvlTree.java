package com.clo.dsa.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * com.clo.dsa.tree.AvlTree
 *
 * @author Cloneable
 * @date 2019/9/14 11:22:14
 * @description Avl tree
 */
public class AvlTree {
    private Node root;

    public Node insertNode(Node node, int num) {
        if (node == null) {
            Node leaf = new Node(num);
            if (root == null) {
                root = leaf;
            }
            return leaf;
        }

        if (num < node.data) {
            node.left = insertNode(node.left, num);
        } else if (num > node.data) {
            node.right = insertNode(node.right, num);
        } else {
            return node;
        }

        int balance = getBalance(node);

        if (balance > 1 && num < node.left.data) {
            rotateRight(node);
        } else if (balance < -1 && num > node.right.data) {
            rotateLeft(node);
        } else if (balance > 1 && num > node.left.data) {
            rotateLeft(node.left);
            rotateRight(node);
        }

        node.height = updateNodeHeight(node);

        return node;
    }

    private int getNodeHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    public List<Node> sortNode() {
        List<Node> nodes = new ArrayList<>();
        getSortNodes(nodes, root);
        return nodes;
    }

    private void getSortNodes(List<Node> sortNodes, Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sortNodes.add(node);
            return;
        }

        getSortNodes(sortNodes, node.left);
        sortNodes.add(node);
        getSortNodes(sortNodes, node.right);
    }

    public int getBalance(Node node) {
        return getNodeHeight(node.left) - getNodeHeight(node.right);
    }

    public Node getRoot() {
        return root;
    }

    public int getHeight() {
        return root.height;
    }

    public void rotateRight(Node rRoot) {
        Node pivot = rRoot.left;
        Node pivotR = pivot.right;

        pivot.right = rRoot;
        rRoot.left = pivotR;

        updateRotateNodeState(rRoot, pivot);
    }

    private void updateRotateNodeState(Node rRoot, Node pivot) {
        rRoot.height = updateNodeHeight(rRoot);
        pivot.height = updateNodeHeight(pivot);

        if (rRoot == root) {
            root = pivot;
        }
    }

    private int updateNodeHeight(Node rRoot) {
        return 1 + Math.max(getNodeHeight(rRoot.left), getNodeHeight(rRoot.right));
    }

    public void rotateLeft(Node rRoot) {
        Node pivot = rRoot.right;
        Node pivotL = pivot.left;

        pivot.left = rRoot;
        rRoot.right = pivotL;

        updateRotateNodeState(rRoot, pivot);
    }

    public class Node {
        public final int data;
        private Node left;
        private Node right;
        private int height = 1;

        public Node(int data) {
            this.data = data;
        }
    }
}
