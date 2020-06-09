import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var heaps = new Heaps(9);
        heaps.insert(15);
        heaps.insert(10);
        heaps.insert(3);
        heaps.insert(8);
        heaps.insert(12);
        heaps.insert(9);
        heaps.insert(4);
        heaps.insert(1);
        heaps.insert(24);
        heaps.remove();
        System.out.println("Done");
        System.out.println(Arrays.toString(heaps.heap));
    }
}