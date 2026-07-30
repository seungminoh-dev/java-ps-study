class Solution {
    public int solution(int a, int b, int n) {
        // 빈병 a개 -> b개 콜라로 교환
        // 빈병의 수 -> n개
        int coke_get = 0;
        int temp_coke = 0;
        while(n>=a){
            // 몇개 줄거임?
            temp_coke = (n - n%a);
            n -= temp_coke;
            // 교환
            coke_get += temp_coke/a*b;
            n += temp_coke/a*b;
        }
        return coke_get;
    }
}