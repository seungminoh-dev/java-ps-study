class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int appleCount[] = new int[k+1];
        for(int apple : score){
            appleCount[apple]+=1;
        }
        if (score.length<m){
            return answer;
        }
        int cursor = k;
        int inboxing = m;
        int inboxPrice = 0;
        int difference = 0;
        while(cursor>=1){
            if(appleCount[cursor]==0){
                cursor--;
                continue;
            }
            difference = appleCount[cursor]>inboxing? inboxing:appleCount[cursor];
            inboxing-=difference;
            inboxPrice = cursor;
            appleCount[cursor]-=difference;
            if(inboxing==0){
                inboxing=m;
                answer+=inboxPrice*m;
            }
        }
        return answer;
    }
}