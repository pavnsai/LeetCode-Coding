public class DesignAddAndSearchWordsDataStructure {
    class WordDictionary {
        WordDictionary[] links;
        boolean flag=false;

        public WordDictionary() {
            links=new WordDictionary[26];
        }

        public void addWord(String word) {
            WordDictionary next_node=this;
            for(int i=0;i<word.length();i++){
                int idx=word.charAt(i)-'a';
                if(next_node.links[idx]==null){
                    WordDictionary temp=new WordDictionary();
                    next_node.links[idx]=temp;
                    next_node=temp;
                }else{
                    next_node=next_node.links[idx];
                }
            }
            next_node.flag=true;
        }
        public boolean search(String word) {
            WordDictionary next_node=this;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(ch=='.'){
                    for(int j=0;j<26;j++){
                        if(next_node.links[j]!=null){
                            if(next_node.links[j].search(word.substring(i+1))){
                                return true;
                            }
                        }
                    }
                    return false;
                }
                int idx=ch-'a';
                next_node=next_node.links[idx];
                if(next_node==null){
                    return false;
                }
            }
            return next_node.flag;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
