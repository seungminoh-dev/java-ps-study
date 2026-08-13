import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> day = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0){
                day.add( (100-progresses[i])/speeds[i]);
            }else{
                day.add( (100-progresses[i])/speeds[i]+1);
            }
        }
        List<Integer> dList = new ArrayList<>();
        int beforehigh = day.remove();
        int dcount = 1;
        while(!day.isEmpty()){
            int temp = day.remove();
            if (beforehigh < temp){
                dList.add(dcount);
                beforehigh = temp;
                dcount = 1;
            }
            else{
                dcount++;
            }
        }
        dList.add(dcount);
        int[] answer = new int[dList.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]  = dList.get(i);
        }
        return answer;
    }
}