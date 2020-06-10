import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsInFiles {
    private HashMap<String,ArrayList<String>> map;
    public WordsInFiles(){
        map = new HashMap<String,ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        String fileName = f.getName();
        for(String word: fr.words()){
            if(map.containsKey(word)){
                ArrayList<String> files = map.get(word);
                if(!files.contains(fileName))
                files.add(fileName);
                  map.put(word,files);
            }else{
                ArrayList<String> files = new ArrayList<String>();
                files.add(fileName);
                map.put(word,files);
            }
        }
    }
    private void buildWordFileMap(){
        map.clear();
        DirectoryResource d = new DirectoryResource();
        for(File f: d.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    private int maxNumber(){
        int max = 0;
        for(ArrayList<String> files: map.values()){
          if(max < files.size()) max = files.size();      
        }
        return max;
    }
    private ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> words = new ArrayList<String>();
        for(String key: map.keySet()){
          if(map.get(key).size() == number) words.add(key);      
        }
        return words;
    }
    private void printFilesIn(String word){
        ArrayList<String> files = map.get(word);
        
        for(String file: files){
            System.out.println(file);
        }
            
    }
    public void tester(){
        buildWordFileMap();
        //System.out.println(maxNumber());
        //System.out.println(wordsInNumFiles(5).size());
        printFilesIn("laid");
    } 
}





