import java.util.Scanner;
//import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

class Art{
    Scanner sc = new Scanner(System.in);
    int s;
    int q = 5;
    int p = 0;
    int i = 0;

    public String[] arr = {"Who painted the Mona Lisa?", "Who is famous for their black and white photography?", "How many paintings did Van Gogh sell during his lifetime?", "What is Andy Warhol's most famous painting of", "What is the highest price a painting has gone for at auction?", "Who is the most famous British playwriter?", "Who wrote the poem 'the Waste Land'", "Who wrote Moonlight Sonata?", "Who wrote the Old man and the Sea?"};

    public String[] mcq = {"1. Da Vinci; 2. Donatello ; 3. Raphael; 4. Petrarch","1. Da Vinci; 2. Ansel Adams; 3. Andy Brown; 4. Adam Smith","1. 45; 2. 20; 3. 1; 4. 600","1. the night sky; 2. a campbells soup can; 3. fruit; 4. string beans","1. $450 million; 2. $1 billion; 3. $20 million; 4. $250 million", "1. Petrarch; 2. Shakespeare; 3. Ansel Adams; 4. Adam Smith", "1. Shakespeare; 2. T. S. Eliot;  3. Langston Hughes; 4. Maya Angelou","1. Handel; 2. Debussy; 3. Beethoven; 4. Mozart;","1. Charles Dickens; 2. Emily Dickinson; 3. Maya Angelou; 4. Ernest Hemingway"};

    public int[] ans = {1,2,3,4,1,2,3,4};
    
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
		

    void arPlay(){
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