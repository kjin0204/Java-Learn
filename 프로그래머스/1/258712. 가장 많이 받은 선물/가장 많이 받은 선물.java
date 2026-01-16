import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int[][] map = new int[n][n];
        int[] points = new int[n];
        int[] getGift = new int[n];
        
        List<String> list = new ArrayList<>(Arrays.asList(friends));
        
        for(int i= 0; i < gifts.length; i++){
            String[] gift = gifts[i].split(" ");
            int s =  list.indexOf(gift[0]);
            int r =  list.indexOf(gift[1]);
            
            map[s][r] += 1;
            points[s] += 1; // 선물을 주면 + 1점
            points[r] -= 1; // 선물을 받으면 - 1점
        }
        
        System.out.println(Arrays.toString(points));
        System.out.println(Arrays.toString(friends));
        
        for(int i= 0; i < n; i++){
            for(int j =0; j < n; j ++) {
                if(i == j) continue;
                
                if(!(map[i][j] == 0 && map[j][i] == 0)
                  && map[i][j] > map[j][i])
                    getGift[i] += 1;
                else if(points[i] > points[j] && map[i][j] >= map[j][i])
                    getGift[i] += 1;
            }
            
            System.out.println(Arrays.toString(map[i]));
        }
        
        return Arrays.stream(getGift).max().getAsInt();
        
    }
}