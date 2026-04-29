class Solution {
    public int solution(int a, int b) {
        if (isEven(a) && isEven(b))
            return a*a+b*b;
        else if (isEven(a) || isEven(b))
            return 2*(a+b);
        else
            return myabs(a-b);

    }
    static int myabs(int a){
        if (a>=0){
            return a;
        }else
            return -a;
    }
    static boolean isEven(int a){
        if (a%2==0){
            return false;
        }
        else
            return true;
    }
}

