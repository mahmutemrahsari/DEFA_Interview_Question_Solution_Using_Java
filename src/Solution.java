import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> highestValues = new ArrayList<>();
        String txt = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n"+
                "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n"+
                "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n"+
                "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n"+
                "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n"+
                "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n"+
                "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n"+
                "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n"+
                "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n"+
                "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n"+
                "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n"+
                "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n"+
                "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n"+
                "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n"+
                "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n"+
                "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n"+
                "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n"+
                "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n"+
                "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n"+
                "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";

        txt = txt.replace("\n"," ");
        String strArray[] = txt.split(" ");

        //print elm of strArr
        for(int i =0; i<strArray.length;i++){
            System.out.println(strArray[i]);
        }

        System.out.println("strArrLength "+strArray.length);
        System.out.println("replaced TXT "+txt);

        int[] intArr = new int[strArray.length];
        for (int i=0; i<strArray.length;i++){
            intArr[i]=Integer.parseInt(strArray[i]);
        }

        System.out.println("intArr elem");
        for (int k : intArr) {
            System.out.println(k);
        }

        //For create 2d array Matrix which has same dimencions
        int row = (int) Math.sqrt(intArr.length);
        int column = (int) Math.sqrt(intArr.length);

        System.out.println("row: " + row + " column: " + column);


        System.out.println("Convert to Two dim intArr!!!");
        int[][] intTwoArr = new int[row][column];
        for(int i =0; i < row; i++){
            for(int j=0; j< column; j++){
                intTwoArr[i][j]= intArr[(i*column)+j];
            }
        }
        fourByFourMatrixCreator(intTwoArr);
        System.out.println(Arrays.deepToString(intTwoArr));
        System.out.println("getMaxProdOfAdj: " + getMaxProdOfAdj(intTwoArr));

    }

    //Brute Force(!)
    // Returns highest value for 4*2digits
    static int getMaxProdOfAdj(int arr[][]){
        int n =4; //4*4 matrix
        int max = 0, result;

        // iterate the rows.
        for (int r = 0; r < n; r++)
        {
            // iterate the columns.
            for (int c = 0; c < n; c++)
            {
                // check the maximum product
                // in horizontal row.
                if ((c - 3) >= 0)
                {
                    result = arr[r][c] * arr[r][c - 1] *
                            arr[r][c - 2] * arr[r][c - 3];
                    if (max < result)
                        max = result;
                }

                // check the maximum product
                // in vertical row.
                if ((r - 3) >= 0)
                {
                    result = arr[r][c] * arr[r - 1][c] *
                            arr[r - 2][c] * arr[r - 3][c];

                    if (max < result)
                        max = result;
                }

                // check the maximum product in
                // diagonal (going through down - right)
                if ((r - 3) >= 0 && (c - 3) >= 0)
                {
                    result = arr[r][c] * arr[r - 1][c - 1] *
                            arr[r - 2][c - 2] * arr[r - 3][c - 3];

                    if (max < result)
                        max = result;
                }
                //TODO
                /*
                // check the maximum product in
                // anti-diagonal (going through up - right)
                if ((r - 3) >= 0 && (c - 1) >= 0)
                {
                    result = arr[r+3][c-3] * arr[r - 1][c + 1] *
                            arr[r - 2][c + 2] * arr[r - 3][c + 3];

                    if (max < result)
                        max = result;
                }

                 */
            }
        }

        return max;
    }

    static int[][] fourByFourMatrixCreator(int[][] matrix){
        int[][] fourByfourMatrix = new int[4][4];

        //TODO
        //Iteration for all possible 4x4 Matrices
        int k=0;
        for(int i =0;i<4;i++)
            for(int j=0;j<4;j++)
                    fourByfourMatrix[i][j] = matrix[i][j];



        System.out.println("new matrix: "+Arrays.deepToString(fourByfourMatrix));
        return fourByfourMatrix;
    }





}
