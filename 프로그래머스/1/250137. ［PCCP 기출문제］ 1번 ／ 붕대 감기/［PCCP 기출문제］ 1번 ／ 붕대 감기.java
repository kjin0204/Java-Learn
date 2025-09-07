class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int continueTime = 0; //연속 회복 시저 시간
        int bandageTime = bandage[0];  // 추가 회복 필요 시간.
        int addHp = bandage[1]; //초당 회복량
        int bonusHp = bandage[2]; //추가회복량
        int currentTime = 0; //흐른 시간
        int maxHp = health;
        
        for(int[] damage : attacks ){
            int now = damage[0];         
            
            if(health < maxHp){
                int diffTime = now - currentTime - 1; //데미지를 받은시간은 체력 회복 불가
                int bonus = 0;
                if(bandageTime <= diffTime){
                    bonus = diffTime / bandageTime * bonusHp;
                }
                health = health + diffTime * addHp + bonus >= maxHp ? maxHp : health + diffTime * addHp + bonus;
            }
            
            health -= damage[1];

            if(health <= 0) {
                break;
            }
            currentTime = damage[0]; // 시간 증가.
            
        }
        
        answer = health <= 0 ? -1 : health ;
        
        return answer;
    }
}