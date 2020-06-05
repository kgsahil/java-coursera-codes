import edu.duke.*;
import org.apache.commons.csv.*;

public class Part2 {
    public int getRank(int year,String name,String gender){
        FileResource fr = new FileResource("./us_babynames_by_year/yob"+year+".csv");
        CSVParser parser = fr.getCSVParser(false);
        int rank = 0;
        for (CSVRecord record:parser){
            if(record.get(1).equals(gender)){
                rank++;
                if(record.get(0).equals(name)){
                    return rank;
                }
            }
        }
        return -1;
    }
    public void testGetRank(){
        int nameRank = getRank(1971,"Frank","M");
        System.out.println("Rank: "+nameRank);
    }
}
