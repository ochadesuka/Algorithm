package Recursion;

import java.util.ArrayList;
import java.util.List;
//77
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if (n <= 0){
            return ans;
        }
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = i+1;
        }
        recursion(ans, item, nums,0, k);
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
        Combine c = new Combine();
        System.out.println(c.combine(4, 2));
    }
}
