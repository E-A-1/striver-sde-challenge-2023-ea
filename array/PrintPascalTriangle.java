package array;

import java.util.ArrayList;

public class PrintPascalTriangle {
    public static ArrayList<Long> generateRow(int row) {
        ArrayList<Long> tempArrayList = new ArrayList<>();
        tempArrayList.add((long) 1);
        long ans = 1;
        for (int j = 1; j < row; j++) {
            ans = ans * (row - j);
            ans = ans / j;
            tempArrayList.add((long) ans);
        }
        return tempArrayList;
    }

    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        // Write your code here.
        ArrayList<ArrayList<Long>> answeArrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            answeArrayList.add(generateRow(i));

        }

        return answeArrayList;
    }
}
