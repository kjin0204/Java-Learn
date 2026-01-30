class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            int count = i == 1 ? 1 : 2;
            
            for(int j = 2; j * j <= i; j++){
                if(i ==  j * j)
                    count ++;
                else if(i % j == 0)
                    count += 2;
            }
            
            if(count % 2 == 0)
                answer += i;
            else
                answer -= i;
            
        }
        return answer;
    }
}