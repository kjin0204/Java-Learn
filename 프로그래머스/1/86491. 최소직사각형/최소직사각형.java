class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        
        for(int i= 0; i< sizes.length; i ++) {
            int tx = Math.max(sizes[i][0], sizes[i][1]);
            int ty = Math.min(sizes[i][0], sizes[i][1]);
            
            x = Math.max(x , tx);
            y = Math.max(y , ty);
            
        }
        
        return x * y;
    }
}