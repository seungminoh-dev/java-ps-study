class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        int size = arr.length;
        // 1개면 바로 -1 리턴
        if (size==1)
            return answer;
        // 최솟값 찾기
        int min = arr[0];
        for(int val:arr){
            if (val<min){
                min = val;
            }
        }
        // 최솟값 제외하고 복사
        answer = new int[size-1];
        int offset = 0;
        for(int i=0;i<size;i++){
            if (arr[i]==min){
                offset=-1;
                continue;
            }
            answer[i+offset]=arr[i];
        }
        return answer;
    }
}