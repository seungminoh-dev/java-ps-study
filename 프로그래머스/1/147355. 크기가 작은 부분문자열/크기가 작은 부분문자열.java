class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int last_index = t.length()-p.length();
        int length_p = p.length();
        boolean flag = true;
        for(int i=0;i<=last_index;i++){
            flag = true;
            for(int j=0;j<length_p;j++)
            {
                if (t.charAt(i+j)<p.charAt(j))
                {
                    flag=true;
                    break;
                }else if (t.charAt(i+j)>p.charAt(j)){
                    flag=false;
                    break;
                }

        }
                        if (flag) answer++;

    }
        return answer;
}
}