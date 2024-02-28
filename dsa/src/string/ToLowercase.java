package string;

import java.util.HashMap;
import java.util.Map;

public class ToLowercase {

    public static void main(String[] args) {
        String s = "LOVELY!";
        Map<Character, Character> map = new HashMap<Character, Character>() {{
                put('A', 'a');
                put('B', 'b');
                put('C', 'c');
                put('D', 'd');
                put('E', 'e');
                put('F', 'f');
                put('G', 'g');
                put('H', 'h');
                put('I', 'i');
                put('J', 'j');
                put('K', 'k');
                put('L', 'l');
                put('M', 'm');
                put('N', 'n');
                put('O', 'o');
                put('P', 'p');
                put('Q', 'q');
                put('R', 'r');
                put('S', 's');
                put('T', 't');
                put('U', 'u');
                put('V', 'v');
                put('W', 'w');
                put('X', 'x');
                put('Y', 'y');
                put('Z', 'z');
        }};

        StringBuilder lowerCaseString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character lowerCaseChar = map.get(s.charAt(i));
            if (lowerCaseChar != null) {
                lowerCaseString.append(lowerCaseChar);
            } else {
                lowerCaseString.append(s.charAt(i));
            }
        }

        // Efficient solution would be to use ASCII value and do basic math

        System.out.println(lowerCaseString);
    }
}
