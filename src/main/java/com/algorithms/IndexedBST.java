package com.algorithms;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
public class IndexedBST<T extends Comparable<T>> implements Node<T> {

    private T data;
    private Node<T> left;
    private Node<T> right;
    private int size;

    public IndexedBST(T data) {
        this.data = data;
        this.size = 1;
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new IndexedBST<>(data);
        }

        int compareResult = data.compareTo(node.getData());

        if (compareResult < 0) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (compareResult > 0) {
            node.setRight(insert(node.getRight(), data));
        }

        node.setSize(1 + size(node.getLeft()) + size(node.getRight()));

        return node;
    }

    private Node<T> remove(Node<T> node, T data) {

        if (node == null) {
            return null;
        }

        int compareResult = data.compareTo(node.getData());

        if (compareResult < 0) {
            node.setLeft(remove(node.getLeft(), data));
        } else if (compareResult > 0) {
            node.setRight(remove(node.getRight(), data));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else if (node.getLeft() == null) {
                return node.getRight();
            } else {
                T min = findMin(node.getRight());
                node.setRight(remove(node.getRight(), min));
                node.setData(min);
            }
        }

        node.setSize(1 + size(node.getLeft()) + size(node.getRight()));

        return node;
    }

    private T findMin(Node<T> node) {
        if (node == null) {
            throw new IllegalArgumentException();
        }

        if (node.getLeft() == null) {
            return node.getData();
        }
        return findMin(node.getLeft());
    }

    private Node<T> findAtIndex(Node<T> node, int index) {
        if (node == null) {
            return null;
        }

        int leftSize = size(node.getLeft());

        if (index < leftSize) {
            return findAtIndex(node.getLeft(), index);
        } else if (index == leftSize) {
            return node;
        } else {
            return findAtIndex(node.getRight(), index - (leftSize + 1));
        }
    }
    private int getIndex(Node<T> node, T data) {
        if (node == null) {
            return -1;
        }

        int compareResult = data.compareTo(node.getData());

        if (compareResult < 0) {
            return getIndex(node.getLeft(), data);
        } else if (compareResult > 0) {
            int index = getIndex(node.getRight(), data);
            if (index == -1) {
                return -1;
            }
            int leftSize = size(node.getLeft());
            return leftSize + 1 + index;
        } else {
            return size(node.getLeft());
        }
    }
    public T getElementAtIndex(int index) {
        Node<T> node = findAtIndex(this, index);
        if (node != null) {
            return node.getData();
        }
        throw new IndexOutOfBoundsException("Index out of range");
    }

    public int getIndex(T data) {
        return getIndex(this, data);
    }

    @Override
    public Node<T> insert(T data) {
        return insert(this, data);
    }

    @Override
    public Node<T> remove(T data) {
        return remove(this, data);
    }

    @Override
    public int size() {
        return size(this);
    }

    @Override
    public int height() {
        return height(this);
    }


    private int size(Node<T> node) {
        if(node == null){
            return 0;
        }
        return 1 + size(node.getRight()) + size(node.getLeft());
    }


    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
    private List<Pair<Integer, T>> toList(Node<T> node, int startIndex) {
        List<Pair<Integer, T>> list = new ArrayList<>();
        if (node != null) {
            list.addAll(toList(node.getLeft(), startIndex));
            list.add(new Pair<>(startIndex + size(node.getLeft()), node.getData()));
            list.addAll(toList(node.getRight(), startIndex + size(node.getLeft()) + 1));
        }
        return list;
    }

    @Override
    public T getData() {
        return data;
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
    public List<?> toList() {
        return toList(this,this.size);
    }

    @Override
    public void setData(T data) {

    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
