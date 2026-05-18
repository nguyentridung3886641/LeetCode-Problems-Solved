char* reverseString(char* a);

char* addBinary(char* a, char* b) {
    int aLength = strlen(a);
    int bLength = strlen(b);
    int maxLength = (aLength < bLength) ? bLength : aLength;
    int i = aLength - 1;
    int j = bLength - 1;
    int k = 0;
    int carry = 0;
    char* res = (char*)malloc((maxLength + 2) * sizeof(char));
    while (i >= 0 || j >= 0 || carry) {
        int sum = carry;
        if (i >= 0) sum += a[i--] - '0';
        if (j >= 0) sum += b[j--] - '0';
        res[k++] = (sum % 2) + '0';
        carry = sum / 2;
    }
    res[k] = '\0';
    return reverseString(res);
}
char* reverseString(char* a) {
    int aLength = strlen(a);
    for (int i = 0; i < aLength / 2; i++) {
        char temp = a[i];
        a[i] = a[aLength - i - 1];
        a[aLength - i - 1] = temp;
    }
    return a;
}