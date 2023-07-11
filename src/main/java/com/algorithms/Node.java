package com.algorithms;
import java.util.List;
public interface Node<T> {
    Node<T> insert(T data);
    Node<T> remove(T data);

    int size();

    int height();

    T getData();

    void setLeft(Node<T> left);

    void setRight(Node<T> right);

    Node<T> getLeft();

    Node<T> getRight();

    List<?> toList();
    void setData(T data);

   default void setSize(int i){

   }
}
