import edu.duke.*;
import java.util.*;

public class CharactersInPlay {
    ArrayList<String> characters;
    ArrayList<Integer> counts;
    
    public CharactersInPlay(){
        characters = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    private void update(String person){
        if(characters.contains(person)){
            int index = characters.indexOf(person);
            int value = counts.get(index)+1;
            counts.set(index,value);
        }else{
            characters.add(person);
            counts.add(1);
        }
    }
    private void findAllCharacters(){
        characters.clear();
        counts.clear();
        FileResource fr = new FileResource();
        for(String line : fr.lines()){
            int index = line.indexOf(".");
            if(index != -1){
                String name = line.substring(0,index);
                update(name);
            }
        }
    }
    private void charactersWithNumberParts(int num1,int num2){
        for(int i=0;  i<characters.size(); i++){
            int count = counts.get(i);
            if(count > num1 && count <= num2)
            System.out.println(count+" "+characters.get(i));
        }
    }
    public void tester(){
        findAllCharacters();
        // for(int i=0;  i<characters.size(); i++){
            // if(counts.get(i) > 1)
            // System.out.println(counts.get(i)+" "+characters.get(i));
        // }
        charactersWithNumberParts(9,15);
        
    }
}
