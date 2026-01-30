import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        Map<Character, Long> xMap ;
        Map<Character, Long> yMap ;
        
        xMap = process(X);
        yMap = process(Y);
        
        List<Character> list = new ArrayList<>();
        
        for(char c : xMap.keySet()) {
            long count = Math.min(xMap.get(c), yMap.getOrDefault(c,0L));
            for(long i = 0; i < count; i++ ){
                list.add(c);
            }
        }
        
        Collections.sort(list, (o1,o2) -> {return o2 - o1;});
        
        StringBuilder br = new StringBuilder();
        
        for(char c : list) {
            if(br.length() == 1 && br.charAt(0) == '0') break;
            br.append(c);
        }
        
        
        
        return br.length() == 0 ? "-1" : br.toString();
    }
    
    public Map<Character, Long> process(String t) {
        Map<Character, Long> map = new HashMap<>();
        
        for(int i = 0; i < t.length(); i ++) {
            char c = t.charAt(i);
            long temp = map.getOrDefault(c, 0L);
            map.put(c, ++temp);
        }
        
        return map;
    }
}