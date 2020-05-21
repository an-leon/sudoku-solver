import java.util.*;

public class manualOptimal {
   public static ArrayList<ArrayList<ArrayList<Integer>>> manFill(ArrayList<ArrayList<ArrayList<Integer>>> x) {
      Scanner keyboardInput = new Scanner(System.in);
      
      for(int i=0; i<9; i++) {
         x.add(new ArrayList<ArrayList<Integer>>()); 
         for(int j=0; j<9; j++) {
            x.get(i).add(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)));
         }
      }
      
      System.out.println("How many integers would you like to pre-fill the grid with?");
		int numPreFill = keyboardInput.nextInt();

		for(int i = 0; i < numPreFill; i++) {
			System.out.println("Enter integer #" + (i + 1) + ":");
			int currentVal = keyboardInput.nextInt();

			System.out.println("Enter the X coordinate for value #" + (i + 1) + ":");
			int xCoord = keyboardInput.nextInt();

			System.out.println("Enter the Y coordinate for value #" + (i + 1) + ":");
			int yCoord = keyboardInput.nextInt();
			
			x.get(yCoord - 1).get(xCoord - 1).clear();
         x.get(yCoord - 1).get(xCoord - 1).add(currentVal);
		}
      
      return x;
   }
}