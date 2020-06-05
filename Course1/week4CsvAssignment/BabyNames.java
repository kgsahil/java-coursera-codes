import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyNames {
    public void totalBirths(CSVParser parser){
        int totalNames = 0;
        int totalBoysName = 0;
        int totalGirlsName = 0;
        
        
        for(CSVRecord record: parser){
            totalNames += 1;
            if(record.get(1).equals("M")){
                totalBoysName += 1;
            }else{
                totalGirlsName += 1;
            }
        }
        System.out.println("Total: "+totalNames+" boys: "+totalBoysName
        +" Girls: "+totalGirlsName);
    }
    public void testTotalBirth(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        totalBirths(parser);
    }
    
}








