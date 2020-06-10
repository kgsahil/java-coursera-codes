

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         
         for(String line: fr.lines()){
             LogEntry record = new WebLogParser().parseEntry(line);
             records.add(record);
         }
     }
     public int countUniqueIPs(){
         ArrayList<String> uniqueIPs= new ArrayList<String>();
         
         for(LogEntry le: records){
             if(!uniqueIPs.contains(le.getIpAddress()))
             uniqueIPs.add(le.getIpAddress());
         }
         
         return uniqueIPs.size();
     }   
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     public void printAllHigherThanNum(int num){
         for (LogEntry le : records) {
             if(le.getStatusCode() > num)
             System.out.println(le);
         }
     }
     public int countUniqueIPsInRange(int low,int high){
         ArrayList<String> uniqueIPs= new ArrayList<String>();
         for (LogEntry le : records) {
             if(le.getStatusCode() >= low && le.getStatusCode() <= high && !uniqueIPs.contains(le.getIpAddress()))
             uniqueIPs.add(le.getIpAddress());
         }   
         return uniqueIPs.size();
     }
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> IPsOnDay= new ArrayList<String>();
         
         for(LogEntry le: records){
             String date =le.getAccessTime().toString().substring(4,10);
             if(date.equals(someday)){
                 if(!IPsOnDay.contains(le.getIpAddress()))
                 IPsOnDay.add(le.getIpAddress());
             }
             
         }
        return IPsOnDay;
     }
     
}
