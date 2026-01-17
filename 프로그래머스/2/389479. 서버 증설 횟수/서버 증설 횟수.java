class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        //players 24시간 배열 값은 해당 시간의 접속자 수
        //m = 서버가 최대 동접 허용 인원 수 - 1
        //k = 서버 증설 후 유지되는 시간 1 = 1시간
        
        int power = m;
        // 증설 서버 유지 시간 저장
        int[] c = new int[players.length];
        
        for(int i = 0; i < players.length; i++) {
            // 증설 필요 확인
            if(players[i] >= power) {
                int needs = players[i] - (power - 1);
                int a = needs % m > 0 ? 
                    needs / m + 1 : needs / m;
                
                
                answer += a;
                power += a * m ;
                
                //서버 유지시간 저장
                int s = i + k - 1 > players.length - 1 ? players.length - 1 : i + k - 1;
                
                c[s] = a * m ;
            }
            
            // 기존 증설 서버 유지시간 끝난후 반환
            if(c[i] > 0)
                power -= c[i];
        }
        
        return answer;
    }
}