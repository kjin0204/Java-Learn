import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        //diffs = 난이도 
        //times = 소요시간
        //limit = 최대 시간
        
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        long time = 0;
        
        Set<Integer> s = new HashSet<>();
       
        while(left <= right) {
            int level = (right + left) / 2;
            
            if(s.contains(level)) {
                left++;
                continue;
            }
            
            s.add(level);
            
            time = times[0];
            for(int i = 1; i < diffs.length; i++) {
                if(diffs[i] <= level)
                    time += times[i];
                else
                    time += (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
            }
            
            System.out.println(level + " , " + time);
            
            if(limit < time) {
                left = level;
            } else {
                answer = Math.min(answer, level);
                right = level;
            }
            
        }
        
        return answer;
    }
}