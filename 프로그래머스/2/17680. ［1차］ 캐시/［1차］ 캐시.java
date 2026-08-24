import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize==0)
            return 5 * cities.length;
        Map<String,Boolean> cache = new LinkedHashMap<>(16,0.75f,true);
        int eleCount = 0;
        for(int i=0;i<cities.length;i++){
            //대소문자 정규화
            String city = cities[i].toLowerCase();
            //Cache Hit 검사
            if (cache.get(city) != null){
                answer+=1;
            }else{
                //eleCount = cacheSize 이면 제거하고 삽입 필요
                if(cache.size() == cacheSize){
                    String removeTargetKey = cache.keySet().iterator().next();
                    eleCount--;
                    cache.remove(removeTargetKey);
                }
                cache.put(city,true);
                eleCount++;
                answer+=5;
            }
        }
        return answer;
    }
}