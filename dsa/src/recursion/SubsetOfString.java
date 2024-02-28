package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetOfString {

    /*private static void printSubsetOfString(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        printSubsetOfString(p + up.charAt(0), up.substring(1));
        printSubsetOfString(p, up.substring(1));
    }*/

    private static List<String> printSubsetOfString(String p, String up) {
        if (up.isEmpty()) {
            List<String> result = new ArrayList<>();
            result.add(p);
            return result;
        }

        List<String> l1 = printSubsetOfString(p + up.charAt(0), up.substring(1));
        List<String> l2 = printSubsetOfString(p, up.substring(1));

        l1.addAll(l2);

        return l1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printSubsetOfString("", "abc").toArray()));
    }
}
