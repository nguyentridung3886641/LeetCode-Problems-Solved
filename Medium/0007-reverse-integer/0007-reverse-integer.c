void convertAndReverse(int size, int n, char* res) {
    for (int i = 0; i < size - 1; i++) {
        res[i] = (n % 10) + '0';
        n /= 10;
    }
    res[size - 1] = '\0';
}

int reverse(int x){
    int count = 0, temp = x;
    int flag = (x > 0) ? 1 : -1;
    char maxVal[11] = "2147483647", minVal[11] = "2147483647";

    while (temp != 0) {
        temp /= 10;
        ++count;
    }

    char res[count + 1];

    if (flag == 1)
        convertAndReverse(count + 1, x, res);
    else {
        if (x == -2147483648)
            convertAndReverse(count + 1, abs(x + 1), res);
        else
            convertAndReverse(count + 1, abs(x), res);
    }

    if (count == 10) {
        if (flag == 1 && strcmp(res, maxVal) > 0)
            return 0;
        else if (flag == -1 && strcmp(res, minVal) > 0)
            return 0;
    }

    if (x == -2147483648)
        res[0] = res[0] + 1;

    for (int i = 0; i < count; i++) {
        temp = temp * 10 + (res[i] - '0');
    }
    
    return temp * flag;
}