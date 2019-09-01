package com.clo.dsa.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * com.clo.dsa.tree.BinarySearchTree
 *
 * @author Cloneable
 * @date 2019/9/1 14:14:01
 * @description Binary Search Tree demo
 */
public class BinarySearchTree {
    public Node root;

    public BinarySearchTree(int[] nums) {
        Arrays.stream(nums).forEach(this::insert);
    }

    public Node search(int num) {
        Node curr = root;
        while (curr != null) {
            if (num < curr.value) {
                curr = curr.left;
            } else if (num > curr.value) {
                curr = curr.right;
            } else {
                break;
            }
        }
        return curr;
    }

    public String sortedPrint() {
        List<Node> nodes = new ArrayList<>();
        sortedNodes(root, nodes);
        StringBuffer print = new StringBuffer();
        for (int i = 0; ; i++) {
            print.append(nodes.get(i).value);
            if (i > nodes.size() - 2) {
                break;
            }
            print.append(",");
        }
        return print.toString();
    }

    private void sortedNodes(Node node, List<Node> sortedNodes) {
        if (node == null) {
            return;
        }

        sortedNodes(node.left, sortedNodes);
        sortedNodes.add(node);
        sortedNodes(node.right, sortedNodes);
    }

    public void insert(int num) {
        if (root == null) {
            root = new Node(num);
            return;
        }

        Node curr = root;
        while (curr != null) {
            if (num < curr.value) {
                if (curr.left == null) {
                    curr.left = new Node(num);
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new Node(num);
                    break;
                }
                curr = curr.right;
            }
        }
    }

    public void delete(int num) {
        Node curr = root;
        Node pNode = null;

        while (curr != null) {
            if (num < curr.value) {
                pNode = curr;
                curr = curr.left;
            } else if (num > curr.value) {
                pNode = curr;
                curr = curr.right;
            } else {
                break;
            }
        }

        if (curr == null) {
            return;
        }

        if (curr.isLeaf()) {
            deleteNode(curr, pNode, null);
        } else if (curr.left != null && curr.right != null) {
            Node minNode = findMinFromNode(curr.right);
            delete(minNode.value);
            minNode.left = curr.left;
            minNode.right = curr.right;

            deleteNode(curr, pNode, minNode);
        } else if (curr.left != null) {
            deleteNode(curr, pNode, curr.left);
        } else {
            deleteNode(curr, pNode, curr.right);
        }
    }

    private void deleteNode(Node curr, Node pNode, Node replaceNode) {
        if (pNode == null) {
            root = replaceNode;
        } else if (pNode.left == curr) {
            pNode.left = replaceNode;
        } else {
            pNode.right = replaceNode;
        }
    }

    private Node findMinFromNode(Node node) {
        Node curr = node;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
    }
}
