import java.util.*;

public class checkerOptimal {
   public static boolean solveCheck(ArrayList<ArrayList<ArrayList<Integer>>> x) {
      boolean solvedBool = true;
         
      for(int i=0; i<9; i++) {
         for(int j=0; j<9; j++) {
            if(x.get(i).get(j).size() != 1) {
               solvedBool = false;
            }
         }
      }
      
      return solvedBool;
   }
}