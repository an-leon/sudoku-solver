import java.util.*;

public class printerOptimal {
   public static int printGrid(ArrayList<ArrayList<ArrayList<Integer>>> x) {
      System.out.printf("\n%17s", "X\n");
      System.out.print("    1 2 3    4 5 6    7 8 9\n");
      
      for(int i=0; i<9; i++) {
         String firstChar = " ";
         String carriageRet = "\n";
         
         if(i == 2 || i == 5) {
            carriageRet = "\n\n";
         } else if(i == 4) {
            firstChar = "Y";
         }
         
         System.out.print(firstChar + " " + (i + 1));
         for(int j=0; j<9; j++) {   
            int outPut = 0;
         
            if(x.get(i).get(j).size() == 1) {
               outPut = x.get(i).get(j).get(0);
            }
            
            int jMod3 = j % 3;
            switch(jMod3) {
               case 0: System.out.printf("[%d", outPut);
               break;
               case 1: System.out.printf(" %d ", outPut);
               break;
               default: System.out.printf("%d]  ", outPut);
            }
         }
         System.out.print(carriageRet);
      }
      System.out.print("\n");
      
      return 0;
   }
}