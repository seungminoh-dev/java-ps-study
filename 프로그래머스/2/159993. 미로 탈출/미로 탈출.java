import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        // START -> Lever
        // Lever -> Exit 
        // 2중 최단 경로 찾기 문제
        // 1차원 배열로 다루자 row * row_index + col
        // 넓어도 만개 노드 만개 DFS로 탐색하면 되지 않나? 삽입이 앞에 큐에 넣기 전에 비용 갱신 필요
        // 비용이 갱신되었으면 Q에 들어가야됨(New Valuable Node)
        // 다음 노드 비용 결정 min(해당 노드 비용, 기존 노드+1)
        
        int colLen = maps[0].length();
        int rowLen = maps.length;
        // row * colLen + col
        int startPoint = -1;
        int levPoint = -1;
        int endPoint = -1;
        
        int[] map = new int[colLen*rowLen];
        
        //상수 설정
        final int WALL = -999;
        final int NOT_VISIT = -1;
        
        for(int i=0;i<rowLen; i++)
            for(int j=0;j<colLen; j++){
                // target 값 가져오기
                char target = maps[i].charAt(j);
                // 벽인지 아닌지 판단
                if (target=='X'){
                    map[toPoint(i,j,colLen)] = WALL;
                }else{
                    map[toPoint(i,j,colLen)] = NOT_VISIT;
                }
                // S/L/E 찾기
                if (target=='S'){
                    startPoint = toPoint(i,j,colLen);
                }
                else if (target=='L'){
                    levPoint = toPoint(i,j,colLen);
                }else if (target=='E'){
                    endPoint = toPoint(i,j,colLen);
                }
            }
        
        // map 갱신 완료
        // 탐색 시작 지점 startPoint
        // Point가 0~colLen-1 이면 위로가기 불가
        // %colLen = 0이면 왼쪽으로 가기 불가
        // %colLen = colLen-1 이면 오른쪽으로 가기 불가
        // Point가 (rowLen-1)*colLen-1 ~ rowLen*colLen-1 이면 아래로 가기 불가
        
        // START -> LEV
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(startPoint);
        map[startPoint]=0;
        
        while(!q.isEmpty()){
            int target = q.pollFirst();
            int destCost = 0;
            int nowCost = map[target];
            //위로가기 colLen을 빼줍니다
            if(target>colLen-1){
                destCost = map[target-colLen];
                if(destCost == NOT_VISIT){
                    map[target-colLen] = nowCost+1;
                    q.offerLast(target-colLen);
                }
            }
            //왼쪽가기
            if(target%colLen!=0){
                destCost = map[target-1];
                 if(destCost == NOT_VISIT){
                    map[target-1] = nowCost+1;
                    q.offerLast(target-1);
                }
            }
            
            //아래가기
            if(target<(rowLen-1)*colLen ){
                destCost = map[target+colLen];
                 if(destCost == NOT_VISIT){
                    map[target+colLen] = nowCost+1;
                    q.offerLast(target+colLen);
                }
            }
            //오른쪽가기
            if(target%colLen!=colLen-1 ){
                destCost = map[target+1];
                 if(destCost == NOT_VISIT){
                    map[target+1] = nowCost+1;
                    q.offerLast(target+1);
                }
            }
            
            if(map[levPoint]!=NOT_VISIT)
                break;
        }
        
        int stolCost = map[levPoint];
        
        if(stolCost==NOT_VISIT)
            return -1;
        
        //map 초기화
        for(int i=0;i<rowLen; i++)
            for(int j=0;j<colLen; j++){
                // 
                char target = maps[i].charAt(j);
                if (target=='X'){
                    map[toPoint(i,j,colLen)] = WALL;
                }else{
                    map[toPoint(i,j,colLen)] = NOT_VISIT;
                }
                if (target=='S'){
                    startPoint = toPoint(i,j,colLen);
                }
                else if (target=='L'){
                    levPoint = toPoint(i,j,colLen);
                }else if (target=='E'){
                    endPoint = toPoint(i,j,colLen);
                }
            }
        
        // LEV -> END
        q = new ArrayDeque<>();
        q.offer(levPoint);
        map[levPoint]=0;
        
        while(!q.isEmpty()){
            int target = q.pollFirst();
            int destCost = 0;
            int nowCost = map[target];
            //위로가기 colLen을 빼줍니다
            if(target>colLen-1){
                destCost = map[target-colLen];
                if(destCost == NOT_VISIT){
                    map[target-colLen] = nowCost+1;
                    q.offerLast(target-colLen);
                }
            }
            //왼쪽가기
            if(target%colLen!=0){
                destCost = map[target-1];
                 if(destCost == NOT_VISIT){
                    map[target-1] = nowCost+1;
                    q.offerLast(target-1);
                }
            }
            
            //아래가기
            if(target<(rowLen-1)*colLen ){
                destCost = map[target+colLen];
                 if(destCost == NOT_VISIT){
                    map[target+colLen] = nowCost+1;
                    q.offerLast(target+colLen);
                }
            }
            //오른쪽가기
            if(target%colLen!=colLen-1 ){
                destCost = map[target+1];
                 if(destCost == NOT_VISIT){
                    map[target+1] = nowCost+1;
                    q.offerLast(target+1);
                }
            }
            
            if(map[endPoint]!=NOT_VISIT)
                break;
        }
        
        int ltoeCost = map[endPoint];
        
        if(ltoeCost==NOT_VISIT)
            return -1;
        
        return stolCost+ltoeCost;
    }
    public int toPoint(int row, int col, int colLen){
        return row*colLen+col;
    }
  
}