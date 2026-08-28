import java.util.*;

class Solution {
    
    public int solution(int[] topping) {
        Map<Integer,Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();
        int typeRight = 0;
        int typeLeft = 0;
        int answer = 0;
        for(int ele : topping){
            if (right.containsKey(ele)){
                right.put(ele, right.get(ele)+1);
            }else{
                right.put(ele,1);
            }
        }
        typeRight = right.size();
        for(int i=0;i<topping.length-1;i++){
            int ele = topping[i];
            if(!left.contains(ele)){
                left.add(ele);
                typeLeft++;
            }
            right.put(ele,right.get(ele)-1);
            if (right.get(ele)==0)
                typeRight--;
            if (typeLeft==typeRight)
                answer++;
        }
        return answer;
    }
}