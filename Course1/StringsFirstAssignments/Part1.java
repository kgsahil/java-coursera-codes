
/**
 * Write a description of Part1 here.
 * 
 * @author (Sahil Gupta) 
 * @version (1.0.0)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1) return "";
        int endIndex = dna.indexOf("TAA",startIndex+3);
        if(endIndex == -1) return  "";
        String result  =  dna.substring(startIndex,endIndex+3);
        if((startIndex - endIndex)%3 == 0) return result;
    return "";
    }
    
    public void testSimpleGene(){
        String dna;
        //test case 1 with gene rules statisfied
        dna  = "CCCTAAATGCAGTAA";
        System.out.println("Test case 1 Gene : "+findSimpleGene(dna));
        //test case 2 with no ATG
        dna = "ATCGGGTAA";
        System.out.println("Test case 2 Gene : "+findSimpleGene(dna));
        //test case 3 with no TAA
        dna = "TGCAAAATGCCAT";
        System.out.println("Test case 3 Gene : "+findSimpleGene(dna));
        //test case 4 with no ATG no TAA
        dna  = "ATCGATCGCCTAGCTAC";
        System.out.println("Test case 4 Gene : "+findSimpleGene(dna));
        //test case 5 with ATG and TAA but no multiple of 3 in between
        dna = "CCCTAAATGCGTAA";
        System.out.println("Test case 5 Gene : "+findSimpleGene(dna));
    }
    
    
}

