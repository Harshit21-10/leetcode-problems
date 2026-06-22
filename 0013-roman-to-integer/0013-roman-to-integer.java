class Solution {
    public int romanToInt(String s) {
       Stack<Character> st = new Stack<>();
       int sum = 0;
       for(int i=s.length()-1; i>=0; i--){
        char ch = s.charAt(i);
        if(!st.isEmpty() && ch == 'I' && (st.peek() == 'V' || st.peek() == 'X')){
            sum -= 1;
        }
        else if(!st.isEmpty() && ch == 'X' && (st.peek() == 'L' || st.peek() == 'C')){
            sum -= 10;
        }
        else if(!st.isEmpty() && ch == 'C' && (st.peek() == 'D' || st.peek() == 'M')){
            sum -= 100;
        }else{
            if(ch == 'I'){
                sum += 1;
            }
            else if(ch == 'V'){
                sum += 5;
            }
            else if(ch == 'X'){
                sum += 10;
            }
            else if(ch == 'L'){
                sum += 50;
            }
            else if(ch == 'C'){
                sum += 100;
            }
            else if(ch == 'D'){
                sum += 500;
            }
            else if(ch == 'M'){
                sum += 1000;
            }
        }
        st.push(ch);
       } 
       return sum;
    }
}