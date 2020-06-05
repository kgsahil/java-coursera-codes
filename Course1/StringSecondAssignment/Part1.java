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
     
     public void testFindStopCodon(){
         String dna = "ATGTAAMKLATGHHPTAA";
         int length = findStopCodon(dna,0,"TAA");
            System.out.println("index: "+ length);
            System.out.println("dna: "+dna.substring(0,length+3));
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
     
     public void testFindGene(){
            String dnaStr = "ATGTAAMKLATGHHPTAA";
            int startIndex = 0;
            System.out.println("Gene is  "+ findGene(dnaStr,startIndex));
     }
     
     public void PrintAllGene(String dnaStr){
         int startIndex = dnaStr.indexOf("ATG");
         int count = 0;
         while(true){
                 if(startIndex == -1) break;
                 String gene = findGene(dnaStr,startIndex);
                 if(!gene.isEmpty() ){
                        System.out.println("gene: "+gene);
                        count += 1;
                        startIndex = dnaStr.indexOf("ATG",startIndex+gene.length());
                    }else{
                        startIndex = dnaStr.indexOf("ATG",startIndex+3);
                    }
                
            }
         System.out.println("count: "+count);
        }
        
     public void testAllGene(){
            String dna = "ATGTAAMKLATGHHPTAA";
            PrintAllGene(dna);
        }
}













