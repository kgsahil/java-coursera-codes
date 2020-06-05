import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Part5 {
    
    public int getRank(CSVParser parser,String name,String gender){
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
    public int yearOfHighestRank(String name,String gender){
        DirectoryResource dr = new DirectoryResource();
        int highestRank = -1;
        int year = -1;
        
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            int currRank = getRank(parser,name,gender);
            if(currRank != -1){
                if(highestRank  == -1){
                     highestRank = currRank;
                     year = Integer.parseInt(f.getName().substring(3,7));
                }else{
                    if(currRank<highestRank){
                        highestRank = currRank;
                        year = Integer.parseInt(f.getName().substring(3,7));
                    }
                }
            }
            
        }
        return year;
    }
    public double getAverageRank(String name,String gender){
        DirectoryResource dr = new DirectoryResource();
        double highestRank = 0.0;
        int count =0;
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            int currRank = getRank(parser,name,gender);
            count += 1;
            if(currRank != -1){
                highestRank += currRank;
            }
            
        }
        if(count == 0) return -1.0;
        return highestRank/count;
    }
    public double getAverageRank1(String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        double avgRank=0.0;
        int len=0;
        double rank=0.0;
        for(File f: dr.selectedFiles())
        {
            String fname=f.getName();
            FileResource fr= new FileResource(fname);
            for(CSVRecord csv:fr.getCSVParser(false))
            {
                int currentYear = Integer.parseInt(f.getName().substring(3,7));
                int currentRank = getRank(fr.getCSVParser(false), name, gender);
                rank+=currentRank;
                len++;
            }
        }
        if (len==0)
        {
            return -1;
        }
        avgRank=rank/len;
        return avgRank;
    }
    
    public void testYearOfHighestRank(){
        System.out.println("Year: "+yearOfHighestRank("Genevieve","F"));
    }
    public void testGetAverageRank(){
        System.out.println("AvgRank: "+getAverageRank("Robert","M"));        
    }
}









