class Solution {
    public int calPoints(String[] operations) {
      Stack<Integer> stack = new Stack<>();
      for(String s : operations){
        if(s.equals("+")){
            int top = stack.pop();
            int peek = stack.peek();
            stack.push(top);
            stack.push(top + peek);
        }
        else if(s.equals("D")){
            stack.push(stack.peek()*2);
        }else if(s.equals("C")){
            stack.pop();
        }else{
            stack.push(Integer.parseInt(s));
        }
      } 
      int sum = 0;
      while(!stack.isEmpty()){
        sum += stack.pop();
      }
      return sum;
    }
}