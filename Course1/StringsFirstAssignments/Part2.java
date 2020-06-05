
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna,String startCodon,String stopCodon){
        boolean caseCheckUpperCase = dna.equals(dna.toUpperCase());
        dna = dna.toUpperCase();
        startCodon = startCodon.toUpperCase();
        stopCodon = stopCodon.toUpperCase();
        int startCodonIndex =  dna.indexOf(startCodon);
        if(startCodonIndex == -1) return "";
        int startIndex = dna.indexOf("ATG",startCodonIndex+3);
        if(startIndex == -1) return "";
        int endIndex = dna.indexOf("TAA",startIndex+3);
        if(endIndex == -1) return  "";
        int endCodonIndex =  dna.indexOf(stopCodon,endIndex+3);
        if(endCodonIndex == -1) return  "";
        String result  =  dna.substring(startIndex,endIndex+3);
        if((startIndex - endIndex)%3 == 0){
            if(!caseCheckUpperCase) result = result.toLowerCase();
            return result;
        }
    return "";
    }
    
    public void testSimpleGene(){
        String dna;
        //test case 1 with gene rules statisfied with upper case
        dna  = "AGAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("Test case 1 Gene : "+findSimpleGene(dna,"AGA","TAA"));
        //test case 2 with no ATG
        dna = "ATCGGGTAA";
        //System.out.println("Test case 2 Gene : "+findSimpleGene(dna));
        //test case 3 with no TAA
        dna = "TGCAAAATGCCAT";
        //System.out.println("Test case 3 Gene : "+findSimpleGene(dna));
        //test case 4 with no ATG no TAA
        dna  = "ATCGATCGCCTAGCTAC";
        //System.out.println("Test case 4 Gene : "+findSimpleGene(dna));
        //test case 5 with ATG and TAA but no multiple of 3 in between
        dna = "CCCTAAATGCGTAA";
        //System.out.println("Test case 5 Gene : "+findSimpleGene(dna));
    }
    
    
}
