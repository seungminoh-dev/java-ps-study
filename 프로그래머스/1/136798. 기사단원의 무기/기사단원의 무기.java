class Solution {
    public int solution(int number, int limit, int power) {
        
        int answer = 0;
        for(int j=1;j<=number;j++){
            int count = 0;
            for(int i=1;i<=j;i++){
                if (j%i==0){
                    count++;
                }
            }
            answer += count>limit ? power : count;
        }
        
        return answer;
    }
}