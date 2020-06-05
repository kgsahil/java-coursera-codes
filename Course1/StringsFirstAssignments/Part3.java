public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        //1st occurrence
        int index1 = stringb.indexOf(stringa);
        if(index1 == -1)return false;
        int index2 = stringb.indexOf(stringa,index1+stringa.length());
        if(index2 == -1 )return false;
        
        
        return true;
    }
    
    
    public String lastPart(String stringa, String stringb){
        int startIndex = 0;
        int index1 = stringb.indexOf(stringa);
        if(index1 != -1)startIndex = index1+stringa.length();
        return stringb.substring(startIndex,stringb.length());
    }
    
    public void testing(){
        String s,subs;
        //test positive
        s = "this is my story";
        subs = "y";
        System.out.println(s+" : "+twoOccurrences(subs,s));
        //test negative
        s = "follow me arround";
        subs = "w";
        System.out.println(s+" : "+twoOccurrences(subs,s));
        
        //test for lastPart
        s = "banana";
        subs = "n";
        System.out.println(s+" : "+lastPart(subs,s));
    }
}
