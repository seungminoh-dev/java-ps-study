import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        Point[] delta = new Point[]{new Point(1,0),new Point(0,1), new Point(-1,0), new Point(0,-1)};
        List<Integer> ansList = new ArrayList<>();
        int[][] map = new int[maps.length][maps[0].length()];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(maps[i].charAt(j)=='X')
                    map[i][j]=0;
                else
                    map[i][j]=(int)(maps[i].charAt(j)-'0');
            }
        }
        Point node = findNode(map);
        int temp = 0;
        if(node.x()==-1 && node.y()==-1)
            return new int[]{-1};
        Queue<Point> q = new ArrayDeque<>();
        q.add(node);
        temp+=map[node.x()][node.y()];
        map[node.x()][node.y()]=0;
        
        while(true){
            if (q.isEmpty()){
                ansList.add(temp);
                temp=0;
                node = findNode(map);
                if(node.x()==-1 && node.y()==-1){
                    Collections.sort(ansList);
                    int[] ans = new int[ansList.size()];
                    for(int i=0;i<ansList.size();i++)
                        ans[i] = ansList.get(i);
                    return ans;
                }else{
                    q.add(node);
                    temp+=map[node.x()][node.y()];
                    map[node.x()][node.y()]=0;
                }
            }else{
                node = q.remove();
                for(Point del : delta){
                    int nx = node.x()+del.x();
                    int ny = node.y()+del.y();
                    if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length){
                        if(map[nx][ny]!=0){
                            q.add(new Point(nx,ny));
                            temp+=map[nx][ny];
                            map[nx][ny]=0;
                        }
                    }
                }
            }
        }
    }
    public record Point(int x,int y){}
    // findNode로 받으면 항상 -1,-1 검사 필요
    public Point findNode(int[][] map){
        for(int i=0;i<map.length;i++)
            for(int j=0;j<map[0].length;j++){
                if (map[i][j]!=0){
                    return new Point(i,j);
                }
            }
        return new Point(-1,-1);
    }
}