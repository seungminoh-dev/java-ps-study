import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> mySet = new HashSet<>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                mySet.add(numbers[i]+numbers[j]);
            }
        }
        List<Integer> myList = new ArrayList<>(mySet);
        Collections.sort(myList);
        int[] answer = new int[myList.size()];
        for(int i=0;i<myList.size();i++){
            answer[i]=myList.get(i);
        }
        return answer;
    }
}