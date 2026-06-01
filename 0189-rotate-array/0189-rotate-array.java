class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Tránh trường hợp k > n

        // 1. Đảo ngược toàn bộ mảng
        reverse(nums, 0, n - 1);
        // 2. Đảo ngược k phần tử đầu
        reverse(nums, 0, k - 1);
        // 3. Đảo ngược phần còn lại
        reverse(nums, k, n - 1);
    }

    // Hàm phụ trợ để đảo ngược đoạn từ start đến end
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}