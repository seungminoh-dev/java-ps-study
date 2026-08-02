import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> scoreMap = new HashMap<>();
        // 단어 - 점수 사전을 만든다.
        for(int i=0;i<name.length;i++){
            String key = name[i];
            int value = yearning[i];
            scoreMap.put(key,value);
        }
        // 정답 구하기
        int[] answer = new int[photo.length];
        int tempScore = 0;
        String[] photoE = null;
        for(int i=0;i<photo.length;i++){
            photoE = photo[i];
            tempScore=0;
            for(String nameE : photoE){
                tempScore+=scoreMap.getOrDefault(nameE,0);
            }
            answer[i]=tempScore;
        }
        return answer;
    }
}