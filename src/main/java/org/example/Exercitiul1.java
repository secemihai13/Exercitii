package org.example;

import lombok.Getter;
import org.example.service.BinaryTree;
import org.example.service.impl.BinaryTreeImpl;

@Getter
public class Exercitiul1 {

    private final BinaryTree tree;

    public Exercitiul1(BinaryTree tree) {
        this.tree = tree;
    }

    public static void main(String[] args) {
        var ex1 = new Exercitiul1(new BinaryTreeImpl());

        ex1.getTree().insert(5);
        ex1.getTree().insert(3);
        ex1.getTree().insert(2);
        ex1.getTree().insert(10);
        ex1.getTree().insert(11);

        System.out.println("Maximum value = " + ex1.getTree().findMaximum());
        System.out.println("Depth = " + ex1.getTree().calculateDepth());
    }
}
