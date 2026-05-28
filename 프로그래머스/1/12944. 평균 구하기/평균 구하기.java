class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int val : arr){
            answer+=val;
        }
        answer/=arr.length;
        return answer;
    }
}