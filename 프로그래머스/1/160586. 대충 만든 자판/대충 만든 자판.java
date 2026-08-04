import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Integer,Integer> valueMap = new HashMap<>();
        int kkey = 0;
        int kvalue = 0;
        for(String key : keymap){
            for(int i=0;i<key.length();i++){
                kkey=(int)key.charAt(i);
                kvalue=i+1;
                valueMap.put(kkey,Math.min(kvalue,valueMap.getOrDefault(kkey,999)));
                
            }
       
        }
        int ans_temp = 0;
        int ans_sum=-1;
        int[] ans = new int[targets.length];
        int cur = 0;
        for(String target:targets){
            ans_sum=0;
            for(int i=0;i<target.length();i++){
                ans_temp = valueMap.getOrDefault((int)target.charAt(i),-1);
                if(ans_temp==-1){
                    ans_sum=-1;
                    break;
                }else{
                    ans_sum+=ans_temp;
                }
            }
            ans[cur]=ans_sum;
            cur++;
            
        }
        return ans;
    }
}