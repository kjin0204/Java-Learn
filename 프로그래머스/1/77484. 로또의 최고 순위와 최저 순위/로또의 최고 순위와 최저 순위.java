class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int count = 0;
        int zeroCount = 0;
        
        int[] me = new int[46];
        int[] win = new int[46];
        
        for(int i = 0; i < 6; i++) {
            // me[lottos[i]]++;    
            win[win_nums[i]]++;    
            
            if(lottos[i] == 0)
                zeroCount++;
        }   
        
        for(int i = 0; i < 6; i++) {
            if(win[lottos[i]] == 1)
                count++;
        }       
        
        int h = count + zeroCount < 2 ? 6 : 6 - count - zeroCount + 1;
        int l = count < 2 ? 6 : 6 - count + 1;
        
        return answer = new int[]{h,l};
    }
}