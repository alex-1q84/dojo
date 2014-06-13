import java.util.*;

public class Reverse {
    public String reverseWords(String s) {
        if(s == null){
            return s;
        }
        
        s = s.trim();
        if(s.length() == 0){
            return s;
        }
        
        String[] words = s.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>-1; i--){
            sb.append(words[i]);
            if(i > 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Reverse reverse = new Reverse();
        String str = " ab   cde fg ";
        System.out.println(str);
        System.out.println(reverse.reverseWords(str));
    }
}

