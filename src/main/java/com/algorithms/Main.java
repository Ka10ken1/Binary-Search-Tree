package com.algorithms;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>(0);
        bst.insert(2);
        bst.insert(-1);
        bst.insert(3);
        System.out.println(bst.toList());
        bst.invert();
        System.out.println(bst.toList());
    }
}
