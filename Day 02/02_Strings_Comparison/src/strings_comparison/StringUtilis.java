/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings_comparison;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class StringUtilis {
    public static boolean whichIsLonger (String str1 ,String str2){
        return str1.length()>str2.length();
    }
    
    public static String getbetterString (String string1 ,String string2 ,BiPredicate<String,String> F){
        if (F.test(string1, string2)){
            return string1;
        }
        else{
            return string2;
        }
    }
    
    public static boolean areAllLetters (String str){
        for (int i=0 ; i< str.length(); i++){
            if (!Character.isLetter(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkAlphabet (String string , Predicate <String> F){
        return F.test(string);
    }
}
