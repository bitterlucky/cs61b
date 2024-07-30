public class Arrays {
    public static int[] insert(int[] arr, int item, int position) {
        int[] newArr = new int[arr.length + 1];
        position = Math.min(arr.length, position);
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }
        newArr[position] = item;
        for (int i = position + 1; i < arr.length + 1; i++) {
            newArr[i] = arr[i - 1];
        }
        return newArr;
    }
    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 -i] = temp;
        }
    }
    public static int[] replicate(int[] arr) {
        int total = 0;
        for(int num : arr) {
            total += num;
        }
        int[] value = new int[total];
        int index = 0;
        for(int num : arr) {
            for (int i = 0; i < num; i++) {
                value[index] = num;
                index++;
            }
        }
        return value;
    }
}
