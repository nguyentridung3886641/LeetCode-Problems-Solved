int strStr(char* haystack, char* needle) {
    int haystackLength = strlen(haystack);
    int needleLength = strlen(needle);
    for (int i = 0; i <= haystackLength - needleLength; i++) {
        if (haystack[i] == needle[0]){
            if (needleLength == 1) return i;
            int j;
            for (j = 1; j < needleLength; j++) {
                if (haystack[i + j] != needle[j])
                    break;
            }
            if (j == needleLength) return i;
        }
    }
    return -1;
}