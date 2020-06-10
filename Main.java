import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var heaps = new Heaps(6);
        int[] nums = { 5, 3, 8, 4, 1, 2 };
        var arr = heaps.heapify(nums);
        // for (var i : nums)
        // heaps.insert(i);
        // int[] arr = new int[nums.length];
        // for (int i = nums.length - 1; i >= 0; i--)
        // arr[i] = heaps.remove();
        System.out.println(Arrays.toString(arr));
        // heaps.insert(15);
        // heaps.insert(10);
        // heaps.insert(3);
        // heaps.insert(8);
        // heaps.insert(12);
        // heaps.insert(9);
        // heaps.insert(4);
        // heaps.insert(1);
        // heaps.insert(24);
        // heaps.remove();
        // heaps.remove();
        // heaps.remove();
        // heaps.remove();

        // System.out.println("Done");
        // System.out.println(Arrays.toString(heaps.heap));
    }
}