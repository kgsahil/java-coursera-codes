import edu.duke.*;
public class CeaserBreaker {
    CeasarCipher cc = new CeasarCipher();
    public void countFreq(String encrypted, int[] freq){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for(int i =0; i< encrypted.length(); i++){
            char c = Character.toLowerCase(encrypted.charAt(i));
            int index = alpha.indexOf(c);
            if(index != -1){
                freq[index] += 1;
            }
        }
    }
    public int  maxIndex(int[] freq){
        int maxIndex = 0;
        for(int i=0; i<freq.length; i++){
            if(freq[i] > freq[maxIndex])
            maxIndex = i; 
        }
        return maxIndex;
    }
    public String decrypt(String str1,String str2,String original){
        int[] freq = new int[26];
        countFreq(str1,freq);
        int maxIndex = maxIndex(freq);
        int key1 = maxIndex - 4;
        if(maxIndex<4)
        key1 = 26 - (4-maxIndex);
        System.out.println("KEY1:  "+key1);
        //for 2nd part
        freq =new int[26];
        countFreq(str2,freq);
         maxIndex = maxIndex(freq);
        int key2 = maxIndex - 4;
        if(maxIndex<4)
        key2 = 26 - (4-maxIndex);
        System.out.println("KEY2:  "+key2);
        return cc.encrypt(original,26-key1,26-key2);
    }
    
    public void testDecrypt(){
        FileResource resource = new FileResource();
        String coded = resource.asString();
        //String coded = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        //coded = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        //String coded = "Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!";
        for(int i=0; i< coded.length(); i++){
            if(i%2 == 0)
            str1.append(coded.charAt(i));
            else
            str2.append(coded.charAt(i));
        }
        
        System.out.println(decrypt(str1.toString(),str2.toString(),coded));
    }
}
