package bigint;

public class BinarySearch {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        int[] arr = new int[]{1, 3, 5};
        System.out.println(add(arr, 0));
        System.out.println(add(arr, 1));
        System.out.println(add(arr, 2));
        System.out.println(add(arr, 6));
        int[] arr2 = new int[]{1, 3};
        System.out.println(add(arr2, 2));
    }

    //
    public static int add(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int min = arr[0];
        if (target <= min) {
            return 0;
        }
        int len = arr.length;
        int mid = 0;
        int start = 0;
        int end = len - 1;
        if (target > arr[end]) {
            return -1;
        }
        while (start <= end) {
            mid = (start + end) / 2;
            int midValue = arr[mid];
            if (target == midValue) {
                return mid;
            } else if (target < midValue) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }
}
