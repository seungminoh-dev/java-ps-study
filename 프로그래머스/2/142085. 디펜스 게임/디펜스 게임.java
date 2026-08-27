import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int sum = 0;
        for(int ene:enemy){
            sum+=ene;
            q.offer(-ene);
            if(sum<=n){
                answer++;
                continue;
            }
            while(k>0 && !q.isEmpty() && n<sum){
                sum+=q.poll();
                k--;
            }
            if(sum<=n){
                answer++;
                continue;
            }else{
                break;
            }
        }
        
        return answer;
    }
}