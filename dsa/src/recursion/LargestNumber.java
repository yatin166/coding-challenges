package recursion;

public class LargestNumber {

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];

        while (start <= end) {
            while ((nums[start] + "" + pivot).compareTo(pivot + "" + nums[start]) > 0) {
                start++;
            }

            while ((nums[end] + "" + pivot).compareTo(pivot + "" + nums[end]) < 0) {
                end--;
            }

            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(nums, low, end);
        quickSort(nums, start, high);
    }

    private static String largestNumber(int[] nums) {
        quickSort(nums, 0 , nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int num: nums) {
            sb.append(num);
        }

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
                i++;
        }

        return i == sb.length() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
