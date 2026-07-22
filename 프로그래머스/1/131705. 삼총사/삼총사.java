class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int student = number.length;
        for(int i=0;i<student-2;i++){
            for(int j=i+1;j<student-1;j++){
                for(int k=j+1;k<student;k++){
                    if (number[i]+number[j]+number[k]==0){
                        answer+=1;
                    }
                }
            }
        }
        return answer;
    }
}