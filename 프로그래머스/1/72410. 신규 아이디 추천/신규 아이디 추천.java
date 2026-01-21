import java.util.regex.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        StringBuilder br = new StringBuilder(
            new_id.toLowerCase()  //1. 소문자 치환
            .replaceAll("[^\\w-.]", "") //2. 알파벳,소문자, -,_,. 제외 특수문자 제거
            .replaceAll("\\.{2,}", ".") // 3. .이 2개이상 연속될때 한개로 치환
            .replaceAll("^\\.|\\.$", "") //4. . 시작 과 끝에위치하면 제거 
        );
        
        //5. 문자열이 비었으면 a 대입
        if(br.length() == 0)
            br.append("a");
        
        //6. 16자 이상이면 15개로 자르고 마지막 글자가 . 이면 제거
        if(br.length() > 15)
            br.delete(15, br.length());
        
        if(br.charAt(br.length() - 1) == '.')
            br.delete(br.length() - 1,br.length());
        
        //7. 길이가 2자 이하 라면 마지막 문자열을대입해 3자리까지 만듬 
        while(br.length() < 3)
            br.append(br.charAt(br.length() - 1));
            
            
        return br.toString();
    }
}