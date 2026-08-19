import java.util.*;

class Solution {
    public long solution(int n) {
        // long answer = 0;
        // Queue<Integer> numberQ = new LinkedList<>();
        // // n: 1~2000
        // if(n==1)
        //     return (long)1;
        // numberQ.add(1);
        // numberQ.add(2);
        // while(!numberQ.isEmpty()){
        //     int number = numberQ.poll();
        //     // target은 n이다.
        //     if(number == n){
        //         answer+=1;
        //     }else if(number == n-1){
        //         answer+=1;
        //     }else if(number == n-2){
        //         answer+=2;
        //     }else{
        //         numberQ.add(number+1);
        //         numberQ.add(number+2);
        //     }
        // }
        
        long[] way = new long[2001];
        // way[n] = way[n-1]+way[n-2] Pibonachi(유사)
        way[1] = 1;
        way[2] = 2;
        for(int i=3;i<=2000;i++){
            way[i] = way[i-1]%1234567+way[i-2]%1234567;
        }
        return way[n]%1234567;
    }
}