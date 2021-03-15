import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String line = sc.nextLine();
        while (!line.equals("end")) {
            list.add(sc.nextLine());
            line = sc.nextLine();
        }
        System.out.println(findFree(list));
    }

    public static int findFree(List<String> list) {
        int free = 0;
        Map<String,Integer> map = new HashMap<>();
        for (String date : list) {
            String[] dates = date.split("//.");
            if (map.containsKey(dates[0])) {
                if (Integer.parseInt(dates[1]) < map.get(dates[0])) {
                    map.put(dates[0], Integer.parseInt(dates[1]));
                }
            }else {
                map.put(dates[0], Integer.parseInt(dates[1]));
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            StringBuffer sb = new StringBuffer(entry.getKey());
            sb.append(".").append(entry.getValue());
            for (String str : list) {
                if (sb.toString().equals(str)) {
                    free++;
                }
            }
        }
        return free;
    }
}
