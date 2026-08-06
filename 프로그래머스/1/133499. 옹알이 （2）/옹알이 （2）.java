class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String bab : babbling ){
            //replaceAll로 짜면 되긴하는데 메모리 제한?
            String new_bap = bab.replaceAll("aya","1").replaceAll("woo","2").replaceAll("ye","3").replaceAll("ma","4").trim();
            int n = new_bap.length();
            char before = '0';
            boolean check = true;
            for(char c : new_bap.toCharArray()){
                if (c == '1' || c=='2' || c=='3' || c=='4'){
                    if (c == before){
                        check = false;
                        break;
                    }else{
                        before=c;
                    }
                }else{
                    check = false;
                    break;
                }
            }
            if (check) answer++;
        }
        return answer;
    }
}