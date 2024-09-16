package org.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Node {

    private final int data;

    @Setter
    private Node left;
    @Setter
    private Node right;
}
