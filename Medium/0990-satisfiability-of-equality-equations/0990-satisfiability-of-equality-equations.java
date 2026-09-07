class Solution {
    int[] parents;
    int[] size;
    public boolean equationsPossible(String[] equations) {
        parents = new int[26];
        size = new int[26];
        
        for (char i = 0; i < 26; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        for (String s : equations) {
            if (s.charAt(1) == '=') {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }

        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (find(s.charAt(0) - 'a') == find(s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    public int find(int i) {
        if (parents[i] == i) {
            return i;
        }
        return parents[i] = find(parents[i]);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }

        if (size[rootX] < size[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }

        parents[rootY] = rootX;
        size[rootX] += size[rootY];

        return true;
    }
}