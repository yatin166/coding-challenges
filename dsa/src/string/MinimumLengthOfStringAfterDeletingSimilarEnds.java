package string;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    public static int minimumLength(String s) {
        int start = 0, end = s.length() - 1;

        if (s.length() == 1) {
            return 1;
        }

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                while (start < end && s.charAt(start + 1) == s.charAt(start))
                    start++;
                while (end > start && s.charAt(end - 1) == s.charAt(end))
                    end--;
                start++;
                end--;
            } else {
                break;
            }
        }

        return end < start ? 0 : end - start + 1;
    }

    public static void main(String[] args) {
        String s = "aabccabba";
        System.out.println(minimumLength(s));
    }
}
