import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            list.add(i);
        }
        
        for(Integer i : numbers) {
            list.remove(i);
        }
        
        
        for(int i : list) answer += i;
        
        return answer;
    }
}