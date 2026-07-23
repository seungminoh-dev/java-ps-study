class Solution {
    public String solution(int n) {
        String answer = "";
        char[] myChar = new char[n];
        char[] subak = new char[]{'수','박'};
        for(int i=0;i<n;i++)
        {
            myChar[i]=subak[i%2];
        }
        answer = String.valueOf(myChar);
        return answer;
    }
}