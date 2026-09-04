import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        //y에서 선택 가능한 연산 /2 /3 -n 이 있음
        int[] ansMap = new int[y+1];
        for(int i=0;i<ansMap.length;i++)
            ansMap[i]=-1;
        Queue<Integer> q = new ArrayDeque<>();
        ansMap[y]=0;
        q.offer(y);
        while(!q.isEmpty()){
            int temp = q.poll();
                // 나누기 2 가능?
                if(temp%2==0){
                    if(ansMap[temp/2]==-1){
                        ansMap[temp/2]=ansMap[temp]+1;
                        q.offer(temp/2);
                    }
                }
                // 나누기 3 가능?
                if(temp%3==0){
                    if(ansMap[temp/3]==-1){
                        ansMap[temp/3]=ansMap[temp]+1;
                        q.offer(temp/3);
                    }
                }
                // 빼기 가능?
                if(temp-n>0){
                    if(ansMap[temp-n]==-1){
                        ansMap[temp-n]=ansMap[temp]+1;
                        q.offer(temp-n);
                    }
                }
            
        }
        return ansMap[x];
    }
}