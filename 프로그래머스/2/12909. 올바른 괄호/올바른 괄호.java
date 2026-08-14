class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int n_stack = 0;
        for(int i=0;i<s.length();i++){
            char tile = s.charAt(i);
            if(tile=='('){
                n_stack++;
            }else{
                n_stack--;
            }
            if(n_stack<0){
                break;
            }
        }
        if(n_stack!=0)
            answer=false;
        return answer;
    }
}