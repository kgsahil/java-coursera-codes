import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class Part4 {

     public CSVRecord getLowestOfTwo(CSVRecord lowestSoFar,CSVRecord currentRecord){
        if(lowestSoFar == null) 
        lowestSoFar = currentRecord;
        else{
            String  humidity = currentRecord.get("Humidity");
            if(!humidity.equals("N/A")){
                double currentHumidity = Double.parseDouble(humidity);
                double lowestHumidity = Double.parseDouble(lowestSoFar.get("Humidity"));
                if(currentHumidity < lowestHumidity)
                lowestSoFar = currentRecord;
            }
        }
        return lowestSoFar;
    }
    
     public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestestSoFar = null;
        for(CSVRecord currentRecord:parser){
            lowestestSoFar = getLowestOfTwo(lowestestSoFar,currentRecord);
        }
        return lowestestSoFar;
    }
    
    public CSVRecord lowestHumidityInManyFiles (){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestSoFar = null;
        for(File f :dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord currentRecord = lowestHumidityInFile(parser);
            if(lowestSoFar == null){
                lowestSoFar = currentRecord;
            }else{
                double currentHumidity = Double.parseDouble(currentRecord.get("Humidity"));
                double lowestHumidity = Double.parseDouble(lowestSoFar.get("Humidity"));
                if(currentHumidity < lowestHumidity){
                    lowestSoFar = currentRecord;
                }

            }
        }
        return lowestSoFar;
    }
    
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }
    public void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }
}
