public class ExamPrep {
    public static int[] flatten(int[][] x) {
        int total = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                total += 1;
            }
        }
        int[] value = new int[total];
        int index = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                value[index++] = x[i][j];
            }
        }
        return value;
    }

    public static void main(String[] args) {

    }
}
