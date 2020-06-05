import edu.duke.*;
import org.apache.commons.csv.*;

public class Part4 {
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
    public void whatIsNameInYear(String name,int year,int newYear,String gender){
        int rank = getRank(year,name,gender);
        String newName = getName(newYear,rank,gender);
        System.out.println(year+":"+name);
        System.out.println(newYear+":"+newName);
    }
    public void test(){
        whatIsNameInYear("Owen",1974,2014,"M");
    }
}
