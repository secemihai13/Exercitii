package org.example;

import lombok.Getter;
import org.example.service.BinaryTreeService;
import org.example.service.impl.BinaryTreeServiceImpl;

@Getter
public class Exercitiul1 {

    private final BinaryTreeService tree;

    public Exercitiul1(BinaryTreeService tree) {
        this.tree = tree;
    }

    public static void main(String[] args) {
        var ex1 = new Exercitiul1(new BinaryTreeServiceImpl());

        ex1.getTree().insert(-9);
        ex1.getTree().insert(2);
        ex1.getTree().insert(5);
        ex1.getTree().insert(3);
        ex1.getTree().insert(11);
        ex1.getTree().insert(10);
        ex1.getTree().insert(100);

        System.out.println("Maximum value = " + ex1.getTree().findMaximum());
        System.out.println("Depth = " + ex1.getTree().calculateDepth());
    }
}
