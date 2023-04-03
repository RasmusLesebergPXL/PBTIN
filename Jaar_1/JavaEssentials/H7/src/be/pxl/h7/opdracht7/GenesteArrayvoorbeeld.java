package be.pxl.h7.opdracht7;

public class GenesteArrayvoorbeeld {
    public static void main(String[] args) {
        int[][] matrix = new int[4][6];
        for (int rij = 0; rij < matrix.length; rij++) {
            for (int kol = 0; kol < matrix[0].length; kol++) {
                matrix[rij][kol] = (rij+1)*(kol+1);
            }
        }

        for (int[] rij : matrix) {
            for (int element : rij) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
