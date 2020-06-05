import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class Part5 {
    public double averageTemperatureInFile(CSVParser parser){
        double totalTemp = 0.0;
        int numberOfRecords = 0;
        for(CSVRecord record:parser){
            totalTemp += Double.parseDouble(record.get("TemperatureF"));
            numberOfRecords += 1;
        }
        return totalTemp/numberOfRecords;
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double totalTemp = 0.0;
        int numberOfRecords = 0;
        for(CSVRecord record:parser){
            double humidity = Double.parseDouble(record.get("Humidity"));
            if(humidity >= value){
                totalTemp += Double.parseDouble(record.get("TemperatureF"));
                numberOfRecords += 1;
            }
        }
        if(numberOfRecords == 0) return 999999.99;
        return totalTemp/numberOfRecords;
    }
    //unit test
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser  = fr.getCSVParser();
        double avgTemp = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is "+avgTemp);
    }
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser  = fr.getCSVParser();
        double avgTemp = averageTemperatureWithHighHumidityInFile(parser,80);
        if(avgTemp == 999999.99)
        System.out.println("No temperatures with that humidity");
        else
        System.out.println("Average Temp when high Humidity is "+avgTemp);
    }
}
