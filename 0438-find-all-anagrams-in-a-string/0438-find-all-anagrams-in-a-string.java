import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < pLength; i++) {
            ++pFreq[p.charAt(i) - 'a'];
        }
        for (int r = 0; r < sLength; r++) {
            ++windowFreq[s.charAt(r) - 'a'];
            if (r >= pLength) {
                --windowFreq[s.charAt(r - pLength) - 'a'];
            }
            if (r >= pLength - 1) {
                if (Arrays.equals(pFreq, windowFreq))
                    res.add(r - pLength + 1);
            }
        }
        return res;
    }
}