class Solution {
    public String solution(String s, int n) {
        char[] input = s.toCharArray();
        // 시저 암호 구현
        final char a = 'a';
        final char z = 'z';
        final char blank = ' ';
        final char A = 'A';
        final char Z = 'Z';
        // 암호화
        char char_token = blank;
        char encrypt_token = blank;
        
        for(int i=0;i<input.length;i++){
            char_token = input[i];
            // 공백
            if (char_token == blank)
                continue;
            //소문자
            if (char_token >= a && char_token <= z){
                int offset = (char_token - a + n)%(z+1-a);
                encrypt_token = (char)(a + offset);
                input[i] = encrypt_token;
                continue;
            }
            //대문자
            if (char_token >= A && char_token <= Z){
                int offset = (char_token - A + n)%(Z+1-A);
                encrypt_token = (char)(A + offset);
                input[i] = encrypt_token;
                continue;
            }
        }
        return String.valueOf(input);
    }
}