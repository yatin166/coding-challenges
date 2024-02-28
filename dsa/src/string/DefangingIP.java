package string;

public class DefangingIP {

    public static void main(String[] args) {
        String address = "255.100.50.0";
        StringBuilder defangedString = new StringBuilder();

        for (char c: address.toCharArray()) {
            if (Character.isDigit(c)) {
                defangedString.append(c);
            } else {
                defangedString.append("[" + c + "]");
            }
        }

        System.out.println(defangedString.toString());
    }
}
