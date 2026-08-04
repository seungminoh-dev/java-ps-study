class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        int sum =0;
        for(int ele : numbers){
            sum+=ele;
        }
        answer = sum*1.0 / numbers.length;
        return answer;
    }
}