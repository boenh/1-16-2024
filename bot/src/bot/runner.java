package bot;


import java.util.ArrayList; 
public class runner{

  public static int nextMove(int[][] b){
      int max = 0;
      int maxMove = 0;
      int numTiles = 0;
      
      
      int[][] b2 = new int[b.length][b[0].length];
      boolean[][] b3 = new boolean[b.length][b[0].length];
      for (int i = 0; i < b.length; i ++) {
    	  for (int j = 0; j < b[0].length; j ++) {
    		  b2[i][j] = b[i][j];
    		  if (b[i][j] != 0) {
    			  b3[i][j] = true;
    		  }
    	  }
      }
      
      
      boolean[] moves = {true, true, true, true};
      for (int n = 0; n < b.length; n ++) {
    	  
      }
      
      
      
      ArrayList<Integer> list = new ArrayList<Integer>();
      ArrayList<Integer> list2 = new ArrayList<Integer>();
      ArrayList<Integer> list3 = new ArrayList<Integer>();
      //first row - r position
      //second row - c position
      //third row - value
      
      for (int r = 0; r < b.length; r ++){
          for (int c = 0; c < b[0].length; c ++){
              if (b[r][c] !=0){
                  list.add(r);
                  list2.add(c);
                  list3.add(b[r][c]);
              }
          }
      }
      
      
       return -1;
  }

}
