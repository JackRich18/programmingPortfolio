import java.util.Scanner;
//import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

class Math{
    Scanner sc = new Scanner(System.in);
    int s;
    int q = 5;
    int p = 0;
    int i = 0;

    public String[] arr = {"what is the derivative dy/dx of y=2x+10?","what is 302 * 405?","How many faces does a dodecahedron have?", "What is the number of the meaning of life?", "what is the percent chance that I grab a blue ball if there are 130 blue balls and 200 balls in total? (do not include % sign)", "What is the integral of y=x if the bounds are 0 and 1?", "What percent of the area under a normal curve is within one standard deviation of the mean? (do not add the % sign)", "What is the volume of a sphere with radius 10 rounded to the nearest whole number", "What is the surface area of a cude with a side length of 5?", "What is the value of pi rounded to the nearest whole number?", "What is the value of phi rounded to the nearest whole number?", "What is -10i*10i?","How many people must be in a room for there to be a 50% chance that two people share a birthday?", "What is the smallest prime number?", "What is the distance between (0,0) and (3,4)?", "What is the distance between (0,5) and (0,12)?", "What is the value of the derivative of y=e^x when x equals 2 (rounded to the nearest whole number)?", "What is the square root of 2 rounded to the nearest whole number?","What number did the Romans not have?"};

    public int[] ans = {12,122310,12,42,65,1,68,4189,150,3,2,100,23,2,5,7,7,1,0};
    
    int[] parr = {0, 1, 2, 3, 4, 5, 6, 7, 9, 10,11 , 12, 13, 14, 15 , 16 ,17 };
		
		Random rand = new Random();
		
		void mR(){
		  while (i < parr.length) {
			  int randomIndexToSwap = rand.nextInt(parr.length);
			  int temp = parr[randomIndexToSwap];
			  parr[randomIndexToSwap] = parr[i];
			  parr[i] = temp;
			  i++;
     }
		}
		

    void mathPlay(){
      while(q > 0){
        int b,c;
        String a;
        mR();

        a = arr[parr[p]];
        System.out.println(a);
        b = ans[parr[p]];
        //System.out.println(b);
        c = sc.nextInt();
        if(b == c){
        System.out.println("correct");
        s ++;
        }else{
          System.out.println("incorrect");
      }
          System.out.println("score: " + s);
          //x = 1;
          q = q-1;
          System.out.println("Questions left: " + q);
          System.out.println("");
          p++;
      }
    }
}