package string;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "a.";
        String str = s.toLowerCase().replaceAll("\\s", "");

        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if ((str.charAt(start) >= 'a' && str.charAt(start) <= 'z') && str.charAt(end) >= 'a' && str.charAt(end) <= 'z') {
                if (str.charAt(start) != str.charAt(end)) {
                    System.out.println("FALSE");
                    return;
                }
                start++;
                end--;
            }
            if(start < str.length() && (str.charAt(start) < 'a' || str.charAt(start) > 'z')) {
                start++;
            }
            if(end >= 0 && (str.charAt(end) < 'a' || str.charAt(end) > 'z')) {
                end--;
            }
        }
        System.out.println("TRUE");
    }
}
