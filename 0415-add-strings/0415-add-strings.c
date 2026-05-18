char* addStrings(char* num1, char* num2) {
    int carry = 0;
    int len1 = strlen(num1), len2 = strlen(num2);
    int i = len1 - 1, j = len2 - 1;
    int maxLen = (len1 > len2 ? len1 : len2) + 1;
    int k = maxLen - 1;
    char* res = (char*)malloc((maxLen + 1) * sizeof(char));
    res[0] = '0';
    res[maxLen] = '\0';
    while (i >= 0 || j >= 0 || carry > 0) {
        int n1 = (i < 0) ? 0 : num1[i] - '0';
        int n2 = (j < 0) ? 0 : num2[j] - '0';
        int sum = n1 + n2 + carry;
        if (sum >= 10) carry = 1;
        else carry = 0;
        res[k] = (sum % 10) + '0';
        --k;
        --i;
        --j;
    }
    if (res[0] == '1') return res;
    else return &res[1];
}