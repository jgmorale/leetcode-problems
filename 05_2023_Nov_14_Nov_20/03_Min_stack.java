// https://leetcode.com/problems/min-stack/description/
import java.util.*;

class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    // -2,0,-3 stack
    // -2,-3   minStack

    // 1,2,3,-1
    // 1,-1

    public MinStack() {
        this.minStack = new Stack<Integer>();
        this.stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if(this.minStack.isEmpty() || this.minStack.peek() >= this.stack.peek())
            this.minStack.push(val);
    }
    
    public void pop() {
        if(this.stack.peek() == this.minStack.peek()) this.minStack.pop();
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek(); 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
