import edu.duke.URLResource;
public class Part4 {
    public void readResource(){
        URLResource ur =  new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        String key = "youtube";
        for(String line : ur.lines()){
            String lineSmall = line.toLowerCase();
            int index = lineSmall.indexOf(key);
            if(index != -1){
                int endQ = lineSmall.indexOf("\"" , index);
                int startQ = lineSmall.lastIndexOf("\"",index);
                System.out.println(line.substring(startQ+1,endQ));
            }
        }
        
    }
}
