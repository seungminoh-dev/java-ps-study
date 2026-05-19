class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        for(int ele:num_list){
            if (ele==n){
                answer=1;
                break;
            }
        }
        return answer;
    }
}