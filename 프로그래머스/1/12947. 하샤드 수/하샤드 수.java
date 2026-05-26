class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String number = String.valueOf(x);
        int numSum=0;
        for(int i=0;i<number.length();i++){
            numSum+=number.charAt(i)-'0';
        }
        if (x%numSum==0)
            answer=true;
        else
            answer=false;
        return answer;
    }
}