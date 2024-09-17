package org.example.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void solution() {
        assertEquals(-1, Solution.solution(new int[]{}));
        assertEquals(-1, Solution.solution(null));

        assertEquals(140, Solution.solution(new int[]{130, 191, 200, 10}));
        assertEquals(600, Solution.solution(new int[]{405, 45, 300, 300}));
        assertEquals(-1, Solution.solution(new int[]{50, 222, 49, 52, 25}));
        assertEquals(9918, Solution.solution(new int[]{30, 909, 3190, 99, 3990, 9009}));

        assertEquals(18208, Solution.solution(new int[]{9199, 3190, 3190, 99, 3990, 9009}));
    }
}
