import java.util.Scanner;
//import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

class Science{
    Scanner sc = new Scanner(System.in);
    int s;
    int q = 5;
    int p = 0;
    int i = 0;

    public String[] arr = {"What is the atomic weight of Hydrogen?", "How many moons does Mars have?", "How many chromosomes does a human have?", "What is the chemical formula for carbon dioxide?", "What is the gestation period of an elephant?", "Which planet has the moon Io?", "What is the equation for net force on an object?", "When can you use the kinematic equations?", "What did Copernicus discover?", "How many new species are found each year?", "What did the Manhattan Project create?", "Which hormone does the pancreas produce?"};

    public String[] mcq = {"1. 1; 2. 2; 3. 3; 4. 4","1. 1; 2. 2; 3. 0; 4.7", "1. 23; 2. 65; 3. 46; 4. 24", "1. H20; 2. S202; 3. C6H12O2; 4. CO2", "1. 22 months; 2. 1 year; 3. 9 months; 4. 15 months", "1. Mars; 2. Jupiter; 3. Venus; 4. Neptune", "1. F=2mv; 2. F=10ax; 3. F=ma; 4. F=0.5mv^2", "1. always; 2. when velocity is constant; 3. when you're good at algebra; 4. when acceleration is constant", "1. the Heliocentric model; 2. General Relativity; 3. the Earth is round; 4. how to make girls like you", "1. 2000; 2. 18000; 3. 400; 4. 20", "1. a steam engine; 2. the first computer; 3. nuclear bombs; 4. the apollo space craft", "1. white blood cells; 2. adrenaline; 3. dopamine; 4. insulin"};

    public int[] ans = {1,2,3,4,1,2,3,4,1,2,3,4};
    
    int[] parr = {0, 1, 2, 3, 4, 5, 6, 7, 9, 10,11};
		
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
		

    void sciPlay(){
      while(q > 0){
        int b,c;
        String a,d;
        mR();

        a = arr[parr[p]];
        System.out.println(a);
        d = mcq[parr[p]];
        System.out.println(d);
        b = ans[parr[p]];
        //4System.out.println(b);
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