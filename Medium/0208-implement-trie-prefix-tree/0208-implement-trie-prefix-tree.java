import java.util.*;

class Trie {
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (Character c : word.toCharArray()) {
            if (cur.children.containsKey(c) == false)
                cur.children.put(c, new TrieNode());            
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (Character c : word.toCharArray()) {
            if (cur.children.containsKey(c) == false)
                return false;
            cur = cur.children.get(c);
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (Character c : prefix.toCharArray()) {
            if (cur.children.containsKey(c) == false)
                return false;
            cur = cur.children.get(c);
        }
        return true;
    }   
}
