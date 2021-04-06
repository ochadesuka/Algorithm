package AlgorithmArray;

import java.util.ArrayList;
import java.util.List;
//448
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            int index = (nums[i] - 1) % nums.length;
            nums[index] += nums.length;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] < nums.length) {
                res.add(nums[i]);
            }
        }
        return res;
    }
}
