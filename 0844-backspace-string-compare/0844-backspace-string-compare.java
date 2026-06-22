class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> tt = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!ss.isEmpty() && s.charAt(i) == '#'){
                ss.pop();
            }else{
                if(s.charAt(i)=='#') continue;
                ss.push(s.charAt(i));
            }
        }
        for(int i=0; i<t.length(); i++){
            if(!tt.isEmpty() && t.charAt(i) == '#'){
                tt.pop();
            }else{
                if(t.charAt(i)=='#') continue;
                tt.push(t.charAt(i));
            }
        }
        String s1 ="";
        String t1 ="";
        while(!ss.isEmpty() || !tt.isEmpty()){
            if(!ss.isEmpty()) s1 = ss.pop() + s1;
            if(!tt.isEmpty()) t1 = tt.pop() + t1;
        }
        return s1.equals(t1);
    }
}