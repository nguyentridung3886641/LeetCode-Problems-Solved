import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        // Sử dụng một Wrapper class để làm Key cho HashMap
        // giúp so sánh mảng int[] một cách chính xác và nhanh chóng
        Map<AnagramKey, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            AnagramKey key = new AnagramKey(count);
            
            // Tối ưu bằng cách dùng computeIfAbsent của Collection Framework
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // Tận dụng kiến thức OOP: Class lồng để đóng gói logic của Key
    private static class AnagramKey {
        private final int[] count;
        private final int hashCode;

        public AnagramKey(int[] count) {
            this.count = count;
            // Tính toán hashCode một lần duy nhất để tối ưu tốc độ
            this.hashCode = Arrays.hashCode(count);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AnagramKey that = (AnagramKey) o;
            return Arrays.equals(count, that.count);
        }

        @Override
        public int hashCode() {
            return hashCode;
        }
    }
}