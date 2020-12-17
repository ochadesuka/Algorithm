package AlgorithmArray;

import java.util.Stack;

//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nms2。请你找出并返回这两个正序数组的中位数。
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int middle = sum / 2;
        System.out.println(middle);
        Stack<Integer> stack = new Stack<>();
        int l1 = 0;
        int l2 = 0;
        while (stack.size() <= middle) {
            if(l1 < nums1.length && l2 < nums2.length) {
                if (nums1[l1] <= nums2[l2]) {
                    stack.push(nums1[l1]);
                    l1++;
                }else {
                    stack.push(nums2[l2]);
                    l2++;
                }
            }else if(l1 >= nums1.length && l2 < nums2.length ) {
                stack.push(nums2[l2]);
                l2++;
            }else if(l1 < nums1.length && l2 >= nums2.length) {
                stack.push(nums1[l1]);
                l1++;
            }else {
                return 0;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0 ) {
            int s1 = stack.pop();
            int s2 = stack.pop();

            return ((double)s1 + (double)s2) / 2;
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(FindMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
