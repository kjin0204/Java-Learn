import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] point = new int[] {0, 3, 2, 1, 0, 1, 2, 3};
        char[][] ch = new char[][]{{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < survey.length; i++) {
            char f = survey[i].charAt(0);
            char s = survey[i].charAt(1);
            
            int choice = choices[i];
            
            if(choice <= 4){
                map.put(f, map.getOrDefault(f, 0) + point[choices[i]]);
                map.put(s, map.getOrDefault(s, 0) + 0);
            }
            else{
                map.put(s, map.getOrDefault(s, 0) + point[choices[i]]);
                map.put(f, map.getOrDefault(f, 0) + 0);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char[] c : ch) {
            if(map.getOrDefault(c[0], 0) >= map.getOrDefault(c[1],0))
                sb.append(c[0]);
            else
                sb.append(c[1]);
        }
        
        
        return sb.toString();
    }
}