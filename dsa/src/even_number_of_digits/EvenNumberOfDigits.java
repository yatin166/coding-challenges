package even_number_of_digits;

public class EvenNumberOfDigits {

    private static int digits(int num) {
        if (num < 0)
            num = num * -1;

        int k = 0;

        while (num > 0) {
            num = num / 10;
            k++;
        }

        return k;
    }

    private static boolean isEven(int num) {
        return digits(num) % 2 == 0;
    }

    public static void main(String[] args) {
        int[] nums = { 12, 3425, 2, 6, 7896, 789653, -1112 };
        int evenNumberOfDigits = 0;
        for (int num : nums) {
            if (isEven(num)) {
                evenNumberOfDigits++;
            }
        }

        System.out.println(evenNumberOfDigits);
    }
}
