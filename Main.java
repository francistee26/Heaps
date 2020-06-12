import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // var heaps = new Heaps(6);
        int[] nums = { 5, 3, 8, 4, 1, 2 };
        // var arr = heaps.heapify(nums);
        // var arr = heaps.twoSum(nums, 6);
        // for (var i : nums)
        // heaps.insert(i);
        // int[] arr = new int[nums.length];
        // for (int i = nums.length - 1; i >= 0; i--)
        // arr[i] = heaps.remove();
        // System.out.println(Arrays.toString(arr));
        // System.out.println(heaps.isPalindrome(-121));
        // heaps.insert(5);
        // heaps.insert(3);
        // heaps.insert(8);
        // heaps.insert(4);
        // heaps.insert(1);
        // heaps.insert(2);
        // System.out.println(heaps.isMaxHeap());
        // heaps.insert(4);
        // heaps.insert(1);
        // heaps.insert(24);
        // heaps.remove();
        // heaps.remove();
        // heaps.remove();
        // heaps.remove();

        // System.out.println("Done");
        // System.out.println(Arrays.toString(heaps.heap));

        var minHeap = new MinHeap(3);
        minHeap.insert(2, "Tholley");
        minHeap.insert(1, "Hassan");
        minHeap.insert(0, "Francis");
        System.out.println(minHeap.remove());
        System.out.println();
        System.out.println("Done");
    }
}