package com.chris.queue;

import com.chris.queue.impl.StackQueue;
import com.chris.stack.impl.LinkedStack;

import java.util.Stack;

/**
 * @author 史偕成
 * @date 2023/09/18 13:56
 **/
public class Case {

    public static void main(String[] args) {
//        StackQueue<Integer> stackQueue = new StackQueue<Integer>();
//        for (int i = 0; i < 10; i++) {
//            stackQueue.push(i);
//        }
//        System.out.println(stackQueue.peek());
//        stackQueue.pop();
//        System.out.println(stackQueue.peek());
//        stackQueue.pop();
//        System.out.println(stackQueue.peek());

        // 2.0 利用栈 匹配括号
        System.out.println(isValid("()[{}"));
    }

    /**
     * 校验括号
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cStack = stack.pop();
                boolean b1 = c == ')' && cStack != '(';
                boolean b2 = c == ']' && cStack != '[';
                boolean b3 = c == '}' && cStack != '{';
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
