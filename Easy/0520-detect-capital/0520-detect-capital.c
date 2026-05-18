bool detectCapitalUse(char* word) {
    int wordLength = strlen(word);
    if (wordLength == 1) return true;
    if (isupper(word[0])) {
        if (isupper(word[1]))
            for (int i = 2; i < wordLength; i++) {
                if (!isupper(word[i])) return false;
            }
        else {
            for (int i = 2; i < wordLength; i++) {
                if (isupper(word[i])) return false;
            }
        }
    }
    else {
        for (int i = 1; i < wordLength; i++) {
            if (isupper(word[i])) return false;
        }
    }
    return true;
}