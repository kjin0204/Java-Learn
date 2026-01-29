class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        
        for(int i = 1; i < food.length; i++) {
            int f = food[i] / 2;
            
            if(f > 0) {
                for(int j = 0; j < f; j++) {
                    sb.append((i) + "");
                }
            }
        }
        
        answer = sb.toString() + "0";
        
        answer += sb.reverse();
        
        return answer;
    }
}