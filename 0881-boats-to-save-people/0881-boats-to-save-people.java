class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);

        int left = 0, right = n - 1;
        int ans = 0;
        while (left < right) {
            if (people[left] > limit / 2) {
                break;
            }

            if (people[left] + people[right] <= limit) {
                ++ans;
                ++left;
                --right;
            } else {
                ++ans;
                --right;
            }
        }
        
        ans += right - left + 1;

        return ans;
    }
}