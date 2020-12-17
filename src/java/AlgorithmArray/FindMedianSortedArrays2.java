package AlgorithmArray;

public class FindMedianSortedArrays2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int index1 = 0;
        int index2 = 0;
        while(true) {
            if (index1 == nums1.length) {
                return nums2[index2 + k - 1];
            }
            if (index2 == nums2.length) {
                return nums1[index1 + k -1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int m = k/2;
            int nIndex1 = Math.min(m-1, nums1.length);
            int nIndex2 = Math.min(m-1, nums2.length);
            if (nums1[nIndex1] <= nums2[nIndex2]) {
                k -= (nIndex1 - index1 + 1);
                index1 = nIndex1 + 1;
            }else {
                k -= (nIndex2 - index2 + 1);
                index2 = nIndex2 + 1;
            }
        }
    }
}
