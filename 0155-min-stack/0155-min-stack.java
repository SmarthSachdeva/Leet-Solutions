class MinStack {

  
    Stack<Integer> stack;
    Stack<Integer> minValue ;
    public MinStack() {
        stack = new Stack<>() ;
        minValue = new Stack<>() ;
    }

    public void push(int val) {
       stack.push(val);
       if(minValue.empty()) minValue.add(val) ;
       else{
           if(minValue.peek().intValue() >= val) minValue.push(val) ;
       }
    }

    public void pop() {
       Integer popVal = stack.pop();
       if (popVal.intValue() == minValue.peek()){
           minValue.pop() ;
       }
    }

    public int top() {
      return stack.peek() ;
    }

    public int getMin() {
        if(!minValue.empty())return minValue.peek() ;
        else return stack.peek();
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