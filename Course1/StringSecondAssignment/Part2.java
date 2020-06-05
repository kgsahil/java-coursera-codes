public class Part2 {
    public int howMany(String stringa , String stringb){
        int currIndex = 0;
        int count = 0;
        while(true){
            currIndex = stringb.indexOf(stringa,currIndex);
            if(currIndex == -1) return count;
            count += 1;
            currIndex += stringa.length();   
        }
    }
    
    public void testHowMany(){
        String sa = "TAT";
        String sb = "ATATATAEASSHTA";
        int count = howMany(sa,sb);
        System.out.println("count: "+count);
    }
}
