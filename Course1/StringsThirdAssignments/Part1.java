import edu.duke.*;

public class Part1 {
    
    public int findStopCodon(String dna,int startIndex,String stopCodon){
         
        int stopIndex = dna.indexOf(stopCodon,startIndex+3);
        while(stopIndex != -1){
            //String subDna = dna.substring(startIndex,stopIndex+3);
            if((stopIndex-startIndex)%3 == 0) return stopIndex;
            stopIndex = dna.indexOf(stopCodon,stopIndex+1);
        }
        return dna.length();
     }
     
    public String findGene(String dna,int startIndex){
         
         //int startIndex = dna.indexOf("ATG",startIndex);
         if(startIndex == -1) return "";
         int TAAindex = findStopCodon(dna,startIndex,"TAA");
         // System.out.println(TAAindex);
         int TAGindex = findStopCodon(dna,startIndex,"TAG");
         // System.out.println(TAGindex);
         int TGAindex = findStopCodon(dna,startIndex,"TGA");
         // System.out.println(TGAindex);
        
         int minCodonDistance = Math.min(Math.min(TAAindex,TAGindex),TGAindex);
         if(minCodonDistance != dna.length())
         return dna.substring(startIndex,minCodonDistance+3);
        return "";
        }
        
    public StorageResource getAllGenes(String dnaStr){
         int startIndex = dnaStr.indexOf("ATG");
         int count = 0;
         StorageResource s = new StorageResource();
         while(true){
                 if(startIndex == -1) break;
                 String gene = findGene(dnaStr,startIndex);
                 if(!gene.isEmpty() ){
                        // System.out.println("gene: "+gene);
                        s.add(gene);
                        count += 1;
                        startIndex = dnaStr.indexOf("ATG",startIndex+gene.length());
                    }else{
                        startIndex = dnaStr.indexOf("ATG",startIndex+3);
                    }
                
            }
         System.out.println("count: "+count);
         return s;
        }
        
    public void testGetAllGenes(){
        StorageResource s  = getAllGenes("ATGTAAHGYIUBATGATGTGA");
        
        for(String gene:s.data()) 
        System.out.println("Gene: "+gene);
    }  
    
   
}










