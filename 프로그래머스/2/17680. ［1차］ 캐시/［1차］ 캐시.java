import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String,Integer> cache = new HashMap<>();
        int searchIndex = 0;
        if (cacheSize==0)
            return 5*cities.length;
        while(searchIndex<cities.length){
            String target = cities[searchIndex].toLowerCase();
            if(cache.getOrDefault(target,-1)==-1){
                // 교체 알고리즘
                if(cache.size()>=cacheSize){
                    int min = 99999999;
                    String targetKey = "";
                    for(String key : cache.keySet()){
                        if (cache.get(key)<min){
                            targetKey = key;
                            min = cache.get(key);
                        }
                    }
                    cache.remove(targetKey); 
                }
                cache.put(target,searchIndex+1);
                answer+=5;
                searchIndex++;
            }else{
                answer+=1;
                cache.put(target,searchIndex+1);
                searchIndex++;
            }
        }
        
        return answer;
    }
}