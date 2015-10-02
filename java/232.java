/**
 * Implement the following operations of a queue using stacks. 
 * 		push(x) -- Push element x to the back of queue.p
 * 		pop() -- Removes the element from in front of queue.p
 * 		peek() -- Get the front element.
 * 		empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * @author Jun
 *
 */
 
class MyQueue {
    Stack<Integer> tmp = new Stack<Integer>();
    Stack<Integer> result = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        if(result.empty()) {
            result.push(x);
            return;
        }
        while(!result.empty())
            tmp.push(result.pop());
        result.push(x);
        while(!tmp.empty())
            result.push(tmp.pop());
        return;
    }

    // Removes the element from in front of queue.
    public void pop() {
        result.pop();
    }

    // Get the front element.
    public int peek() {
        return result.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return result.empty();
    }
}
