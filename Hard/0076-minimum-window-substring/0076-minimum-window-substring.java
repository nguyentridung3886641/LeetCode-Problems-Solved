class Solution {
    public String minWindow(String s, String t) {
        int n = t.length();
        int totalRemaining = n;
        int minLength = Integer.MAX_VALUE;
        String ans = "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);

            if (map.containsKey(ci)) {
                int valI = map.get(ci);
                map.put(ci, valI - 1);

                if (valI > 0) {
                    --totalRemaining;
                }
            }

            while (totalRemaining == 0) {
                int winLength = i - j + 1;
                if (winLength < minLength) {
                    ans = s.substring(j, i + 1);
                    minLength = winLength;
                }

                char cj = s.charAt(j);
                
                if (map.containsKey(cj)) {
                    int valJ = map.get(cj);
                    map.put(cj, valJ + 1);

                    if (valJ == 0) {
                        ++totalRemaining;
                    }
                }

                j++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? "" : ans;
    }
}