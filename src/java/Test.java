import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntFunction;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String inStr = in.nextLine();
        String[] inStres = inStr.split(" ");
        int n = Integer.parseInt(inStres[0]);
        for (int i = 1; i < inStres.length; i ++) {
            list.add(inStres[i]);
        }
        String[] res = split(n, list);
        for (String str : res) {
            System.out.print(str + " ");
        }
    }

    public static String[] split(int n, List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String str : list) {
            if (str.length() <= 8 && str.length() > 0) {
                newList.add(addZero(str));
            }else {
                while(str.length() > 8) {
                    newList.add(str.substring(0, 8));
                    str = str.substring(8);
                }

                if (str.length() > 0) {
                    newList.add(addZero(str));
                }
            }
        }
        return newList.stream().sorted().toArray(String[]::new);
    }

    public static String addZero(String s) {
        StringBuffer strBuf = new StringBuffer(s);
        while(strBuf.length() < 8) {
            strBuf.append("0");
        }
        return strBuf.toString();
    }
}
