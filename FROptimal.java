import java.util.*;
import java.io.*;

public class FROptimal {
   public static ArrayList<ArrayList<ArrayList<Integer>>> readFile(ArrayList<ArrayList<ArrayList<Integer>>> x) throws java.io.IOException {
      
      Scanner TxtFile = new Scanner(new File("PrefilledHardest.txt"));
        
      for(int i=0; i<9; i++) {
         x.add(new ArrayList<ArrayList<Integer>>()); 
         for(int j=0; j<9; j++) {
            if(TxtFile.hasNextInt()) {
               int currInt = TxtFile.nextInt();
               
               if(currInt == 0) {
                  x.get(i).add(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)));
               } else {
                  x.get(i).add(new ArrayList<Integer>(Arrays.asList(currInt)));
               }
            } else {
               TxtFile.next();
            }
         }
      }
      
      TxtFile.close();
      
      return x;
   }
}