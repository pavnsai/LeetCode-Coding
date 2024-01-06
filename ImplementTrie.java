import java.util.ArrayList;
import java.util.List;

public class ImplementTrie {
    class Trie {
        List<String> li;
        public Trie() {
            li=new ArrayList<>();
        }

        public void insert(String word) {
            li.add(word);
        }

        public boolean search(String word) {
            if(li.contains(word)){
                return true;
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            for(String str:li){
                if(str.startsWith(prefix)){
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}

// Second Approach Efficient

class Trie {
    class TrieNode {
        TrieNode links[] = new TrieNode[26];
        boolean flag = false;
    }

    TrieNode init;

    public Trie() {
        init = new TrieNode();
    }

    public void insert(String word) {
        TrieNode next_node = init;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (next_node.links[idx] == null) {
                TrieNode next = new TrieNode();
                next_node.links[idx] = next;
                next_node = next;
            } else {
                next_node = next_node.links[idx];
            }
        }
        next_node.flag = true;
    }

    public boolean search(String word) {
        TrieNode next_node = init;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            next_node = next_node.links[idx];
            if (next_node == null) {
                return false;
            }
        }
        return next_node.flag;
    }

    public boolean startsWith(String prefix) {
        TrieNode next_node = init;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            next_node = next_node.links[idx];
            if (next_node == null) {
                return false;
            }
        }
        return (next_node == null) ? false : true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


// More Efficient
class TrieEfficient {
    TrieEfficient links[];
    boolean flag = false;
    public TrieEfficient() {
        links = new TrieEfficient[26];
    }

    public void insert(String word) {
        TrieEfficient next_node = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (next_node.links[idx] == null) {
                TrieEfficient next = new TrieEfficient();
                next_node.links[idx] = next;
                next_node = next;
            } else {
                next_node = next_node.links[idx];
            }
        }
        next_node.flag = true;
    }

    public boolean search(String word) {
        TrieEfficient next_node = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            next_node = next_node.links[idx];
            if (next_node == null) {
                return false;
            }
        }
        return next_node.flag;
    }

    public boolean startsWith(String prefix) {
        TrieEfficient next_node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            next_node = next_node.links[idx];
            if (next_node == null) {
                return false;
            }
        }
        return (next_node == null) ? false : true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */