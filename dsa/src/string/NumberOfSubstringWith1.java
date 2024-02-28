package string;

public class NumberOfSubstringWith1 {

    public static int numSub(String s) {
        int total = 0;
        int index = 0;
        int consecutiveOnes = 0;
        int answer = 0;

        while (index < s.length()) {
            if (s.charAt(index) == '1') {
                total += 1;
                consecutiveOnes = ((total + 1) * total) / 2;
            } else {
                total = 0;
                answer += consecutiveOnes;
                consecutiveOnes = 0;
            }
            index++;
        }
        answer += consecutiveOnes;
        return answer % (int)1e9 + 7;
    }

    public static void main(String[] args) {
        String s = "1111111";
        /*int total = 0;
        int index = 0;
        int consecutiveOnes = 0;
        int answer = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '1') {
                total += 1;
                consecutiveOnes = ((total + 1) * total) / 2;
            } else {
                total = 0;
                answer += consecutiveOnes;
                consecutiveOnes = 0;
            }
            index++;
        }
        answer += consecutiveOnes;*/
        System.out.println(numSub(s));
    }
}
