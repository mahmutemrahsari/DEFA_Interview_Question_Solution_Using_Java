import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> highestValues = new ArrayList<>();
        String txt = "1 2 93 4\n"+ "5 6 7 8\n" + "9 32 11 12\n"+ "13 41 15 16";

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
        System.out.println(Arrays.deepToString(intTwoArr));

        //Find the highest product of 4*2digits
        int highVal=1;
//TODO
        boolean increased = false; //Control mechanism
        for(int i =0; i < row; i++){
            for (int x:intTwoArr[i]){
                if(increased){
                    highVal *=x;
                }
            }
            increased=true;
            highestValues.add(highVal);
        }

        System.out.println("HIGH val: "+highVal);

    }

}
