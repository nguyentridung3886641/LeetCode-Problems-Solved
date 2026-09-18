import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> res = new ArrayList<>();
        List<int[]> intervals = new ArrayList<>();
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int fidx = s.charAt(i) - 'a';
            int lidx = s.charAt(n - i - 1) - 'a';

            if (first[fidx] == -1) {
                first[fidx] = i;
            }

            if (last[lidx] == -1) {
                last[lidx] = n - i - 1;
            }
        }

        for (int c = 0; c < 26; c++) {
            if (first[c] == -1) continue;

            int L = first[c];
            int R = last[c];
            boolean isValid = true;

            for (int j = L; j <= R; j++) {
                int ch = s.charAt(j) - 'a';

               if (first[ch] < L) {
                    isValid = false;
                    break;
                }

                R = Math.max(R, last[ch]);
            }

            if (isValid) {
                intervals.add(new int[]{L, R});
            }
        }

        int lastIntervalEnd = -1;
        Collections.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > lastIntervalEnd) {
                res.add(s.substring(start, end + 1));
                lastIntervalEnd = end;
            }
        }

        return res;
    }
}
