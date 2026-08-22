class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        int farthest = 0, size = 0;
        for (int i = 0; i < s.length(); i++) {
            farthest = Math.max(farthest, lastIndex[s.charAt(i) - 'a']);
            ++size;
            if (i == farthest){
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}