package recursion;

public class IgnoreAllAInString {

    private static String removeA(String str, StringBuilder sb, int index) {
        if (index == str.length()) {
            return sb.toString();
        }

        if (str.charAt(index) != 'a') {
            sb.append(str.charAt(index));
        }

        return removeA(str, sb, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(removeA("", new StringBuilder(), 0));
    }
}
