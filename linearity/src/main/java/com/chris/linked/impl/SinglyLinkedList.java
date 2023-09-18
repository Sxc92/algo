package com.chris.linked.impl;


/**
 * 单向链表结构
 *
 * @author 史偕成
 * @date 2023/09/17 23:04
 **/
public class SinglyLinkedList<T> {

    Node<T> headNode;

    public SinglyLinkedList(Node<T> node) {
        this.headNode = node;
    }

    /**
     * 在链表最后进行追加
     *
     * @param data
     */
    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (headNode == null) {
            headNode = newNode;
            return;
        }
        Node<T> current = headNode;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * 删除指定值的节点
     *
     * @param data
     */
    public void delete(T data) {
        if (headNode == null) {
            return;
        }
        // 如果需要删除的就是头节点，将下一个数据赋给头节点，结束走人
        if (headNode.data == data) {
            headNode = headNode.next;
            return;
        }
        Node<T> current = headNode;
        // 如果不是循环去找  知道找到为止
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }


    /**
     * 在链表头部添加元素
     *
     * @param data
     */
    public void prepend(T data) {
        // 需要插入的数据
        Node<T> newNode = new Node<>(data);
        // 将当前链表中的头节点设置为新增数据的下一个节点
        newNode.next = headNode;
        headNode = newNode;
    }


    public void display() {
        Node<T> current = headNode;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * 私有的内部类
     *
     * @param <T>
     */
    private static class Node<T> {

        /**
         * 数据域
         */
        public T data;

        /**
         * 指针域，指向下一个节点
         */
        public Node<T> next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> data = new SinglyLinkedList<>(new Node<>(1));
        data.append(2);
        data.append(3);
        data.append(4);
        data.append(5);
        data.prepend(6);

        data.display();

        data.delete(4);

        data.display();
    }
}


