import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        //HashMap 종류별 옷 가지수 저장용
        Map<String,Integer> myClothes = new HashMap<>();
        //Listup
        for(String[] val : clothes){
            if(myClothes.containsKey(val[1])){
                myClothes.put(val[1],myClothes.get(val[1])+1);
            }else{
                myClothes.put(val[1],1);
            }
        }
        //계산
        for(String key : myClothes.keySet()){
            answer*=(myClothes.get(key)+1);
        }
        answer-=1;
        return answer;
    }
}