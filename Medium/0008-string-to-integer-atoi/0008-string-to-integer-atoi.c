int myAtoi(char* s) {
    int i = 0, g = 1;
    long x = 0;
    int mn = -2147483648;
    int mx = 2147483647;

    while (s[i] == ' ') i++;

    if (s[i] == '+' || s[i] == '-') {
        if (s[i] == '-') g = -1;
        i++;
    }

    while (s[i] >= '0' && s[i] <= '9') {
        x = x * 10 + (s[i] - '0');

        if (g == 1 && x > mx) return mx;
        if (g == -1 && -x < mn) return mn;

        i++;
    }

    return g * x;
}