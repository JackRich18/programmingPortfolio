import java.util.Scanner;
//import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

class History{
    Scanner sc = new Scanner(System.in);
    int s;
    int q = 5;
    int p = 0;
    int i = 0;

    public String[] arr = {"Napoleon was a...", "When did the Eastern Roman Empire Fall?", "What was the first Capital of the USA?", "What alliance did the West form after WWII?", "Who is the man of blood and iron?", "Where was Alexander the Great born?", "Where was Buddhism created?", "When was the Battle of Yarmuk?", "What religion did the Achaemenid Persians practice?", "Who is the famous student of Socrates?","Who won the Battle of Canae?", "Where was the Prophet Muhammad born?", "What was the civilization that ruled the Andes Mountains?", "What Capital was once a lake?", "What was the Capital of the Inca?"};

    public String[] mcq = {"1. A French Emperor; 2. A British monarch; 3. A German general; 4. A Dutch explorer", "1. 412 AD; 2. 630 AD; 3. 37 BC; 4. 1453 AD", "1. Washington D.C.; 2. Philadelphia; 3. New York City; 4. Boston", "1. the UN; 2. NATO; 3. The Warsaw Pact; 4. NAFTA", "1. Bismarck; 2. Napoleon; 3. Hitler; 4. Eisenhower", "1. Athens; 2. Persia; 3. Macedonia; 4. Anatolia", "1. China; 2. India; 3. Anatolia; 4. Mongolia", "1. 640 BC; 2. 1066 AD; 3. 1943 AD; 4. 636 AD", "1. Zoroastrianism; 2. Judaism; 3. Christianity; 4. Sikhism", "1. Aristotle; 2. Hericles; 3. Galen; 4. Plato", "1. The Romans, 2. The Persians, 3. The Carthaginians, 4. The Gauls", "1. Medina, 2. Mecca, 3. Uruk, 4. Jerusalem", "1. the Aztec; 2. the Totltec; 3. the Inca; 4. the Maya","1. Mexico City; 2. London; 3. Mumbai; 4. Berlin", "1. Tenochititlan; 2. Tulum; 3. Machu Picchu; 4. Cusco"};

    public int[] ans = {1,4,3,2,1,3,2,4,1,4,3,2,3,1,4};
    
    int[] parr = {0, 1, 2, 3, 4, 5, 6, 7, 9, 10,11 , 12, 13, 14};
		
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
		

    void histPlay(){
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