class Solution {
    public int[] solution(long n) {
        int[] answer;
        String intArray = String.valueOf(n);
        int intLength = intArray.length();
        answer = new int[intLength];
        for(int i=intLength-1;i>=0;i--)
            answer[intLength-1-i]=intArray.charAt(i)-48;
    
        return answer;
    }
}