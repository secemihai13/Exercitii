package org.example.service.impl;

import org.example.service.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeImplTest {

    private BinaryTree underTest;

    @BeforeEach
    void init() {
        this.underTest = new BinaryTreeImpl();

        this.underTest.insert(5);
        this.underTest.insert(3);
        this.underTest.insert(2);
        this.underTest.insert(10);
        this.underTest.insert(11);
    }

    @Test
    void findMaximum() {
        assertEquals(11, this.underTest.findMaximum());
    }

    @Test
    void calculateDepth() {
        assertEquals(3, this.underTest.calculateDepth());
    }
}
