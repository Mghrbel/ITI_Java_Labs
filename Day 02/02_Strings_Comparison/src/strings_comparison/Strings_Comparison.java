package strings_comparison;

public class Strings_Comparison {

    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = "Ali";  
        String s2 = "Mohamed";  
        
        System.out.println((StringUtilis.getbetterString(s1, s2, StringUtilis::whichIsLonger)) + " is the longer string");
        
        
        String stringToCheck = "Mo7amed";
        if (StringUtilis.checkAlphabet(stringToCheck , StringUtilis::areAllLetters)){
            System.out.println(stringToCheck + "s characters are all alphabelts");
        }else{
            System.out.println(stringToCheck + "'s characters are not all alphabelts");
        }
    }  
}
