package remove_duplicate_from_sorted_array;

// Used Two pointer method
public class RemoveDuplicateFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[k] != nums[j]){
                k++;
                nums[k] = nums[j];
            }
        }

        return k + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 4, 5, 5 };
        int k = removeDuplicates(arr);
        System.out.println(k);
    }
}
