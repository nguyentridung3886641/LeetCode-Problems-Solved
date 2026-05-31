void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    if (n == 0) return;

    int i = 0, j = 0, k = 0;
    int temp[nums1Size];

    while (i < nums1Size) {
        if (((j < m && k < n) && nums1[j] <= nums2[k]) || (k >= n && j < m)) {
            temp[i++] = nums1[j++];
        }
        else if (((k < n && j < m) && nums2[k] <= nums1[j]) || (j >= m && k < n)) {
            temp[i++] = nums2[k++];
        }
    }

    for (int i = 0; i < nums1Size; i++) {
        nums1[i] = temp[i];
    }
}