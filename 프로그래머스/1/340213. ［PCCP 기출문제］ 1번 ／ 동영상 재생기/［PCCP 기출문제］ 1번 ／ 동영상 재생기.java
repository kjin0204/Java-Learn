import java.util.stream.Stream;
import java.util.Arrays;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Solution {
    public LocalTime checkPos(LocalTime pos, LocalTime start, LocalTime end){
        if((pos.isAfter(start) || pos.equals(start)) && pos.isBefore(end.plusSeconds(1))){
            pos = end;
        }
        return pos;
    }
    
        
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        LocalTime lastTime = LocalTime.parse("00:" + video_len,format );
         LocalTime posTime = LocalTime.parse("00:" + pos,format );
         LocalTime opStart = LocalTime.parse("00:" + op_start,format );
         LocalTime opEnd = LocalTime.parse("00:" + op_end,format );
        
        posTime = checkPos(posTime, opStart, opEnd);
        
        
        for(String com : commands){
            if("next".equals(com)){
                if(posTime.plusSeconds(10).isAfter(lastTime) || posTime.plusSeconds(10).equals(lastTime)){
                    posTime = lastTime;
                } else {
                    posTime = posTime.plusSeconds(10);
                }
            } else if("prev".equals(com)){
                if(posTime.minusSeconds(10).getHour() >= 1 )
                {
                    posTime = LocalTime.parse("00:00:00");
                }else{
                    posTime = posTime.minusSeconds(10);
                }
            }
            
            posTime = checkPos(posTime, opStart, opEnd);
            
        }
        
        return String.format("%02d", posTime.getMinute()) + ":" + String.format("%02d", posTime.getSecond());
    }
}