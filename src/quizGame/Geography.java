import java.util.Scanner;
//import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

class Geography{
    Scanner sc = new Scanner(System.in);
    int s;
    int q = 5;
    int p = 0;
    int i = 0;

    public String[] arr = {"What is Little Rock the capital of?", "What is the largest city in the world?", "Where is the longest river in the world", "Where is Tonga located?", "What is the happiest country", "What is the richest country according to GDP per capita?", "What smallest country?", "Which country has the highest average altitude"};

    public String[] mcq = {"1. Arkansas; 2. Virginia; 3. Florida; 4. Nigeria","1. Shanghai; 2. Tokyo; 3. Delhi; 4. Paris","1. The USA; 2. India; 3. Brazil; 4. Egypt","1. South America; 2. Melanesia; 3. North Africa; 4. Polynesia","1. Finland; 2. USA; 3. Germany; 4. UK","1. Germany; 2. Luxembourg; 3. Switzerland; 4. Tonga","1. Micronesia; 2. Luxembourg; 3. Lesotho; 4. Vatican City","1. Nepal; 2. Lesotho; 3. Tajikstan; 4. Armenia"};

    public int[] ans = {1,2,3,4,1,2};
    
    int[] parr = {0, 1, 2, 3, 4, 5, 6, 7};
		
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
		

    void geoPlay(){
      while(q > 0){
        int b,c;
        String a,d;
        mR();

        a = arr[parr[p]];
        System.out.println(a);
        d = mcq[parr[p]];
        System.out.println(d);
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