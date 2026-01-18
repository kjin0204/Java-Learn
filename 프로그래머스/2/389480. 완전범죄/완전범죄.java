import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        
        int[] dp = new int[m];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int[] item : info) {
            int aCost = item[0];
            int bCost = item[1];
            
            int[] newDp = new int[m];
            Arrays.fill(newDp, Integer.MAX_VALUE);
            
            for(int i = 0 ; i < m; i++){
                if(dp[i] == Integer.MAX_VALUE) continue;
                
                //a가 훔쳤을 때
                int newA = aCost + dp[i];
                if(newA < n) {
                    newDp[i] = Math.min(newDp[i] , newA);
                }
                
                //b가 훔쳤을 때
                int newB = i + bCost;
                if(newB < m ) {
                    newDp[newB] = Math.min(newDp[newB], dp[i]);
                }
            }
            dp = newDp;
        }
        
        answer = Integer.MAX_VALUE;
        for(int a : dp){
            System.out.println(a);
            answer =  Math.min(answer, a);
        }
        
        
        return answer == Integer.MAX_VALUE ? - 1 : answer;
    }
}