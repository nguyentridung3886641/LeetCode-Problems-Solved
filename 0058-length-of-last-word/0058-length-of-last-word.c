int lengthOfLastWord(char* s) {
    int sLength = strlen(s);
    int i = sLength - 1;
    int wordLength = 0;
    while (i >= 0 && s[i] == ' ') 
        --i;
    while (i >= 0 && s[i] != ' ') {
        ++wordLength;
        --i;
    }
    return wordLength;
}