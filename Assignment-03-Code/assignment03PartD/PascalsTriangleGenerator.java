/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: PascalsTriangleGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment03PartD;

public class PascalsTriangleGenerator {

    public PascalsTriangleGenerator() {
    }

    public int[] computeRow(int rowToCompute) {
        int [] row = new int [rowToCompute];
        row [0] = 1;
        row [rowToCompute - 1] = 1;

        if (row.length == 1 || row.length == 2) {
            return row;
        }
        else {
            int temp [] = computeRow(rowToCompute - 1);

            for (int i = 1; i < row.length - 1; i++) {
                row [i] = temp [i - 1] + temp [i];
            }
        }
        return row;
    }
}
