import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int lower = Integer.MAX_VALUE;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int s : score) {
            if(list.size() < k) {
                list.add(s);
                lower = Math.min(lower, s);
            } else {
                Collections.sort(list);
                int temp = list.get(0);
                
                if(temp < s) {
                    list.remove(0);
                    list.add(s);
                    lower = Math.min(s, list.get(0));
                } else {
                    lower = temp;
                }
            }        
            
            answer[count++] = lower;
        }
        return answer;
    }
}