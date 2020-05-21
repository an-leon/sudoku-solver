import java.util.*;

public class Main {
   public static void main(String[] args) throws java.io.IOException {	
      Scanner keyboardInput = new Scanner(System.in);
      
      GridPrinter gridPrinter = new GridPrinter();
      ManualEntry manFill = new ManualEntry();
      Solver gridSolver = new Solver();
      FileEntry myFileReader = new FileEntry();
      SolvedChecker solveChecker = new SolvedChecker();
      
      ArrayList<ArrayList<ArrayList<Integer>>> x 
         = new ArrayList<ArrayList<ArrayList<Integer>>>();
      
      ArrayList<ArrayList<ArrayList<Integer>>> y
         = new ArrayList<ArrayList<ArrayList<Integer>>>(); 
         
      ArrayList<ArrayList<ArrayList<Integer>>> z
         = new ArrayList<ArrayList<ArrayList<Integer>>>(); 
         
      ArrayList<ArrayList<ArrayList<Integer>>> originalGrid
         = new ArrayList<ArrayList<ArrayList<Integer>>>(); 
      
      System.out.println("How would you like to fill the grid?\n--Enter 1 for auto fill--\n--Enter 2 for manual fill--");
			int choiceVal = keyboardInput.nextInt();
      
      if(choiceVal == 1) {
         x = myFileReader.readFile(x);
      } else {
         x = manFill.manFill(x);
      }
      
      gridPrinter.printGrid(x);
      
      System.out.print("Does the grid look correct?\n--Enter Y for yes--\n--Enter N for no--\n");
   	   char choiceChar = keyboardInput.next().charAt(0);
   
      long startTime = System.nanoTime();

      boolean isSolved = false;
      
      for(int m=0; m<9; m++) {
         y.add(new ArrayList<ArrayList<Integer>>());
         z.add(new ArrayList<ArrayList<Integer>>()); 
         for(int n=0; n<9; n++) {
            y.get(m).add(new ArrayList<Integer>(0));
            z.get(m).add(new ArrayList<Integer>(0));
         }
      }
      
      if(choiceChar == 'Y' || choiceChar == 'y') {
         x = gridSolver.solveGrid(x);
   	   isSolved = solveChecker.solveCheck(x);
         if(isSolved == true) {
         System.exit(0);
         }
         
         int[][][] copyArray = new int[9][9][9];
         
         outerFor: for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
               for(int k=0; k<x.get(i).get(j).size(); k++) {
                  //begin y's array swap
                  for(int m=0; m<9; m++) {
                     for(int n=0; n<9; n++) {
                        y.get(m).get(n).clear();
                        int currSize = x.get(m).get(n).size();
                        for(int p=0; p<currSize; p++) {
                           copyArray[m][n][p] = x.get(m).get(n).get(p);
                           y.get(m).get(n).add(copyArray[m][n][p]);
                        }  
                     }
                  }
                  //end y's array swap
                  
                  
                  //begin new algorithm
                  int currInt = y.get(i).get(j).get(k);
                  y.get(i).get(j).clear();
                  y.get(i).get(j).add(currInt);
                  
                  for(int r=i; r<9; r++) {
                     for(int s=j+1; s<9; s++) {
                        for(int t=0; t<y.get(r).get(s).size(); t++) {
                           //begin z's array swap
                           for(int m=0; m<9; m++) {
                              for(int n=0; n<9; n++) {
                                 z.get(m).get(n).clear();
                                 int currSize = y.get(m).get(n).size();
                                 for(int p=0; p<currSize; p++) {
                                    copyArray[m][n][p] = y.get(m).get(n).get(p);
                                    z.get(m).get(n).add(copyArray[m][n][p]);
                                 }  
                              }
                           }
                           //end z's array swap
                           
                           currInt = z.get(r).get(s).get(t);
                           z.get(r).get(s).clear();
                           z.get(r).get(s).add(currInt);
                           
                           z = gridSolver.solveGrid(z);
               	         isSolved = solveChecker.solveCheck(z);
                           
                           if(isSolved == true) {
                              break outerFor;
                           }
                        }
                     }
                  }
               }
            }
         }
         
         long endTime = System.nanoTime();
         double totalTimeMS = ((double)endTime - startTime) / 1000000;
         System.out.printf("Solving Time: %.3f milliseconds\n", totalTimeMS);
         
   		gridPrinter.printGrid(z);
      }		
	}
}