import java.util.regex.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        Pattern p1 = Pattern.compile(".*(aya|ye|woo|ma)\\1.*");
        Pattern p2 = Pattern.compile("^(aya|ye|woo|ma)+$");
        
        for(String s : babbling) {
            if(p1.matcher(s).matches())
                continue;
            
            if(p2.matcher(s).matches())
                answer++;
        }
            
        
        
        return answer;
    }
}