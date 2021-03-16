package sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class FastSort {
    public static void fastSort(int[] a, int l, int r) {
        if (l > r) {
            return;
        }
        int base = a[r];
        int i = l, j = r;
        while (i < j) {
            while (a[i] <= base && i < j) {
                i++;
            }
            while(a[j] >= base && i < j) {
                j--;
            }
             if (i < j) {
                 int t = a[i];
                 a[i] = a[j];
                 a[j] = t;
             }
            System.out.println(Arrays.toString(a));
        }
        int tt = a[r];
        a[r] = a[j];
        a[j] = tt;
        fastSort(a, l, j-1);
        fastSort(a, j+1, r);
    }

    public static void main(String[] args) {
        int[] a = new int[]{8,10,2,3,6,1,5};
        fastSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
