package com.chris.stack.impl;

/**
 * @author 史偕成
 * @date 2023/09/18 13:31
 **/
public class ArrayStack<E> {
    /**
     * 栈数据
     */
    private E[] stack;
    /**
     * 栈顶指针
     */
    private int top;

    public ArrayStack(int capacity) {
        // 创建泛型数组，需要使用反射
        // 这里使用强制类型转换
        stack = (E[]) new Object[capacity];
        // 初始化栈顶指针为-1
        top = -1;
    }

    /**
     * 入栈操作
     *
     * @param value
     */
    public void push(E value) {
        if (top == stack.length - 1) {
            System.out.println("栈已满，无法入栈");
            return;
        }
        stack[++top] = value;
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public E pop() {
        if (isEmpty()) {
            System.out.println("栈为空，无法出栈");
            // 返回一个特殊值表示出错
            return null;
        }
        return stack[top--];
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public E peek() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        }
        return stack[top];
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 获取栈的大小
     *
     * @return
     */
    public int size() {
        return top + 1;
    }
}
