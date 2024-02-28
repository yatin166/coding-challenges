package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfString {

    private static void permutationOfString(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + ", ");
            return;
        }

        for (int i = 0; i < p.length() + 1; i++) {
            permutationOfString(p.substring(0, i) + up.charAt(0) + p.substring(i), up.substring(1));
        }
    }

    // return array list
    private static List<String> permutationOfStringWithList(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            result.addAll(permutationOfStringWithList(p.substring(0, i) + up.charAt(0) + p.substring(i), up.substring(1)));
        }

        return result;
    }

    // return array list
    private static int permutationOfStringCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i <= p.length(); i++) {
            ans += permutationOfStringCount(p.substring(0, i) + up.charAt(0) + p.substring(i), up.substring(1));
        }

        return ans;
    }

    public static void main(String[] args) {
        //permutationOfString("", "abc");
        System.out.println(Arrays.toString(permutationOfStringWithList("", "abc").toArray()));
        System.out.println(permutationOfStringCount("", "abc"));
    }
}
