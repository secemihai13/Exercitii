package org.example.service.impl;

import org.example.dto.Node;
import org.example.service.BinaryTree;

import java.util.NoSuchElementException;

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

    private static Node insertRecursive(Node node, int data) {
        if (isNull(node)) {
            return new Node(data);
        }
        if (data < node.getData()) {
            node.setLeft(insertRecursive(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(insertRecursive(node.getRight(), data));
        }
        return node;
    }

    private static int findMaximumRecursive(Node root) {
        if (isNull(root)) {
            throw new NoSuchElementException("No value present");
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
