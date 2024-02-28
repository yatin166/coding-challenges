package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CamelcaseMatching {

    private static boolean isMatch(String query, String pattern) {

        int sIndex = 0, pIndex = 0;

        while (sIndex < query.length()) {
            if (pIndex < pattern.length() && query.charAt(sIndex) == pattern.charAt(pIndex)) {
                pIndex++;
            } else if (Character.isUpperCase((query.charAt(sIndex)))) {
                return false;
            }
            sIndex++;
        }

        return pIndex == pattern.length() && sIndex == query.length();
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {

        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(isMatch(query, pattern));
        }

        return result;
    }

    public static void main(String[] args) {
        String[] queries = { "FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack" };
        String pattern = "FoBaT";
        System.out.println(Arrays.toString(camelMatch(queries, pattern).toArray()));
    }
}
