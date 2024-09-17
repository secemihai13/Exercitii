package org.example.service.impl;

import org.example.dto.Node;
import org.example.service.BinaryTree;

import static java.util.Objects.isNull;

public class BinaryTreeImpl implements BinaryTree {

    private Node root;

    @Override
    public void insert(int data) {
        this.root = insertRecursive(this.root, data);
    }

    @Override
    public int findMaximum() {
        return findMaximumRecursive(this.root);
    }

    @Override
    public int calculateDepth() {
        return calculateDepthRecursive(this.root);
    }

    private static Node insertRecursive(Node root, int data) {
        if (isNull(root)) {
            return new Node(data);
        }
        if (data < root.getData()) {
            root.setLeft(insertRecursive(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(insertRecursive(root.getRight(), data));
        }
        return root;
    }

    private static int findMaximumRecursive(Node root) {
        if (isNull(root)) {
            return Integer.MIN_VALUE;
        }

        int max = root.getData();
        int leftMax = findMaximumRecursive(root.getLeft());
        int rightMax = findMaximumRecursive(root.getRight());

        int leftRightMax = Math.max(leftMax, rightMax);
        return Math.max(max, leftRightMax);
    }

    private static int calculateDepthRecursive(Node root) {
        if (isNull(root)) {
            return 0;
        }
        int leftDepth = calculateDepthRecursive(root.getLeft());
        int rightDepth = calculateDepthRecursive(root.getRight());

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
