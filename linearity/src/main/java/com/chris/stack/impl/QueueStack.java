package com.chris.stack.impl;

import com.chris.queue.impl.LinkedQueue;

/**
 * 链表实现栈
 *
 * @author 史偕成
 * @date 2023/09/18 14:04
 **/
public class QueueStack<T> {

    private LinkedQueue<T> queue;

    public QueueStack() {
        this.queue = new LinkedQueue<>();
    }

    public void push(T x) {
        queue.enqueue(x);
        int cnt = queue.size();
        while (cnt-- > 1) {
            queue.enqueue(queue.dequeue());
        }
    }

    public T pop() {
        return queue.dequeue();
    }

    public T top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
