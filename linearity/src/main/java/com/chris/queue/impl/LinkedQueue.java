package com.chris.queue.impl;

import java.util.LinkedList;

/**
 * @author 史偕成
 * @date 2023/09/18 14:00
 **/
public class LinkedQueue<T> {

    private LinkedList<T> queue;


    public LinkedQueue() {
        this.queue = new LinkedList<>();
    }

    /**
     * 入队操作
     *
     * @param value
     */
    public void enqueue(T value) {
        queue.addLast(value);
    }

    /**
     * 出队操作
     *
     * @return
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("队列为空，无法出队");
        }
        return queue.removeFirst();
    }

    /**
     * 查看队头元素
     *
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return queue.getFirst();
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * 获取队列的大小
     *
     * @return
     */
    public int size() {
        return queue.size();
    }
}
