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

	public int evalRPN2(String[] tokens) {
		Stack<String> stk = new Stack<String>();
		if (tokens == null || tokens.length == 0)
			return 0;
		String operators = "+-*/";
		for(String i : tokens) {
			if (!operators.contains(i)) {
				stk.push(i);
			} else {
				int a = Integer.valueOf(stk.pop());
				int b = Integer.valueOf(stk.pop());
				switch(i){
				case "+": stk.push(String.valueOf(a + b)); break;
				case "-": stk.push(String.valueOf(b - a)); break;
				case "*": stk.push(String.valueOf(a * b)); break;
				case "/": stk.push(String.valueOf(b / a));
				}
			}
		}
		return Integer.valueOf(stk.pop());
    }
}
