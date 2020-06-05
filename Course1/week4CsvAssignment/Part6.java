import edu.duke.*;
import org.apache.commons.csv.*;

public class Part6 {
    public int getTotalBirthsRankedHigher(int year,String name,String gender){
        int total = 0;
        FileResource fr = new FileResource("./us_babynames_by_year/yob"+year+".csv");
        CSVParser parser = fr.getCSVParser(false);
        
        for(CSVRecord record:parser){
            if(record.get(1).equals(gender)){
                if(record.get(0).equals(name)) break;
                total += Integer.parseInt(record.get(2));
            }
        }
        return total;
    }
    public void testGetTotalBirthsRankedHigher(){
        System.out.println("Total Count: "
        +getTotalBirthsRankedHigher(1990,"Drew","M"));
    }
}

