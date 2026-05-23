class WordDictionary {
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curNode = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curNode.children[idx] == null)
                curNode.children[idx] = new TrieNode();
            curNode = curNode.children[idx];
        }
        curNode.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    public boolean dfs(String word, TrieNode curNode, int idx) {
        if (curNode == null) return false;
        if (idx == word.length()) return curNode.isWord;

        if (word.charAt(idx) != '.') {
            int nextIdx = word.charAt(idx) - 'a';
            if (curNode.children[nextIdx] == null) return false;
            return dfs(word, curNode.children[nextIdx], idx + 1);
        }

        else {
            for (int i = 0; i < 26; i++) {
                if (curNode.children[i] != null) { 
                    if (dfs(word, curNode.children[i], idx + 1)) return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */