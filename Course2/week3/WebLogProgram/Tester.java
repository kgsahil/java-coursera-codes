
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
        analyzer.readFile("C:/Users/Admin/Desktop/sahil/coursera/java/java-coursera-codes/Course2/week3/WebLogProgram/short-test_log");
        analyzer.printAll();
       
    }
    public void testUniqueIP(){
        LogAnalyzer analyzer =new LogAnalyzer();
        analyzer.readFile("C:/Users/Admin/Desktop/sahil/coursera/java/java-coursera-codes/Course2/week3/WebLogProgram/short-test_log");
        int uniqueIPs = analyzer.countUniqueIPs();
        System.out.println("Unique IPs: "+uniqueIPs);
    }
    public void checkLogWithStatusCodeGreater(){
        LogAnalyzer analyzer =new LogAnalyzer();
        analyzer.readFile("C:/Users/Admin/Desktop/sahil/coursera/java/java-coursera-codes/Course2/week3/WebLogProgram/weblog1_log");
        analyzer.printAllHigherThanNum(400); 
    }
    public void checkLogWithStatusCodeInRange(){
        LogAnalyzer analyzer =new LogAnalyzer();
        analyzer.readFile("C:/Users/Admin/Desktop/sahil/coursera/java/java-coursera-codes/Course2/week3/WebLogProgram/weblog1_log");
        System.out.println("Total: "+analyzer.countUniqueIPsInRange(200,299)); 
        System.out.println("Total: "+analyzer.countUniqueIPsInRange(300,399)); 
    }
    public void getIPsOnDay(){
        LogAnalyzer analyzer =new LogAnalyzer();
        analyzer.readFile("C:/Users/Admin/Desktop/sahil/coursera/java/java-coursera-codes/Course2/week3/WebLogProgram/weblog1_log");
        ArrayList<String> IPs = analyzer.uniqueIPVisitsOnDay("Mar 24");
        //for(String IP: IPs)
        System.out.println(IPs.size());
    }
}
