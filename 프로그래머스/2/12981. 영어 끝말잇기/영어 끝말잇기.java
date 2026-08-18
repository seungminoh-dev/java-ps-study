import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String,Integer> beforeDict = new HashMap<>();
        char before = words[0].charAt(0);
        int issue_turn = -1;
        for(int i=0;i<words.length;i++){
            String word = words[i];
            // 문자 일치 여부
            char after = word.charAt(0);
            if(before!=after){
                issue_turn = i;
                break;
            }else{
                before = word.charAt(word.length()-1);
            }
            // 이전 등장 여부
            if (beforeDict.containsKey(word)){
                issue_turn = i;
                break;
            }else{
                beforeDict.put(word,1);
            }
        }
        if (issue_turn==-1){
            return new int[]{0,0};
        }
        int who = issue_turn%n+1;
        int round = issue_turn / n +1;
        int[] answer = new int[2];
        answer[0]=who;
        answer[1]=round;
      
        return answer;
    }
}