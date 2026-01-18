import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean finish;
                
        List<Integer> list = Arrays.stream(section)
                            .boxed()          // int를 Integer로 포장
                           .collect(Collectors.toList()); // 리스트로 수집
        
        paint(list.get(0) , m, list , n );
        
        return count;
    }
    
    int count;
    
    public void paint(int s, int m , List<Integer> section, int n ) {
        if(section.size() == 0 ) return;
        
        // if(s + m > n) 
        //     s -= n - (s + m);
        
        List<Integer> remain = new ArrayList<>();
        
        
        for(int i = 0; i < section.size(); i++) {
            if(s + m - 1< section.get(i) || s > section.get(i) )
                remain.add(section.get(i));
        }
        
        count++;
        
        if(remain.size() > 0 ) 
            paint(remain.get(0), m, remain, n);
        
        
    }
}