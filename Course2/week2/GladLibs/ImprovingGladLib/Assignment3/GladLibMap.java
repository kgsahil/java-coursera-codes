import edu.duke.*;
import java.util.*;

public class GladLibMap {
    HashMap<String,ArrayList<String>> myMap;
    private ArrayList<String> usedWordList;
    private ArrayList<String> usedCategories;
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "datalong";
    
    public GladLibMap(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        String[] categories = {"adjective","noun","color","country","name","animal","timeframe","verb","fruit"};
        myMap = new HashMap<String,ArrayList<String>>();
        for(String cat: categories){
            myMap.put(cat,readIt(source+"/"+cat+".txt"));
        }
        usedWordList = new ArrayList<String>();
        usedCategories = new ArrayList<String>();
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        
        if(!usedCategories.contains(label)) usedCategories.add(label);
        
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        if(myMap.containsKey(label))
        return randomFrom(myMap.get(label));
        
        return "**UNKNOWN**";
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while(usedWordList.contains(sub)){
          sub = getSubstitute(w.substring(first+1,last));
        }
        usedWordList.add(sub);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    private int totalWordsInMap(){
        int total= 0;
        for(ArrayList<String> list: myMap.values()){
            total += list.size();
        }
        return total;
    }
    private int totalWordsConsidered(){
        int total = 0;
        for(String label: myMap.keySet()){
            if(usedCategories.contains(label)){
                total += myMap.get(label).size();
            }
        }
        return total;
    }
    public void makeStory(){
        usedWordList.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\nTotal words replaced: "+usedWordList.size());
    }
    
}
