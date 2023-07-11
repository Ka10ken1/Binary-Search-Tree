package com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class BST<T extends Comparable<T>> implements Node<T>{

    private T data;
    private Node<T> left;
    private Node<T> right;

    public BST(T data){
        this.data = data;
    }
    private Node<T> insert(Node<T> node,T data){
        if(node == null){
            return new BST<T>(data);
        }
        int compare = data.compareTo(node.getData());
        if(compare < 0){
            node.setLeft(insert(node.getLeft(),data));
        }
        else if (compare > 0){
            node.setRight(insert(node.getRight(),data));
        }
        return node;
    }

    private Node<T> remove(Node<T> node, T data){
        if(node == null){
            return null;
        }
        int compare = data.compareTo(node.getData());
        if(compare < 0){
            node.setLeft(remove(node.getLeft(), data));
        }
        else if (compare > 0){
            node.setRight(remove(node.getRight(), data));
        }
        else{
            if(node.getLeft() == null && node.getRight() == null){
                return null;
            }
            else if(node.getRight() == null){
                return node.getLeft();
            }
            else if(node.getLeft() == null){
                return node.getRight();
            }
            else{
                T min = findMin(node.getRight());
                node.setRight(remove(node.getRight(), min));
                node.setData(min);
            }
        }
        return node;
    }
    private T findMin(Node<T> node){
        if(node == null){
            throw new IllegalArgumentException();
        }

        if(node.getLeft() == null){
            return node.getData();
        }
       return findMin(node.getLeft());
    }

    private Node<T> invert(Node<T> node){
        if(node == null){
            return null;
        }
        Node<T> left = invert(node.getLeft());
        Node<T> right = invert(node.getRight());
        node.setLeft(right);
        node.setRight(left);
        return node;
    }
    private List<T> toList(Node<T> node){
        if(node == null){
            return new ArrayList<>();
        }
        List<T> list = new ArrayList<>(toList(node.getLeft()));
        list.add(node.getData());
        list.addAll(toList(node.getRight()));
        return list;
    }

    public Node<T> invert(){
        return invert(this);
    }

    @Override
    public Node<T> insert(T data) {
        return insert(this,data);
    }

    @Override
    public List<T> toList() {
        return toList(this);
    }

    @Override
    public Node<T> remove(T data) {
        return remove(this,data);
    }


    private int size(Node<T> node) {
        if(node == null){
            return 0;
        }
        return 1 + size(node.getRight()) + size(node.getLeft());
    }


    private int height(Node<T> node) {
        if(node == null){
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()),height(node.getRight()));
    }

    private T max(Node<T> node){
        if(node == null){
            throw new IllegalArgumentException();
        }
        if(node.getRight() == null){
            return node.getData();
        }
        return max(node.getRight());
    }


    public T  min(){
        return findMin(this);
    }

    public T max(){
        return max(this);
    }

    @Override
    public int height() {
        return height(this);
    }

    @Override
    public int size() {
        return size(this);
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    @Override
    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public Node<T> getLeft() {
        return left;
    }

    @Override
    public Node<T> getRight() {
        return right;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }
}

