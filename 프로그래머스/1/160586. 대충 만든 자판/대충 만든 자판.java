import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] dp = new int[26];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i =0; i < keymap.length; i++) {
            for(int j =0; j < keymap[i].length(); j++){
                int index =  keymap[i].charAt(j) - 'A' ;
                dp[index] = Math.min(dp[index], j + 1);
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            int count  = 0;
            for(int j = 0; j < targets[i].length(); j++){
                int index =  targets[i].charAt(j)  - 'A';
                if(dp[index] != Integer.MAX_VALUE)
                    count += dp[index];
                else{
                    count = -1;
                    break;
                }
                    
            }
            answer[i] = count == 0 ? -1 : count;
        }
        
        return answer;
    }
}