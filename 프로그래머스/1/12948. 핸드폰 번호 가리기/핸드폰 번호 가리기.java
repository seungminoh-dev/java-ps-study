class Solution {
    public String solution(String phone_number) {
        int str_len = phone_number.length();
        int masked_len = str_len-4;
        char[] masked_phone_number = new char[str_len];
        for(int i=0;i<str_len;i++){
            if(i<masked_len){
                masked_phone_number[i]='*';
            }else{
                masked_phone_number[i]=phone_number.charAt(i);
            }
        }
        return String.valueOf(masked_phone_number);
    }
}