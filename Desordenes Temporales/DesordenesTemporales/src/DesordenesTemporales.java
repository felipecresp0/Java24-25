import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class DesordenesTemporales {

    public static void add(int[] bit, int i, int val) {
        for (; i < bit.length; i += i & -i) {
            bit[i] += val;
        }
    }

    public static int query(int[] bit, int i) {
        int ans = 0;
        for (; i > 0; i -= i & -i) {
            ans += bit[i];
        }
        return ans;
    }

    public static List<Integer> countSmaller(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
        }
        int[] bit = new int[nums.length + 1];
        Integer[] ans = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = query(bit, nums[i] - 1);
            add(bit, nums[i], 1);
        }
        return Arrays.asList(ans);
    }

    public static void main(String args[]) {
        Scanner t = new Scanner(System.in);
        int caso = t.nextInt();
        while (caso != 0) {
            int[] input = new int[caso];
            int ne = 0;
            while (caso > 0) {
                int num = t.nextInt();
                input[ne] = num;
                ne++;
                caso--;
            }
            long tot = 0;
            List<Integer> a = countSmaller(input);
            for (int i = 0; i < a.size(); i++) {
                tot += a.get(i);
            }
            System.out.println(tot);
            caso = t.nextInt();
        }
    }
}