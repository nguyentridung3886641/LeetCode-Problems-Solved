class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        char[] sc = s.toCharArray();
        while (i <= j) {
            if (isVowels(sc[i]) && isVowels(sc[j])) {
                char c = sc[i];
                sc[i] = sc[j];
                sc[j] = c;

                i++;
                j--;
            }

            if (i < n && !isVowels(sc[i])) {
                i++;
            }

            if (j >= 0 && !isVowels(sc[j])) {
                j--;
            }
        }
        return new String(sc);
    }
    public boolean isVowels(char c) {
        c = Character.toLowerCase(c);
        switch(c) {
            case 'u':
            case 'e':
            case 'o':
            case 'a':
            case 'i':
                return true;
        }
        return false;
    }
}