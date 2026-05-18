class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        for (int i = 0; i < arr1Length; i++) {
            ++freq[arr1[i]];
        }
        int j = 0;
        for (int i = 0; i < arr2Length; i++) {
            int k = 0;
            while (k < freq[arr2[i]]) {
                arr1[j] = arr2[i];
                k++;
                j++;
            }
            freq[arr2[i]] = 0;
        }
        for (int i = 0; i < 1001 && j < arr1Length; i++) {
            int k = 0;
            if (freq[i] > 0) {
                while (k < freq[i]) {
                    arr1[j] = i;
                    k++;
                    j++;
                }
            }
        }
        return arr1;
    }
}