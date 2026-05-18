char* reverseVowels(char* s) {
    int sLength = strlen(s);
    int i = 0;
    int j = sLength - 1;
    while (i < j) {
        while (i < j && strchr("aeiouAEIOU", s[i]) == 0) {
            ++i;
        }
        while (i < j && strchr("aeiouAEIOU", s[j]) == 0) {
            --j;
        } 
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        ++i;
        --j;
    }
    return s;
}