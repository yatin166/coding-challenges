package string;

public class RotateString {

    public static boolean rotateString(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i + 1, s.length()) + s.substring(0, i + 1);
            if (str.equals(goal)) {
                return true;
            }
        }
        return false;

        // More efficient would be
        // return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abced";
        System.out.println(rotateString(s, goal));
    }
}
