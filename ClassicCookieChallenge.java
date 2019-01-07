import java.util.ArrayList;
import java.util.Scanner;

public class ClassicCookieChallenge {
    private static int cookie[][];
    private static ArrayList result;
    private static int row,col,length;


    private static void moveRight(int i, int j){

        calculateChipLength(i,j-1);

    }

    private static void moveLeft(int i, int j){

        calculateChipLength(i,j+1);

    }

    private static void moveUp(int i, int j){

        calculateChipLength(i-1,j);

    }

    private static void moveDown(int i, int j){

        calculateChipLength(i+1,j);

    }

    private static Boolean checkBounds(int i, int j){

        return i<0 || i>=row || j<0 || j>=col;
    }

    private static void calculateChipLength(int i, int j) {

        length++;
        cookie[i][j]=0;

        if(!checkBounds(i,j+1) && cookie[i][j+1]==1)
            moveLeft(i,j);                             //move left

        else if(!checkBounds(i+1,j)  && cookie[i+1][j]==1)
            moveDown(i,j);                             //move down

        else if(!checkBounds(i,j-1)  && cookie[i][j-1]==1)
            moveRight(i,j);                            //move right

        else if(!checkBounds(i-1,j)  && cookie[i-1][j]==1)
            moveUp(i,j);                               //move up

        else{

            length=length+0;
            result.add(length);
            length=0;
        }

    }

    private static void makeCookie(){

        Scanner scanner=new Scanner(System.in);
        scanner.useDelimiter("\\s");
        System.out.println("Enter the length and breath of cookie separated by space ");
        row=scanner.nextInt();
        col=scanner.nextInt();

        cookie=new int[row][col];
        result=new ArrayList();

        System.out.println("Enter the cookie pattern using 1 and 0 ");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                cookie[i][j]=scanner.nextInt();
            }
        }

        scanner.close();

    }

    public static void main(String args[]){

       makeCookie();

       //Traversal of the cookie
       for(int j=0;j<col;j++){
           for(int i=0;i<row;i++){
               if(cookie[i][j]==1)
                   calculateChipLength(i,j);

           }
       }

       System.out.println(result.toString());

    }


}
