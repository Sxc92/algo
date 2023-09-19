package com.chris.stack;

import com.chris.stack.impl.LinkedStack;
import com.chris.stack.impl.QueueStack;

/**
 * @author 史偕成
 * @date 2023/09/18 13:30
 **/
public class Case {

    public static void main(String[] args) {
        LinkedStack<Integer> queueStack = new LinkedStack<Integer>();
        for (int i = 0; i < 10; i++) {
            queueStack.push(i);
            System.out.println("当前栈顶：" + queueStack.peek());
        }
        System.out.println("开始出栈------------------------");
        for (int i = 1; i <= 10; i++) {
            System.out.println("当前准备出栈：" + queueStack.peek());
            if (queueStack.isEmpty()) {
                System.out.println("出栈完成");
                return;
            }
            queueStack.pop();
            System.out.println("出栈" + (i + 1) + "次完成， 栈顶：" + (queueStack.peek() == null ? "队列已经出战完成" : queueStack.peek()));
        }


    }


}
