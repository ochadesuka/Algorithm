package AlgorithmArray;
//338
public class CountBits {
    public int[] countBits(int num) {
        int[] counts = new int[num+1];
        for (int i = 0; i <= num; i ++) {
            int x = i;
            int count = 0;
            while (x != 0) {
                x = x & (x - 1);
                count++;
            }
            counts[i] = count;
        }
        return counts;
    }

    public int[] countBits2(int num) {
        int[] counts = new int[num+1];
        for (int i = 0; i <= num; i ++) {
            if ((i % 2) == 0) {
                counts[i] = counts[i >> 1];
            }else {
                counts[i] = counts[i >> 1] + 1;
            }
        }
        return counts;
    }
}
