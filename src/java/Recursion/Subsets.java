package Recursion;

import java.util.ArrayList;
import java.util.List;

//78
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        ans.add(item);
        if (nums.length <= 0){
            return ans;
        }
        for (int k = 1; k <= nums.length; k ++) {
            recursion(ans, item, nums,0, k);
        }
        return ans;
    }

    public void recursion(List<List<Integer>> ans, List<Integer> item, int[] nums, int index, int k) {
        if (item.size() == k) {
            ans.add(new ArrayList<>(item));
            return;
        }

        for (int i = index; i < nums.length - (k - item.size()) + 1; i ++) {
            item.add(nums[i]);
            System.out.println("before: " + item.toString() + "index: " + index);
            recursion(ans, item, nums, i+1, k);
            System.out.println("after: " + item.toString() + "index: " + index);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets c = new Subsets();
        System.out.println(c.subsets(new int[]{1,2,3}));
    }
}
