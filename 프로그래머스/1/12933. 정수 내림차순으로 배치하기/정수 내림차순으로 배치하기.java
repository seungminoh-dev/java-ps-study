import java.util.*;

class Solution {
    public long solution(long n) {
        String target = String.valueOf(n);
        List<Integer> mlist = new ArrayList<>();
        for(int i=0;i<target.length();i++){
            mlist.add(target.charAt(i)-'0');
        }
        Collections.sort(mlist);
        int jarisu = 0;
        long answer = 0;
        for(int val : mlist){
            answer += (long)val * (int)Math.pow(10,jarisu++);
        }
        return answer;
    }
}