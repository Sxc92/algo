package com.chris.queue.impl;

/**
 * @author 史偕成
 * @date 2023/09/18 13:56
 **/
public class ArrayQueue<E> {

    private E[] queue;
    // 队头指针
    private int front;
    // 队尾指针
    private int rear;
    // 队列的当前大小
    private int size;
    // 队列的容量
    private int capacity;


    public ArrayQueue(int capacity) {
        this.queue = (E[]) new Object[0];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
    }


    /**
     * 入队操作
     *
     * @param value
     */
    public void enqueue(E value) {
        if (isFull()) {
            throw new IllegalStateException("队列已满，无法入队");
        }
        rear = (rear + 1) % capacity; // 环形队列，考虑循环
        queue[rear] = value;
        size++;
    }

    /**
     * 出队操作
     *
     * @return
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("队列为空，无法出队");
        }
        E value = (E) queue[front];
        // 环形队列，考虑循环
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    /**
     * 查看队头元素
     *
     * @return
     */
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("队列为空");
        }
        return (E) queue[front];
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * 获取队列的大小
     *
     * @return
     */
    public int size() {
        return size;
    }
}
