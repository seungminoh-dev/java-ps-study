import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
        int cur = 0;
        Queue<Integer> q = new LinkedList<>();
        while(true){
            // Q가 비어있으면 새로운 네트워크 시작
            if(q.isEmpty()){
                // 네트워크 시작 노드 탐색
                int before = cur;
                for(int i=cur;i<n;i++){
                    if (visited[i]==0)
                    {
                        cur = i;
                        break;
                    }
                }
                // 만약 cur이 같은데 visited처리도 됐다면 -> Not New Network
                if(before == cur && visited[cur]!=0)
                    break;
                // 새로운 노드 탐색 시작
                answer+=1;
                for(int i=0;i<computers[cur].length;i++){
                    if(computers[cur][i]==1)
                        q.add(i);
                }
                continue;
            }
            
            // Q 탐색하기
            while(!q.isEmpty()){
                int node = q.remove();
                if (visited[node] == 0){
                    for(int i=0;i<computers[node].length;i++){
                    if(computers[node][i]==1)
                        q.add(i);
                    }
                    visited[node] = 1;
                }
            }
            
        }
        return answer;
    }
}