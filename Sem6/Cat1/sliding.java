public class sliding {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n - k; i++) {
            int max = Integer.MAX_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
