public class Solution {
    public int evalRPN(String[] a) {
        Stack<Integer> stk = new Stack<Integer>();
        for(int i = 0; i < a.length; i++) {
            if(a[i].equals("+"))
                stk.push(stk.pop() + stk.pop());
            else if(a[i].equals("-"))
                stk.push(- stk.pop() + stk.pop());
            else if(a[i].equals("*"))
                stk.push(stk.pop() * stk.pop());
            else if(a[i].equals("/"))
                stk.push((int) (1.0 / stk.pop() * stk.pop()));
            else
                stk.push(Integer.valueOf(a[i]));
        }
        return stk.pop();
    }
}
