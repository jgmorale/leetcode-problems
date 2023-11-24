// https://leetcode.com/problems/implement-stack-using-queues/

import java.util.*;

class MyStack {
    private Queue<Integer> q = new LinkedList<Integer>();
    public MyStack() {
    }
    
    public void push(int x) {
        q.add(x);
        for(int i=0; i < q.size()-1;i++){
            q.add(q.remove());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
