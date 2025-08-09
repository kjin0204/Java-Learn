import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        

        int playerInex = 0;
        String tempSwap = "";

        
        Map<String, Integer> pos = new HashMap<>(players.length * 2);
        
        for(int i = 0; i < players.length; i ++)
        {
            pos.put(players[i],i);
        }
        
        
        for(String called : callings){
            playerInex = pos.get(called);
            
            if( playerInex == 0 ) continue;
            tempSwap = players[playerInex- 1] ;
            players[playerInex] = tempSwap;
            players[playerInex - 1] = called ;
            
            
            pos.put(called, playerInex - 1);
            pos.put(tempSwap, playerInex);
            
        }

        answer = players;
        return answer;
    }
}