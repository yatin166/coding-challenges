package recursion;

public class DiceCombinationForNumberK {

    private static void dice(String p, int target) {
        if (target == 0) {
            System.out.print(p + ", ");
            return;
        }

        for (int i = 1; i <= target; i++) {
            dice(p+i, target - i);
        }
    }

    public static void main(String[] args) {
        dice("", 4);
    }
}
