
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer analyzer =new LogAnalyzer();
        analyzer.readFile("short-test_log");
        analyzer.printAll();
       
    }
    public void testUniqueIP(){
        LogAnalyzer analyzer =new LogAnalyzer();
        analyzer.readFile("weblog2_log");
        int uniqueIPs = analyzer.countUniqueIPs();
        System.out.println("Unique IPs: "+uniqueIPs);
    }
    public void checkLogWithStatusCodeGreater(){
        LogAnalyzer analyzer =new LogAnalyzer();
        analyzer.readFile("weblog1_log");
        analyzer.printAllHigherThanNum(400); 
    }
    public void checkLogWithStatusCodeInRange(){
        LogAnalyzer analyzer =new LogAnalyzer();
        analyzer.readFile("weblog2_log");
        System.out.println("Total: "+analyzer.countUniqueIPsInRange(200,299)); 
        System.out.println("Total: "+analyzer.countUniqueIPsInRange(400,499)); 
    }
    public void getIPsOnDay(){
        LogAnalyzer analyzer =new LogAnalyzer();
        analyzer.readFile("weblog2_log");
        ArrayList<String> IPs = analyzer.uniqueIPVisitsOnDay("Sep 27");
        //for(String IP: IPs)
        System.out.println(IPs.size());
    }
    public void testVistisPerIP(){
        LogAnalyzer analyzer =new LogAnalyzer();
        analyzer.readFile("weblog2_log");
        HashMap<String,Integer> unique = analyzer.countVisitsPerIP();
        // for(String IP: unique.keySet())
        // System.out.println("IP: "+IP+" visits: "+unique.get(IP));
        System.out.println("Most visit: "+analyzer.mostNumberVisitsByIP(unique));
        System.out.println("Most visit IPs: "+analyzer.iPsMostVisits(unique));
    }
    public void testIPsForDays(){
        LogAnalyzer analyzer =new LogAnalyzer();
        analyzer.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> daysIP = analyzer.iPsForDays();
        for(String day: daysIP.keySet()){
            System.out.println(day+" have "+daysIP.get(day).size()+" IPs ");
            // for(String IP: daysIP.get(day)){
                // System.out.println(IP);
            // }
        }
        System.out.println("Day with most IP visit: "+analyzer.dayWithMostIPVisits(daysIP));
        String someday = "Sep 29";
         System.out.println("most IP visit on "+someday+": ");
         for(String IP: analyzer.IPsWithMostVisitsOnDay(daysIP,someday)){
                 System.out.println(IP);
          }
       
    }
}












