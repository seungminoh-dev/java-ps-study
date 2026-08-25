import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> gyul = new HashMap<>();
        for(int g: tangerine){
            gyul.put(g,gyul.getOrDefault(g,0)+1);
        }
        List<Integer> key = new ArrayList<>(gyul.keySet());
        key.sort((e1,e2)->gyul.get(e2).compareTo(gyul.get(e1)));
        int targetLeft = k;
        for(int i=0;i<key.size();i++){
            targetLeft-=gyul.get(key.get(i));
            answer++;
            if(targetLeft<=0)
                break;
        }
        return answer;
    }
}