package Recursion;
//779
public class KthGrammar {
    public int kthGrammar(int N, int K) {
        return grammer(N, K, 0);
    }

    public int grammer(int n, int k, int start) {
        if (n == 0 || n == 1) return start;
        int half = (1 << (n-2));
        if (k <= half) {
            return grammer(n-1, k, start);
        }
        return grammer(n - 1, k - half, 1- start);
    }
}
