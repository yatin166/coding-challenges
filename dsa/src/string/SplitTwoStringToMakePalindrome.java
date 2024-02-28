package string;

public class SplitTwoStringToMakePalindrome {

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while ( start <= end ) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    private static boolean checkPalindromeFormation(String a, String b) {
        for (int index = 0; index <= a.length(); index++) {
            String aPrefix = a.substring(0, index);
            String aSuffix = a.substring(index, a.length());
            String bPrefix = b.substring(0, index);
            String bSuffix = b.substring(index, b.length());
            if (isPalindrome(aPrefix + bSuffix) || isPalindrome(bPrefix + aSuffix)) {
                return true;
            }
        }
        return false;
    }

    // Optimizing

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean checkPalindromeFormation2(String a, String b) {
        int start = 0;
        int end = b.length() - 1;
        while (start < end && a.charAt(start) == b.charAt(end)) {
            start++;
            end--;
        }
        return isPalindrome(a, start, end) || isPalindrome(b, start, end);
    }



    public static void main(String[] args) {
        String a = "pvhmupgqeltozftlmfjjde";
        String b = "yjgpzbezspnnpszebzmhvp";
        System.out.println(checkPalindromeFormation2(a, b) || checkPalindromeFormation2(b, a));
    }
}
