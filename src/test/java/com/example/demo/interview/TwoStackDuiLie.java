package com.example.demo.interview;

import java.util.Stack;

public class TwoStackDuiLie {
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            int ret = stack2.pop();
            while(!stack2.empty()){
                stack1.push(stack2.pop());
            }
            return ret;
        }
    }
}
