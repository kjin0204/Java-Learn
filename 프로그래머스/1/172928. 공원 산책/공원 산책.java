import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        
        int dogX = 0;
        int dogY = 0;
        int width = park[0].length();
        char[][] map = new char[park.length][width];
        
        for(int i = 0; i < park.length; i++){
            for(int j =0; j < park[i].length(); j++){
                
                map[i][j] = park[i].charAt(j);
                
                if(park[i].charAt(j) == 'S'){
                    dogX = j;
                    dogY = i;
                }
            }
        }
        
        for(int i =0; i < routes.length; i ++){
            String[] parsing = routes[i].split(" ");
            String dir = parsing[0];
            int des = Integer.parseInt(parsing[1]);
            boolean find = false;
            
            if(dir.equals("E")){
                if(dogX + des < width ){
                    for(int j = dogX + 1; j <= dogX + des; j++){
                        if(map[dogY][j] == 'X'){
                            find =true;
                            break;
                        }
                    }
                     if(!find)
                        dogX += des;
                }
            }else if(dir.equals("W")){
                if(dogX - des >= 0 ){
                    for(int j = dogX - 1; j >= dogX - des; j--){
                        if(map[dogY][j] == 'X'){
                            find =true;
                            break;
                        }
                    }
                     if(!find)
                        dogX -= des;
                }
                
            }else if(dir.equals("S")){
                if(dogY + des < map.length ){
                    for(int j = dogY + 1; j <= dogY + des; j++){
                        if(map[j][dogX] == 'X'){
                            find = true;
                            break;
                        }
                    }
                    if(!find)
                        dogY += des;
                }
                
            }else if(dir.equals("N")){
                if(dogY - des >= 0 ){
                    for(int j = dogY - 1; j >= dogY - des; j--){
                        if(map[j][dogX] == 'X'){
                            find =true;
                            break;
                        }
                    }
                    if(!find)
                        dogY -= des;
                }
                
            }
                
        }
        
        
        int[] answer = {dogY,dogX};
        
        return answer;
    }
}