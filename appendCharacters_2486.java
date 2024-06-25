public class appendCharacters_2486 {
        public int appendCharacters(String s, String t) {
            int currIdx=-1,prevIdx=-1,lenOfPrevString=-1,realCurrIdx=0,ansIdx=-1;
            for(int i=0;i<t.length();i++){
                String stringToCheck=s.substring(prevIdx+1);
                currIdx=stringToCheck.indexOf(t.charAt(i));
                realCurrIdx=lenOfPrevString+currIdx+1;
                lenOfPrevString=realCurrIdx;
                if(prevIdx<realCurrIdx){
                    prevIdx=realCurrIdx;
                }else{
                    ansIdx=i;
                    break;
                }
            }
            if(ansIdx==-1){
                return 0;
            }
            return t.length()-ansIdx;
        }
//Two pointer approach

        public int appendCharactersBestApproachTwoPointers(String s, String t) {
            int l1=0,l2=0,r1=s.length()-1,r2=t.length()-1;
            while(l1<=r1&&l2<=r2){
                if(s.charAt(l1)==t.charAt(l2)){
                    l1++;
                    l2++;
                }else{
                    l1++;
                }
            }
            return r2-l2+1;

        }

    }
