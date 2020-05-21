import java.util.*;

public class solverOptimal {
   public static ArrayList<ArrayList<ArrayList<Integer>>> solveGrid(ArrayList<ArrayList<ArrayList<Integer>>> x) {
      int TotalNumOfChanges = 0;
      
      boolean changeBool = true;
      
      while(changeBool) { 
         int basicChanges = 0;
         int expertChanges = 0;
//new variable
         int holdBasic = 0;
//begin new while loop        
         while(true) { 
//new operation
            holdBasic = basicChanges; 
//end new operation
            for(int i=0; i<9; i++) {
               for(int j=0; j<9; j++) {
                  if(x.get(i).get(j).size() == 1) {
                     int currentVal = x.get(i).get(j).get(0);
                     
                     //Solving beginner rows and columns
                     for(int k=0; k<9; k++) {
                        if(x.get(i).get(k).contains(currentVal)) {
                           x.get(i).get(k).remove(Integer.valueOf(currentVal));
                           basicChanges++;
                        }
                        if(x.get(k).get(j).contains(currentVal)) {
                           x.get(k).get(j).remove(Integer.valueOf(currentVal));
                           basicChanges++;
                        }
                     }
                     
                     //Beginning sector solving
                     int currI = i;
                     int currJ = 0;
                     
                     for(int r=0; r<3; r++) {
                        currJ = j;
                        for(int s=0; s<3; s++) {
                           if(x.get(currI + r).get(currJ + s).contains(currentVal)) {
                              x.get(currI + r).get(currJ + s).remove(Integer.valueOf(currentVal));
                              basicChanges++;
                           }
                           if((currJ + s) % 3 == 2) {
                              currJ -= 3;
                           }
                        }
                        if((currI + r) % 3 == 2) {
                           currI -= 3;
                        }
                     }
   
                     x.get(i).get(j).add(currentVal);
                     basicChanges--;
                  }
               }
            }
//begin new code
            if(holdBasic == basicChanges) {
               break;
            }
//end new code
         }
//end new while loop
         int runCount = 0;
         
         //final algorithm
         for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
            int listSize = x.get(i).get(j).size();
               if(listSize > 1) {
                  for(int k=0; k<listSize; k++) {
                     
                     //column purging
                     int matchCount = 0;
                     int currInt = x.get(i).get(j).get(k);
                     
                     int currM = 0;
                     int currN = 0;
                     
                     if(j % 3 == 2) {
                        currM = j - 2;
                     } else {
                        currM = j + 1;
                     }
                     
                     outer2:  for(int m=0; m<2; m++) {
                        currN = i;
                        for(int n=0; n<3; n++) {
                           if(x.get(currN + n).get(currM + m).contains(currInt)) {
                              matchCount++;
                              break outer2;
                           }
                           if((currN + n) % 3 == 2) {
                              currN -= 3;
                           }
                        }
                        if((currM + m) % 3 == 2) {
                           currM -= 3;
                        }
                     }
                     if(matchCount == 0) {
                        int columnBlock = i;
                        for(int p=0; p<3; p++) {
                           if(columnBlock % 3 != 2) {
                              columnBlock++;
                           } else {
                              break;
                           }
                        }
                        columnBlock++;
                        for(int q=0; q<6; q++) {
                           if((columnBlock + q) == 9) {
                              columnBlock -= 9;
                           }
                           if(x.get(columnBlock + q).get(j).size() > 1) {
                              if(x.get(columnBlock + q).get(j).contains(currInt)) {
                                 x.get(columnBlock + q).get(j).remove(Integer.valueOf(currInt));
                                 expertChanges++;
                              }
                           }
                        }
                     }
                     
                     //row purging
                     matchCount = 0;                    
                     currM = 0;
                     currN = 0;
                     
                     if(i % 3 == 2) {
                        currM = i - 2;
                     } else {
                        currM = i + 1;
                     }
                     
                     outer2:  for(int m=0; m<2; m++) {
                        currN = j;
                        for(int n=0; n<3; n++) {
                           if(x.get(currM + m).get(currN + n).contains(currInt)) {
                              matchCount++;
                              break outer2;
                           }
                           if((currN + n) % 3 == 2) {
                              currN -= 3;
                           }
                        }
                        if((currM + m) % 3 == 2) {
                           currM -= 3;
                        }
                     }
                     if(matchCount == 0) {
                        int rowBlock = j;
                        for(int p=0; p<3; p++) {
                           if(rowBlock % 3 != 2) {
                              rowBlock++;
                           } else {
                              break;
                           }
                        }
                        rowBlock++;
                        for(int q=0; q<6; q++) {
                           if((rowBlock + q) == 9) {
                              rowBlock -= 9;
                           }
                           if(x.get(i).get(rowBlock + q).size() > 1) {
                              if(x.get(i).get(rowBlock + q).contains(currInt)) {
                                 x.get(i).get(rowBlock + q).remove(Integer.valueOf(currInt));
                                 expertChanges++;
                              }
                           }
                        }
                     }
                     
                     //beginning sector completion
                     matchCount = 0;
                     currM = i;
                     currN = 0;
                     outer:for(int m=0; m<3; m++) {
                        currN = j;
                        
                        for(int n=0; n<3; n++) {
                           if((currN + n) == j) {
                              if((currM + m) == i) {
                                 if((currN + n) % 3 == 2) {
                                    currN -= 3;
                                 }
                                 continue;
                              }
                           }

                           if(x.get(currM + m).get(currN + n).contains(currInt)) {
                              matchCount++;
                              break outer;
                           }
                           if((currN + n) % 3 == 2) {
                              currN -= 3;
                           }
                        }
                        if((currM + m) % 3 == 2) {
                           currM -= 3;
                        }
                     }
                     if(matchCount == 0) {
                        x.get(i).get(j).clear();
                        x.get(i).get(j).add(currInt);
                        expertChanges++;
                        break;
                     }
                     
                  }
               }
            }
         }

         TotalNumOfChanges += basicChanges;
         TotalNumOfChanges += expertChanges;
                
         if((basicChanges + expertChanges) <= 0) {
            changeBool = false;
         }
      }
      return x;
   }
}