import edu.duke.*;


public class WordPlay {
    public boolean isVowel(char ch){
        
        String vowels = "aeiouAEIOU";
        if(vowels.indexOf(ch) != -1 ) return true;
        return false;
    }
    
    public void vowelsTester(){
        char ch  = 'a';
        System.out.println("the alphabet "+ch+" is vowel? "+isVowel(ch));
    }
    
    public String replaceVowel(String phrase, char ch){
    StringBuilder modString  = new StringBuilder();
    int i = 0;
    while(phrase.length() > i){
        if(isVowel(phrase.charAt(i))) modString.append(ch);
        else modString.append(phrase.charAt(i));
        i++;
    }
    return modString.toString();
    }
    public void replaceTester(){
        String result = replaceVowel("abab",'*');
        System.out.println(result);
    }
    
    public String  emphasize(String phrase, char ch ){
    StringBuilder modString = new StringBuilder();
     int i = 0;
    while(phrase.length() > i){
        
        if(phrase.charAt(i) == Character.toLowerCase(ch) || phrase.charAt(i) == Character.toUpperCase(ch) ){
            if((i+1)%2 == 0)
            modString.append('+');
            else
            modString.append('*');
        } 
        else modString.append(phrase.charAt(i));
        i++;
    }
    
    return modString.toString();
    }
    public void testEmphasize(){
        String result = emphasize("Mary Bella Abracadabra",'a');
        System.out.println(result);
    }
}











