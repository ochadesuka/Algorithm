package heap;

import java.util.Arrays;

public class Heap {
    public void heapSort(int[] a) {
        buildHeap(a);
        int k = a.length-1;
        while(k > 1) {
            swap(a, 1, k);
            k--;
            heapify(a, k, 1);
        }
    }

    public void buildHeap(int[] a) {
        for(int i = a.length/2; i >= 1; i--) {
            heapify(a, a.length-1, i);
        }
    }

    private void heapify(int[] a, int count, int i) {
        while (true) {
            int maxIndex = i;
            if (2 * i <= count && a[maxIndex] < a[2*i]) {
                maxIndex = 2 * i;
            }
            if (2 * i + 1 <= count && a[maxIndex] < a[2*i+1]) {
                maxIndex = 2 * i + 1;
            }
            if (maxIndex == i) {
                break;
            }
            swap(a, maxIndex, i);
            i = maxIndex;
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] nums = new int[]{-1,7,5,19,8,4,1,20,13,16};
        heap.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
