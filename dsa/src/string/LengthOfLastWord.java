package string;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "luffy is still joyboy";
        String[] stringArray = s.trim().split(" ");
        int length = stringArray.length > 0 ? stringArray[stringArray.length - 1].length() : 0;
        System.out.println(length);
    }
}
