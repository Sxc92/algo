package com.chris.stack.impl;

import java.util.LinkedList;

/**
 * 利用LinkedList 链表实现
 *
 * @author 史偕成
 * @date 2023/09/18 13:40
 **/
public class LinkedStack<E> {

    private LinkedList<E> linkedList;

    public LinkedStack() {
        linkedList = new LinkedList<>();
    }

    /**
     * 入栈
     *
     * @param data
     */
    public void push(E data) {
        linkedList.addFirst( data);
    }

    /**
     * 出栈
     *
     * @return
     */
    public E pop() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("stack is empty, cannot pop");
        }
        return linkedList.removeFirst();
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    public E peek() {
        if (linkedList.isEmpty()) {
            throw new IllegalStateException("stack is empty, cannot pop");
        }
        return linkedList.getFirst();
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * 获取栈的大小
     *
     * @return
     */
    public int size() {
        return linkedList.size();
    }
}
