package bitwise;

public class AddBinary {

    public static String addBinary(String a, String b) {
        int maxlen = a.length() > b.length() ? a.length() : b.length();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        String s = "";

        while (maxlen > 0) {
            if ((i >= 0 && j >= 0 && a.charAt(i) == '1' && b.charAt(j) == '1') || (i >= 0 && a.charAt(i) == '1' && carry == 1) || (j >= 0 && b.charAt(j) == '1' && carry == 1)) {
                s = "0" + s;
                carry = 1;
            } else if ((i >= 0 && a.charAt(i) == '1') || (j >= 0 && b.charAt(j) == '1') || (carry == 1)) {
                s = "1" + s;
                carry = 0;
            } else {
                s = "0" + s;
                carry = 0;
            }
            i--;
            j--;
            maxlen--;
        }

        return carry == 1 ? carry + s : s;
    }

    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        System.out.println(addBinary(a, b));
    }
}
