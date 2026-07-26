class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        int count_multiplier = (int)((1+count)*(count/2.0));
        answer = (long)price * count_multiplier - money;
        answer = answer > 0 ? answer : 0;
        return answer;
    }
}