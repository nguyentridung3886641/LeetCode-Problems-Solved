class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Tìm vị trí đầu tiên (isFirst = true)
        int first = findBound(nums, target, true);
        
        // Nếu không tìm thấy vị trí đầu tiên, chắc chắn target không tồn tại
        if (first == -1) {
            return new int[]{-1, -1};
        }
        
        // Tìm vị trí cuối cùng (isFirst = false)
        int last = findBound(nums, target, false);
        
        return new int[]{first, last};
    }

    /**
     * Hàm Binary Search đa năng để tìm biên.
     * @param isFirst true nếu tìm vị trí xuất hiện đầu tiên, false nếu tìm vị trí cuối cùng.
     */
    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid; // Tạm lưu vị trí tìm thấy
                if (isFirst) {
                    // Để tìm vị trí ĐẦU TIÊN, tiếp tục ép không gian tìm kiếm sang trái
                    right = mid - 1;
                } else {
                    // Để tìm vị trí CUỐI CÙNG, tiếp tục ép không gian tìm kiếm sang phải
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}