import java.util.*;

class Solution {
    
        int[] dirY = new int[] {1,-1,0,0};
        int[] dirX = new int[] {0,0,-1,1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        // storage = 컨테이너 현황
        // requests = 출고 요청 컨테이너 , 1자리는 가장자리 있는거만 출고 가능
        // 두자리 연속으로 들어오면 해당하는 모든 컨테이너 출고 가능
        
        // 상하 좌우 방향 벡터
        char[][] map = new char[storage.length + 2][storage[0].length() + 2];
        
        
        for(int i = 1; i <= storage.length; i++) {
            String data = storage[i - 1];
            
            for(int j = 1; j <= data.length(); j++) {
                map[i][j] = data.charAt(j - 1);
            }   
        }
        
        for(int i = 0; i < requests.length; i++) {
            boolean crain = requests[i].length() > 1 ? true : false;
            char command = requests[i].charAt(0);
            
            //크레인 요청이면 모두 꺼냄
            if(crain) {
                for(int j = 1; j < map.length; j++ ){
                    for(int k = 1; k < map[j].length; k++){
                        if(command == map[j][k])   
                            map[j][k] = 0;
                    }
                }
            } else{
                    List<Node> removeIndex = new ArrayList<>() ;
                for(int j = 1; j < map.length; j++ ){
                    for(int k = 1; k < map[j].length; k++){
                        if(command == map[j][k]) {
                            if(bfs(j, k, map)) {
                                removeIndex.add(new Node(k,j));
                            }
                            
                        }
                    }
                    
                }
                
                
                    for(Node n : removeIndex) {
                        map[n.y][n.x] = 0;
                    }
            }
        }
        
        
        
        for(char[] row : map){
            for(char c : row) {
                if(c != 0) 
                    answer++;
            }
        }
        
        //남은 컨테이너수 반환
        return answer;
    }
    
    
    public boolean bfs(int in_y, int in_x, char[][] map) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(in_x,in_y));
        boolean[][] visit = new boolean[map.length][map[0].length];
        
        while(q.size() > 0){
            Node node = q.poll();
            
            if(node.x == 0 || node.y == 0 || 
               node.x == map[0].length - 1 || node.y == map.length - 1) return true;
            
            for(int d = 0; d < 4; d++){
                int x = dirX[d];
                int y = dirY[d];
                if(map[y + node.y][x + node.x] == 0 && !visit[y + node.y][x + node.x]) {
                    visit[y + node.y][x + node.x] = true;
                    q.offer(new Node(x + node.x, y + node.y));
                } 
            }
        }

        
        return false;
    }
    
 class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
}
