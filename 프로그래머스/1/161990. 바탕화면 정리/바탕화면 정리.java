import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        // System.out.println(Arrays.toString( wallpaper));
        int[] answer = {};
        int y = wallpaper.length;
        int x = wallpaper[0].length();
        // System.out.println( y + "," + x);
        
        int min_y = Integer.MAX_VALUE;
        int min_x = Integer.MAX_VALUE;
        int max_y = 0;
        int max_x = 0;
        
        int[][] paper = new int[y ][x ];
        
        
        for(int i = 0; i < wallpaper.length; i ++) {
            String pos = wallpaper[i];
            for(int j = 0; j< pos.length(); j ++)
            {
                paper[i][j] = pos.charAt(j) == '#' ? 1 : 0;
                
                if(paper[i][j] == 1){
                    min_x = Math.min(min_x, j);
                    min_y = Math.min(min_y, i);
                    max_x = Math.max(max_x, j + 1);
                    max_y = Math.max(max_y, i + 1);
                    
                }
            }
            
            
            
            System.out.println(Arrays.toString(paper[i]));
        }
        
        
        
        System.out.println( min_y + "," + min_x);
        System.out.println( max_y + "," + max_x);
        
        
        return new int[]{min_y, min_x, max_y, max_x};
    }
}