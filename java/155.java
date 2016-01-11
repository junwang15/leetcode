package leetcode;

import java.util.Stack;

public class MinStack {
	class Node {
		int val;
		int curMin;	// minimum before push this node
		Node(int val, int min) {
			this.val = val;
			curMin = min;
		}
	}
	
	int min;
	Stack<Node> stk;
	MinStack() {
		stk = new Stack<Node>();
		min = Integer.MAX_VALUE;
	}
	
    public void push(int x) {
    	stk.push(new Node(x, min));
        min = Math.min(x, min);
    }

    public void pop() {
    	if(stk.isEmpty())
    		return;
        Node temp = stk.pop();
        if(min == temp.val)
        	min = temp.curMin;
    }

    public int top() {
    	if(stk.isEmpty())
    		return Integer.MAX_VALUE;
        return stk.peek().val;
    }

    public int getMin() {
        return min;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack ms = new MinStack();
		ms.push(5);ms.push(2);ms.push(4);ms.push(1);
		System.out.println(ms.getMin() + ":1");
		ms.pop();
		System.out.println(ms.getMin() + ":2");
		System.out.println(ms.top() + ":4");
	}

}
