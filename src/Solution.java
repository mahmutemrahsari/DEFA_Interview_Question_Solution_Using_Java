public class Solution {


    public static int calculateMax(String s, int n) {  //better to return float

        if(s==null||s.length()==0)
            return Integer.MIN_VALUE; // can return 0 or throw exception

        //set the result to minimum integer value
        int max = Integer.MIN_VALUE;

        String[] rows = s.split("\n");

        int rowCount = rows.length;
        int colCount = rows[0].split(" ").length;

        //check for possible input errors
        if((rowCount ==0 && colCount == 0) || (n>rowCount && n>colCount))
            return Integer.MIN_VALUE; // can return 0 or throw exception



        int[][] m = new int[rowCount][colCount];


        //fill integer matrix by parsing text
        for(int i=0; i<rowCount; i++) //scan each row
        {
            String[] row = rows[i].split(" ");
            for(int j=0; j<colCount; j++) //scan each column
            {

                //There may be error in the input. We need to catch it if parseInt fails.
                try
                {
                    m[i][j] = Integer.parseInt(row[j]); //for each column
                }
                catch(Exception e)
                {
                    throw new NumberFormatException("Input Error!");
                }
            }
        }




        int res =1;
        for(int i=0;i<rowCount; i++)
        {
            for(int j=0;j<colCount; j++)
            {

                //calculate row max
                //ensure that we are in the matrix
                if(j<colCount-n+1 )
                {
                    //check whether we really need to do this calculation by comparing the numbers at the edges
                    if(j==0 ||  Math.abs(m[i][j-1])<Math.abs(m[i][j+n-1]))
                    {
                        res =1;
                        for(int k =0; k<n; k++)
                        {
                            res *=  m[i][j+k];
                        }

                        if(max<res)
                            max=res;
                    }
                }

                //calculate colums max
                //ensure that we are in the matrix
                if(i<rowCount-n+1 )
                {
                    //check whether we really need to do this calculation by comparing the numbers at the edges
                    if(i==0 || Math.abs(m[i-1][j])<Math.abs(m[i+n-1][j]))
                    {
                        res =1;
                        for(int k =0; k<n; k++)
                        {
                            res *=  m[i+k][j];
                        }

                        //update max value if new result is bigger
                        if(max<res)
                            max=res;
                    }
                }


                //calculate diagonal 1
                //ensure that we are in the matrix
                if(i<rowCount-n+1  && j<colCount-n+1)
                {
                    //check whether we really need to do this calculation by comparing the numbers at the edges
                    if(i==0 || j==0 || Math.abs(m[i-1][j-1])<Math.abs(m[i+n-1][j+n-1]))
                    {
                        res =1;
                        for(int k =0; k<n; k++)
                        {
                            res *=  m[i+k][j+k];
                        }

                        //update max value if new result is bigger
                        if(max<res)
                            max=res;
                    }
                }

                //calculate diagonal from bottom to top
                //ensure that we are in the matrix
                if(i>n-2  && j<colCount-n+1)
                {
                    //check whether we really need to do this calculation by comparing the numbers at the edges
                    if( i==n-1 ||  j== colCount-n || Math.abs(m[i-n][j+n])<Math.abs(m[i][j]) )
                    {
                        res =1;
                        for(int k =0; k<n; k++)
                        {
                            res *=  m[i-k][j+k];
                        }

                        //update max value if new result is bigger
                        if(max<res)
                            max=res;
                    }
                }


            }

        }
        return max;
    }







    public static void main(String[] args) {
        String txt =    "1 1 1 1 1 15 00 40 00 75 04 05 07 78 52 12 50 77 1 1\n"+
                        "1 1 1 40 17 81 18 57 88 87 17 40 98 43 69 48 04 9 1 99\n"+
                        "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n"+
                        "52 70 95 23 33 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n"+
                        "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n"+
                        "24 47 32 60 1 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n"+
                        "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n"+
                        "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n"+
                        "24 55 58 05 66 73 1 26 97 17 78 78 96 83 14 88 34 89 63 72\n"+
                        "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n"+
                        "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n"+
                        "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n"+
                        "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n"+
                        "19 80 81 68 05 94 47 69 28 73 92 1 86 52 17 77 04 89 55 40\n"+
                        "04 52 08 83 97 35 1 16 07 97 57 32 1 26 26 79 33 27 98 66\n"+
                        "88 36 68 87 57 62 -99 72 03 46 33 67 1 1 12 32 63 93 53 69\n"+
                        "04 42 16 73 38 -99 39 11 24 94 72 18 1 46 1 32 40 62 76 36\n"+
                        "20 69 36 41 -92 30 23 88 34 62 1 69 1 67 59 85 74 04 36 16\n"+
                        "1 1 35 29 -78 31 90 01 74 31 49 71 48 86 81 16 23 57 1 1\n"+
                        "1 1 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 1 1";



        try
        {
            System.out.println(calculateMax(txt,5));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}


// Problem 1: Integer Max value
// Problem 2: Ask about negative numbers? Can input have negative numbers?
//  What should we return if we have a null array
//I chose to give the number of elements to multiply as an argument to the function. This makes code more flexible.
// Multiplication of four two digit numbers can't be bigger than max integer value. But to make it more flexible I could have used float to keep max value and multiplication results.
