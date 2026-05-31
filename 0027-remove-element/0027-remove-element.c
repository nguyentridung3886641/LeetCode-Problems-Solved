void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int removeElement(int* nums, int numsSize, int val) {
    int i = 0, j = numsSize - 1;
    while (i <= j) {
        if (nums[i] == val && nums[j] == val) {
            --j;
            continue;
        }
        else if (nums[i] == val && nums[j] != val) {
            swap(&nums[i], &nums[j]);
            --j;
            ++i;
        }
        else if (nums[i] != val && nums[j] == val) {
            --j;
            ++i;
        }
        else
            ++i;
    }
    return i;
}
