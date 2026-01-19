import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int count =  'z' - 'a'  + 1;
        
        StringBuilder br = new StringBuilder();
        
        char[] words = new char[count + 1];        
        int[] skipWords = new int[count + 1];
        
        for(int i = 1; i < count + 1 ;i++ ) {
            words[i] = (char)(i  + 96);
        }        
        
        for(int i = 0; i < skip.length(); i++ ) {
            int index1 = (int)skip.charAt(i) - 96;
            skipWords[index1] = 1;
        }
        
        for(int i = 0; i < s.length(); i++) {
            int index1 = (int)s.charAt(i) - 96;
            
            for(int j = 0; j < index; j++) {
                index1++;
                if(index1 == 27)
                    index1 = 1;
                
                while(true){
                    if(skipWords[index1]== 1) {
                        index1++;

                        if(index1 == 27)
                            index1 = 1;
                    }
                    else
                        break;
                }
            }
            
            br.append(words[index1]);
        }
        
        
        return br.toString();
    }
}