package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "CMLXXV";
        Map<String, Integer> map = new HashMap<>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};
        int i = 0, j = i + 1;
        int num = 0;
        while (i < s.length()) {
            if (j < s.length() && map.containsKey(Character.toString(s.charAt(i)) + Character.toString(s.charAt(j)))) {
                num += map.get(Character.toString(s.charAt(i)) + Character.toString(s.charAt(j)));
                i = j + 1;
            } else {
                num += map.get(Character.toString(s.charAt(i)));
                i++;
            }
            j = i + 1;
        }

        System.out.println(num);
    }
}
