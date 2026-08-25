import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] inputSeq = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if (checkSeq(inputSeq,i)) answer++;
        }
        return answer;
    }
    public boolean checkSeq(char[] seq, int index){
        //올바른 괄호 문자열 검사 로직
        Stack<Integer> stack = new Stack<>();
        int seqLength = seq.length;
        int count = 0;
        for(int i=index%seqLength;count<seqLength;i=(i+1)%seqLength){
            char c = seq[i];
            if( c == '[' || c == '(' || c=='{'){
                stack.push((int)c);
            }else{
                if(stack.size()>0){
                    char match = (char)(int)stack.pop();
                    switch(c){
                        case ']'-> {if (match!='[') return false;}
                        case ')'-> {if (match!='(') return false;}
                        case '}'-> {if (match!='{') return false;}
                    }
                }
                else
                    return false;
            }
            count++;
        }
        if (stack.size()>0) return false;
        return true;
    }
}