class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int index1 = 0;
        int index2 = 0;
        
        int find = 0;
        
        for(int i = 0; i < goal.length; i++) {
            if(index1 < cards1.length ) {
                String word1 = cards1[index1];
                if(word1.equals(goal[i])) {
                    index1++;
                    find++;
                    
                    System.out.println("1번 뭉치: " + word1);
                    continue;
                }   
            }
            
            if(index2 < cards2.length ) {
                String word2 = cards2[index2];
                if(word2.equals(goal[i])) {
                    index2++;
                    find++;
                    System.out.println("2번 뭉치: " + word2);
                    continue;
                }
            }
            break;
        }
        answer = find == goal.length? "Yes" : "No";
        System.out.println(find);
        
        return answer ;
    }
}