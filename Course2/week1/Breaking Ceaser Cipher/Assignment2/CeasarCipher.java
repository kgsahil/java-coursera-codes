import edu.duke.*;
public class CeasarCipher {
    public String encrypt(String input, int key1,int key2){
    StringBuilder result = new StringBuilder();
    String dict = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder modDict1 = new StringBuilder();
    modDict1.append(dict.substring(key1));
    modDict1.append(dict.substring(0,key1));
    StringBuilder modDict2 = new StringBuilder();
    modDict2.append(dict.substring(key2));
    modDict2.append(dict.substring(0,key2));
    
    for(int i=0; i< input.length() ;i++){
            char s = input.charAt(i);
            String modDict = new String();
            if((i%2)==0) modDict = modDict1.toString();
            else modDict = modDict2.toString();
            int index = dict.indexOf(s);
            if(index != -1){
                result.append(modDict.charAt(index));
            }else{
                int lowIndex = dict.toLowerCase().indexOf(s);
                if(lowIndex != -1)
                result.append(Character.toLowerCase(modDict.charAt(lowIndex)));
                else
                result.append(s);
            }    
        
        
    }
    
    return result.toString();
    }
    public void testCeaser(){
        // FileResource fr = new FileResource();
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        int key = 23;
        String encrypted = encrypt( message,21,8);
        System.out.println(encrypted);
    }

}

















