class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0;
        int right = length - 1;
        while (true) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) 
                return new int[]{left + 1, right + 1};
            else if (sum < target) 
                ++left;
            else --right;
        }
    }
}