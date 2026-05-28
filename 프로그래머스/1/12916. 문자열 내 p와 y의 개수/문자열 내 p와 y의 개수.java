class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int temp=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            temp = s.charAt(i);
            if (temp=='p'||temp=='P'){
                count++;
            }else if(temp=='y' || temp=='Y'){
                count--;
            }
        }
        if (count!=0){
            answer=false;
        }

        return answer;
    }
}