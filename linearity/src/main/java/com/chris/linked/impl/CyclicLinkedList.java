package com.chris.linked.impl;


import org.w3c.dom.Node;

/**
 * 循环链表实现
 *
 * @author 史偕成
 * @date 2023/09/18 12:14
 **/
public class CyclicLinkedList<E> {

    Node<E> head;

    public CyclicLinkedList() {
        this.head = null;
    }

    // 在链表末尾添加一个节点
    public void append(E data) {
        Node<E> newNode = new Node<E>(data);
        if (head == null) {
            head = newNode;
            head.next = head; // 将头节点的下一个节点指向自身，形成循环
        } else {
            Node<E> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    /**
     * 在链表头部插入一个节点
     * @param data
     */
    public void prepend(E data) {
        Node<E> newNode = new Node<E>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node<E> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 删除指定值的节点
     * @param data
     */
    public void delete(E data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            Node<E> current = head;
            while (current.next != head) {
                current = current.next;
            }
            if (current == head) {
                // 如果只有一个节点，删除后为空链表
                head = null;
            } else {
                current.next = head.next;
                head = head.next;
            }
            return;
        }
        Node<E> current = head;
        while (current.next != head) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    /**
     * 显示链表中的所有节点
     */
    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }
        Node<E> current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        // 打印头节点的数据来表示循环结束
        System.out.println(head.data);
    }


    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        CyclicLinkedList<Integer> circularLinkedList = new CyclicLinkedList<Integer>();

        circularLinkedList.append(1);
        circularLinkedList.append(2);
        circularLinkedList.append(3);

        System.out.print("Circular Linked List: ");
        circularLinkedList.display(); // 输出：Circular Linked List: 1 -> 2 -> 3 -> 1

        circularLinkedList.prepend(0);

        System.out.print("Circular Linked List after prepend: ");
        circularLinkedList.display(); // 输出：Circular Linked List after prepend: 0 -> 1 -> 2 -> 3 -> 0

        circularLinkedList.delete(2);

        System.out.print("Circular Linked List after delete: ");
        circularLinkedList.display(); // 输出：Circular Linked List after delete: 0 -> 1 -> 3 -> 0
    }
}

