

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
     public HashMap<String,Integer> countVisitsPerIP(){
        HashMap<String,Integer> uniqueCount = new HashMap<String,Integer>();
        
        for(LogEntry le : records){
            String IP = le.getIpAddress();
            
            if(uniqueCount.containsKey(IP)){
                uniqueCount.put(IP,uniqueCount.get(IP)+1);
            }else{
                uniqueCount.put(IP,1);
            }
        }
        return uniqueCount;
     }     
     public int mostNumberVisitsByIP(HashMap<String,Integer> unique){
        
         int max = 0;
         for(String IP: unique.keySet()){
            if(max < unique.get(IP)) max = unique.get(IP);
         }
         return max;
     }
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> unique){
         ArrayList<String> IPs = new ArrayList<String>();
         int max = mostNumberVisitsByIP(unique);
         for(String IP: unique.keySet()){
            if(max == unique.get(IP)) IPs.add(IP);
         }
         return IPs;
     }
     public HashMap<String,ArrayList<String>> iPsForDays(){
         
         HashMap<String,ArrayList<String>> dict = new HashMap<String,ArrayList<String>>();
         
         for(LogEntry le: records){
           String date =le.getAccessTime().toString().substring(4,10);
            if(dict.containsKey(date)){
                // if(dict.get(date).indexOf(le.getIpAddress()) == -1){
                    ArrayList<String> IPs = dict.get(date);
                    IPs.add(le.getIpAddress());
                    dict.put(date,IPs);
                // }
            }else{
               ArrayList<String> IPs = new ArrayList<String>();
               IPs.add(le.getIpAddress());
               dict.put(date,IPs);
            }
         }
         return dict;
     }
     public  String dayWithMostIPVisits(HashMap<String,ArrayList<String>> dict){
        String day = "";
        int max = 0;
        for(String d: dict.keySet()){
            if(dict.get(d).size() > max){
                max = dict.get(d).size();
                day = d;
            }
        }
        return day;
     } 
     
     public ArrayList<String> IPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> dict,String someday){
        
        ArrayList<String> IPsOnDay = dict.get(someday);
        HashMap<String,Integer> uniqueCount = new HashMap<String,Integer>();
        
        for(String IP : IPsOnDay){
            if(uniqueCount.containsKey(IP)){
                uniqueCount.put(IP,uniqueCount.get(IP)+1);
            }else{
                uniqueCount.put(IP,1);
            }
        }
        
        ArrayList<String> IPs = iPsMostVisits(uniqueCount);
        return IPs;
     }
}








