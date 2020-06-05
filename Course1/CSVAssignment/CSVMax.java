import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;
public class CSVMax {
    public CSVRecord getSamallestOfTwo(CSVRecord coldestSoFar,CSVRecord currentRecord){
        if(coldestSoFar == null) 
        coldestSoFar = currentRecord;
        else{
            double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));
            double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            if(currentTemp < coldestTemp)
            coldestSoFar = currentRecord;
        }
        return coldestSoFar;
    }
   
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestSoFar = null;
        for(CSVRecord currentRecord:parser){
            coldestSoFar = getSamallestOfTwo(coldestSoFar,currentRecord);
        }
        return coldestSoFar;
    }
    public String fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestSoFar = null;
        String filename  = "";
        for(File f :dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord currentRecord = coldestHourInFile(parser);
            if(coldestSoFar == null){
                coldestSoFar = currentRecord;
                filename = f.getName();
            }else{
                double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if(currentTemp < coldestTemp){
                    coldestSoFar = currentRecord;
                    filename = f.getName();
                }

            }
        }
        System.out.println("Coldest temperature so far is "+coldestSoFar.get("TemperatureF"));
        return filename;
    }
   
    //unit test methods
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldestSoFar = coldestHourInFile(parser);
        System.out.println(coldestSoFar.get("TimeEST"));
    }
    public void testFileWithColdestTemperature(){
        System.out.println("Coldest day was in file "+fileWithColdestTemperature());
    }
    
 
}
