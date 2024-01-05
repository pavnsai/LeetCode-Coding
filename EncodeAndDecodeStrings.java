import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
     class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb=new StringBuilder();
            StringBuilder ans=new StringBuilder();
            sb.append(strs.size()).append("#");
            int lengthDigits=sb.toString().length();
            for(int i=0;i<strs.size();i++){
                String temp=strs.get(i);
                sb.append(temp.length()).append("#");
                ans.append(temp);
            }
            int leng=sb.toString().length()-lengthDigits;
            ans.insert(0,sb.toString());
            ans.insert(lengthDigits,leng+"#");
            return ans.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> li=new ArrayList<>();
            int start=0;
            while(s.charAt(start)!='#'){
                start++;
            }
            int totalNumberOfStrings=Integer.valueOf(s.substring(0,start));
            int secondStart=start+1;
            start++;
            while(s.charAt(start)!='#'){
                start++;
            }
            int numberOfStringsWithBuffer=Integer.valueOf(s.substring(secondStart,start));
            String[] lengthsArray=s.substring(start+1,start+1+numberOfStringsWithBuffer).split("#");
            int counter=numberOfStringsWithBuffer+start+1;
            for(int i=0;i<lengthsArray.length;i++){
                li.add(s.substring(counter,counter+Integer.valueOf(lengthsArray[i])));
                counter=counter+Integer.valueOf(lengthsArray[i]);
            }

            return li;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
}
