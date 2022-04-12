import java.util.Random;

/**
 * 快速排序（带随机）
 */
class QuickSort {

    public static void main(String[] args) {
        int[] nums = {5, 1, 2, 4, 3};
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = random.nextInt(i + 1);
            swap(nums, index, i);
        }
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int value = nums[lo];
        while (true) {
            while (nums[++i] < value) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] > value) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}