import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder br = new StringBuilder();
        for(int i = 0; i < a.length(); i++){
            char ch =  a.charAt(i);
            if(Character.isUpperCase(ch))
                br.append(Character.toLowerCase(ch));
            else if(Character.isLowerCase(ch))
                br.append(Character.toUpperCase(ch));
        }
        System.out.println(br.toString());
    }
}