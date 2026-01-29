import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int boxCount = score.length / m;
        int count = 0; 
        int minScore = Integer.MAX_VALUE;
        
        Arrays.sort(score);
        
        for(int i = score.length - 1; i > 0 - 1; i--) {
            minScore = Math.min(minScore, score[i]);
            
            if(++count == m) {
                answer += minScore * m;
                
                minScore = Integer.MAX_VALUE;
                count = 0;
            }
            
        }
        
        
        
        
        return answer;
    }
}