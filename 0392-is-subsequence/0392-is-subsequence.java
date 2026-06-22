class Solution {
    public boolean isSubsequence(String s, String t) {
        Stack<Character> st = new Stack<>();
        Stack<Character> ss = new Stack<>();
        for(int i=t.length()-1; i>=0; i--){
            st.push(t.charAt(i));
        }
        for(int i=s.length()-1; i>=0; i--){
            ss.push(s.charAt(i));
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            while(!st.isEmpty()){
                if(st.pop() == c){
                    ss.pop();
                    break;
                }
            }
        }
        return ss.isEmpty();
    }
}