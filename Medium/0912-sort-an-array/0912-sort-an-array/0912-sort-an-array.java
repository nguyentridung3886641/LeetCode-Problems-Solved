class Solution {
    public int[] sortArray(int[] nums) {
        int numsLength = nums.length;
        int l = 0;
        int r = numsLength - 1;
        mergeSort(nums, l, r);
        return nums;
    }
    public void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(l, r, m, nums);
        }
    }
    public void merge (int l, int r, int m, int[] nums) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = nums[l + i];
        for (int i = 0; i < n2; i++) R[i] = nums[m + i + 1];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) nums[k++] = L[i++];
            else nums[k++] = R[j++];
        }
        while (i < n1) nums[k++] = L[i++];
        while (j < n2) nums[k++] = R[j++];
    }
}