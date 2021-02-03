package AlgorithmArray;
//29
public class Divide {
    public int divide(int dividend, int divisor) {
        boolean sign = true;
        if (divisor == 1) {
            return dividend;
        }else if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) return -dividend;
            return Integer.MAX_VALUE;
        }else if(divisor == 0) {
            return 0;
        }
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sign = false;
        }
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        long res = div(dividend, divisor);
        if (sign) {
            res = res > Integer.MAX_VALUE?Integer.MAX_VALUE:res;
        }
        return sign?(int)res:(int)-res;
    }
    public long div(long a, long b) {
        if (a > b) return 0;
        long count = 1;
        long tb = b;
        while (tb + tb >= a) {
            count += count;
            tb += tb;
        }
        return count + div(a-tb, b);
    }

    public static void main(String[] args) {
        Divide d = new Divide();
        System.out.println( d.divide(-2147483648, 2));
    }
}
