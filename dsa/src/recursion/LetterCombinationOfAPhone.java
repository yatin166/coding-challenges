package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationOfAPhone {

    private static void letterCombinationOfAPhone(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + ", ");
            return;
        }

        int digit = (int) up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char newP = (char) ('a' + i);
            letterCombinationOfAPhone(p + newP, up.substring(1));
        }
    }

    // Return list
    private static List<String> letterCombinationsOfPhoneWithList(String p, String up, String[] phone) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = (up.charAt(0) - '0');
        List<String> result = new ArrayList<>();
        for (int i = 0; i < phone[digit].length(); i++) {
            char newP = phone[digit].charAt(i);
            result.addAll(letterCombinationsOfPhoneWithList(p + newP, up.substring(1), phone));
        }
        return result;
    }

    public static void main(String[] args) {
        //letterCombinationOfAPhone("", "12");
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        System.out.println(Arrays.toString(letterCombinationsOfPhoneWithList("",  "7", phone).toArray()));
    }
}
