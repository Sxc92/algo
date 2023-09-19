package com.chris.queue.impl;

import com.chris.stack.impl.LinkedStack;

import java.util.Stack;

/**
 * 利用栈实现队列
 * 需要两个列表进行转换
 *
 * @author 史偕成
 * @date 2023/09/18 14:28
 **/
public class StackQueue<T> {

    private LinkedStack<T> in = new LinkedStack<>();
    private LinkedStack<T> out = new LinkedStack<>();

    public void push(T x) {
        in.push(x);
    }

    public T pop() {
        in2out();
        return out.pop();
    }

    public T peek() {
        in2out();
        return out.peek();
    }

    /**
     * 重点转换方法
     */
    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
