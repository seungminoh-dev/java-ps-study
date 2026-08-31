import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        // 1.5 2 4/3
        Map<Integer,Integer> weight = new HashMap<>();
        for(int ele: weights){
            if(weight.containsKey(ele))
                weight.put(ele,weight.get(ele)+1);
            else
                weight.put(ele,1);
        }
        for(int ele: weight.keySet()){
            long count = weight.get(ele);
            int target1 = ele *2;
            int target2 = ele * 3 % 2 ==0 ? ele*3 /2 : -1;
            int target3 = ele * 4 % 3 == 0 ? ele * 4 / 3 : -1;
            if (weight.containsKey(target1))
                answer+=count*weight.get(target1);
            if (weight.containsKey(target2))
                answer+=count*weight.get(target2);
            if (weight.containsKey(target3))
                answer+=count*weight.get(target3);
            if (weight.get(ele)>1)
                answer+=count*(count-1)/2;
        }
        return answer;
    }
}