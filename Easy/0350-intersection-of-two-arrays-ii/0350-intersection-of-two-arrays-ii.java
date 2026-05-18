import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> insection = new ArrayList<>();
        for (int i = 0; i < l1; ++i) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < l2; ++i) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                insection.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[insection.size()];
        for (int i = 0; i < insection.size(); i++) {
            res[i] = insection.get(i);
        }
        return res;
    }
}