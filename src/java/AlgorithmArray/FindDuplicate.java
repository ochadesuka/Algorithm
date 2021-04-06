package AlgorithmArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//287
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] == nums[i+1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
