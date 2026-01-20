class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        int count = 0;
        int otherCount = 0;
        char p = 0;
        
        for(int i = 0; i< length; i++ ) {
            if(i == length - 1) {
                answer++;
                break;
            }
            
            if(p == 0) {
                p = s.charAt(i);
                count++;
                continue;
            }
            
            if(p == s.charAt(i)) {
                count ++;
            } else {
                otherCount++;
                if(otherCount == count) {
                    p = 0;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}