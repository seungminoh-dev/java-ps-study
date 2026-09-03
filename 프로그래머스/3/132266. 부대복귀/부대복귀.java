import java.util.*;

class Solution {
    public static final int SENTINEL = 99999999;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        // dest, n
        // dest map 지역은 n개
        int[] cost = new int[n+1];
        for(int i=0;i<cost.length;i++){
            cost[i]=SENTINEL;
        }
        cost[destination]=0;
        // 도착지부터 역계산 해야됨 destination to -> 왜냐면 이래야 최소 보장
        // destination 기준으로 탐험 -> 해당 지점에서 탐험 -> ... 연결되지 않은 부분은 탐색할 필요 없음!!
        Map<Integer, List<Integer>> roadMap = new HashMap<>();
        for(int[] road: roads){
            int startPoint = road[0];
            int endPoint = road[1];
            int revStartPoint = road[1];
            int revEndPoint = road[0];
            if(roadMap.containsKey(startPoint)){
                roadMap.get(startPoint).add(endPoint);
            }else{
                roadMap.put(startPoint,new ArrayList<Integer>());
                roadMap.get(startPoint).add(endPoint);
            }
             if(roadMap.containsKey(endPoint)){
                roadMap.get(endPoint).add(startPoint);
            }else{
                roadMap.put(endPoint,new ArrayList<Integer>());
                roadMap.get(endPoint).add(startPoint);
            }
        }
        
        // Tree-depth :최단경로
        // 시작은 cost[destination]
        Queue<Integer> nextLevel = new ArrayDeque<>();
        Queue<Integer> nowLevel = new ArrayDeque<>();
        int nowCost = 0;
        for(Integer ele : roadMap.getOrDefault(destination,new ArrayList<Integer>())){
            nextLevel.offer(ele);
        }
        while(!nextLevel.isEmpty()){
            nowLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
            nowCost++;
            while(!nowLevel.isEmpty()){
                int key = nowLevel.poll();
                if (cost[key]==SENTINEL){
                    for(Integer ele : roadMap.getOrDefault(key,new ArrayList<Integer>())){
                        nextLevel.offer(ele);
                    }
                    cost[key]=nowCost;
                }
            }
        }
        answer = new int[sources.length];
        for(int i=0;i<answer.length;i++){
            answer[i]=cost[sources[i]]==SENTINEL?-1:cost[sources[i]];
        }
        return answer;
    }
    public record Node(int start,int end){};
}