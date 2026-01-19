import java.util.*;
import java.time.LocalDate;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        LocalDate now = LocalDate.parse(today.replaceAll("\\.", "-"));
        List<Integer> expireList = new ArrayList<>();
        
        Map<String, Integer> termsMap = new HashMap<>();
        
        for(String term : terms){
            String[] temp = term.split(" ");
            termsMap.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            LocalDate ex_date = LocalDate.parse(temp[0].replaceAll("\\.", "-"));
            
            ex_date = ex_date.plusMonths(termsMap.get(temp[1]));
            
            if(ex_date.isBefore(now) || ex_date.isEqual(now)){
                expireList.add(i + 1);
            }
        }
        
        answer = expireList.stream().mapToInt(x ->x).toArray();
        
        return answer;
    }
}