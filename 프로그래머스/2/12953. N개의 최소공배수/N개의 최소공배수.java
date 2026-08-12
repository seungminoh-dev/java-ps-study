import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int[] flag = new int[101];
        for(int val : arr){
            for(int i=2;i<=val;i++){
                int count = 0;
                while(val%i==0){
                    val /= i;
                    count++;
                }
                flag[i] = Math.max(count,flag[i]);
            }
        }
        int answer = 1;
        for(int i=1;i<=100;i++){
            answer*=Math.pow(i,flag[i]);
        }
        return answer;
    }
}