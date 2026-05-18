import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
        int sLength = s.length();
        int total = 0;
        for (int i = 0; i < sLength; i++) {
            int current = roman.get(String.valueOf(s.charAt(i)));
            int next = (i + 1 < sLength ? roman.get(String.valueOf(s.charAt(i + 1))) : 0);
            if (current < next) total -= current;
            else total += current;
        }
        return total;
    }
}