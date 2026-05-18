class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        int magazineLength = magazine.length();
        int ransomnoteLength = ransomNote.length();
        for (int i = 0; i < magazineLength; i++) {
            int index = magazine.charAt(i) - 'a';
            ++freq[index];
        }
        for (int i = 0; i < ransomnoteLength; i++) {
            int index = ransomNote.charAt(i) - 'a';
            --freq[index];
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] < 0) return false;
        }
        return true;
    }
}