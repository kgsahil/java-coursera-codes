import edu.duke.*;
import org.apache.commons.csv.*;
public class CSV {
    
    public String countryInfo(CSVParser parser, String country){
        
        for(CSVRecord record:parser ){
            if(record.get("Country").contains(country)){
                return record.get("Country")+": "+record.get("Exports")+": "+record.get("Value (dollars)");
            }
        }
        
        return "NOT FOUND";
    }
    
    public void listExportersTwoProduct(CSVParser parser,String ex1,String ex2){
        
        for(CSVRecord record : parser){
            if(record.get("Exports").contains(ex1) && record.get("Exports").contains(ex2)){
                System.out.println(record.get("Country"));
            }
        }
    
    }
    public int numberOfExporters(CSVParser parser,String exportitem){
        int count = 0;
        for(CSVRecord record : parser){
            if(record.get("Exports").contains(exportitem)){
                count += 1;
            }
        }
        
        return count;
    }
    public void bigExporters(CSVParser parser,String amount){
        for(CSVRecord record : parser){
            if(record.get("Value (dollars)").length() > amount.length()){
                System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
            }
        }
    }
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        // String info = countryInfo(parser,"Nauru");
        // System.out.println(info);
        // listExportersTwoProduct(parser,"cotton","flowers");
       // System.out.println(numberOfExporters(parser,"cocoa"));
        String amount = "$999,999,999,999";
        bigExporters(parser,amount);
    }
}
