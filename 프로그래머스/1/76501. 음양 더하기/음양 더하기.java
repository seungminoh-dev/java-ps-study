class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        // Loop
        for(int i=0;i<absolutes.length;i++){
            answer+=signs[i]?absolutes[i]:-absolutes[i];
        }
        return answer;
    }
}