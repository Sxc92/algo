package com.chris.linked.impl;

/**
 * 双向链表
 *
 * @author 史偕成
 * @date 2023/09/18 11:33
 **/
public class DoubleLinkedList<E> {
    /**
     * 头节点
     */
    Node<E> head;

    /**
     * 尾节点
     */
    Node<E> tail;

    public DoubleLinkedList(Node<E> head) {
        this.head = null;
        this.tail = null;
    }

    // 在链表末尾添加一个节点
    public void append(E data) {
        Node<E> newNode = new Node<E>(data, null, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.pre = tail;
            tail.next = newNode;
        }
        tail = newNode;
    }

    // 在链表头部插入一个节点
    public void prepend(E data) {
        Node<E> newNode = new Node<E>(data, null, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        }
    }

    // 删除指定值的节点
    public void delete(E data) {
        Node<E> current = head;
        while (current != null) {
            if (current.node == data) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.pre = null;
                    }
                } else if (current == tail) {
                    tail = current.pre;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.pre.next = current.next;
                    current.next.pre = current.pre;
                }
                return;
            }
            current = current.next;
        }
    }

    // 显示链表中的所有节点
    public void display() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.node + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    private static class Node<E> {

        E node;

        Node<E> pre;

        Node<E> next;

        public Node(E node, Node<E> pre, Node<E> next) {
            this.node = node;
            this.pre = pre;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        DoubleLinkedList<Integer> data = new DoubleLinkedList<>(new Node<>(1, null, null));
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
