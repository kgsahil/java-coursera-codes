import edu.duke.*;
import java.util.*;

public class CountCodon {
    private HashMap<String,Integer> map;
    
    public CountCodon(){
        map = new HashMap<String,Integer>();
    }
    private void buildCodonMap(int start,String dna){
         map.clear();
         int length=0;
         while(start < dna.length()-3){
            String codon = dna.substring(start,start+3);
            if(map.containsKey(codon))
             map.put(codon,map.get(codon)+1);
             else
             map.put(codon,1); 
            start += 3;
            
         }
    }
    private String getMostCommonCodon(){
        String codon = "";
        for(String c:map.keySet()){
            if(codon.equals("")) codon = c;
            else{
                if(map.get(c)>map.get(codon))
                codon = c;
            }
        }
        return codon;    
    }
    private void printCodonCounts(int start,int end){
        for(String c: map.keySet()){
            if(map.get(c)>= start && map.get(c)<= end)
            System.out.println(c+"\t"+map.get(c));
        }
    }
    public void tester(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        for(int i=0;i<3;i++){
            buildCodonMap(i,dna.toUpperCase()); 
            System.out.println("Reading frame starting with "+i+" results in "+map.size()+" unique codon");
            String mcodon = getMostCommonCodon();
            System.out.println("and most common codon is "+mcodon+" with count "+map.get(mcodon));
            int start =7; int end = 7;
            System.out.println("Counts of codon between  "+start+" and "+end+" inclusive are:");
            printCodonCounts(start,end);
        }
    }
}
