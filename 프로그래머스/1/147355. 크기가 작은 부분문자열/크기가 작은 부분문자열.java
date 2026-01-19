class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        long pInt = Long.parseLong(p);
        
        for(int i = 0; i <= t.length() - length; i++) {
            if (Long.parseLong(t.substring(i, i + length)) <= pInt)
                answer++;
        }
        
        return answer;
    }
}