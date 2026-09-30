class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] sc = s.toCharArray();
        while (i < j) {
            while (i < j && !isVowels(sc[i])) {
                i++;
            }

            while (i < j && !isVowels(sc[j])) {
                j--;
            }

            char temp = sc[i];
            sc[i] = sc[j];
            sc[j] = temp;

            i++;
            j--;
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