import edu.duke.*;
import org.apache.commons.csv.*;

public class Part3 {
    public String getName(int year,int rank,String gender){
        FileResource fr = new FileResource("./us_babynames_by_year/yob"+year+".csv");
        CSVParser parser = fr.getCSVParser(false);
        int currRank = 0;
        for (CSVRecord record:parser){
            if(record.get(1).equals(gender)){
                currRank++;
                if(currRank == rank){
                    return record.get(0);
                }
            }
        }
       
        return "NO NAME";
    }
    public void testGetName(){
        String name = getName(1980,350,"F");
        System.out.println("Name: "+name);
    }
}
