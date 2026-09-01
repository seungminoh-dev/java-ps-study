class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey!=0){
            //0이 없을때까지 처리
            while(storey%10==0)
                storey/=10;
            int last = storey % 10;
            if(last==5){
                int last2 = (storey-last)/10%10;
                if (last2>=5){
                    answer+=(10-last);
                    storey+=(10-last);
                    continue;
                }
            }
            if (last>5){
                answer+=(10-last);
                storey+=(10-last);
            }else{
                answer+=last;
                storey-=last;
            }
        }
        return answer;
    }
}