import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int length = photo.length;
        int[] answer = new int[length];
        
        Map<String, Integer> maps = new HashMap<>();
        
        for(int i = 0; i < yearning.length; i++){
            maps.put(name[i], yearning[i]);
        }
        
        for(int i =0; i < photo.length; i ++) {
            for(int j =0; j < photo[i].length; j ++){
                String temp = photo[i][j];
                if(maps.containsKey(temp))
                    answer[i] += maps.get(temp);
            }
        }
        return answer;
    }
}