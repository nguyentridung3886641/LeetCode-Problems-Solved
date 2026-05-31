/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize) {
    int* res = (int*)malloc((digitsSize + 1) * sizeof(int));
    int i = digitsSize - 1;
    int idx = digitsSize;
    int remind = 1;

    while (i >= 0) {
        int sum = digits[i] + remind;
        
        res[idx] = sum % 10;
        remind = sum / 10;

        --i;
        --idx;
    }
    if (remind == 1) {
        res[0] = 1;
        *returnSize = digitsSize + 1;
    }
    else {
        for (int i = 1; i < digitsSize + 1; ++i) {
            res[i - 1] = res[i];
        }
        *returnSize = digitsSize;
    }
    return res;
}