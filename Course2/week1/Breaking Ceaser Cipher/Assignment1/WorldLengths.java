import edu.duke.*;

public class WorldLengths {
     public void countWordLengths(FileResource resource, int[] counts){;
        for(String word: resource.words()){
            int length = word.length();
            if(!Character.isLetter(word.charAt(0)))
            length--;
            if(!Character.isLetter(word.charAt(word.length()-1)))
            length--;
            System.out.println(word+" : "+length);
            counts[length] += 1;
        }
    }
    
    public void testCountWordLengthss(){
        FileResource resource = new FileResource();
        int[] counts = new int[20];
        countWordLengths(resource,counts);
        
        for(int i=0;i<counts.length;i++){
            System.out.println("word length of "+i+" : "+counts[i]);
        }
        
    }
}
