package Array;

public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int curr, next;
        int[] arr = new int[2];
        for (int i = 0; i < len - 1; i++) {
            curr = nums[i];
            for (int j = i+1; j < len; j++) {
                next = nums[j];
                if (curr + next == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }

            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Q1 demo=new Q1();
        int[] x={2,5,5,11};
        int target=10;
        int[] res=demo.twoSum(x,target);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
