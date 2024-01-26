package bot;


import java.util.ArrayList; 
public class runner{

  public static int nextMove(int[][] b){
      int max = 0;
      int maxMove = 0;
      int numTiles = 0;
      
      
      return maxMove;
  }
  
  public static void main(String Arg[]) {
	  int[][] board = {{2, 0, 16, 2},
			  		  {0, 0, 0, 0},
			  		  {0, 0, 0, 0},
			  		  {2, 2, 16, 16}};
//	  boolean[] posMove = valid(board);
//	  for (int i = 0; i < posMove.length; i ++) {
//		  System.out.println(posMove[i]);
//	  }
	  int[][] board2 = move(board, 1);
	  for (int i = 0; i < board.length; i ++) {
		  for (int j = 0; j < board[0].length; j ++) {
			  System.out.print(board2[i][j] + " ");
		  }
		  System.out.println();
	  }
	  
	  
  }
  
  public static int[][] move(int[][] b, int move){//0<= move <=3
	  int[][] b2 = new int[b.length][b[0].length];
      
      for (int i = 0; i < b.length; i ++) {
    	  for (int j = 0; j < b[0].length; j ++) {
    		  b2[i][j] = b[i][j];
    	  }
      }
      if (move == 0) {
    	  for (int i = 0; i < b.length; i ++) {
    		  
    		  for (int p = 0; p <3; p ++) {
	    		  for (int j = 0; j <b[0].length-1; j ++) {
	    			  if (b2[i][j]==0) {
	    				  for (int n = j; n < b[0].length-1; n ++) {
							  b2[i][n]=b2[i][n+1];
						  }
	    				  b2[i][b[0].length-1] = 0;
	    				  
	    			  }
	    			  
	    			  
	    			  
	    		  }
    		  }
    		  for (int j = 0; j <b[0].length-1; j ++) {
    			  if (b2[i][j+1]==b2[i][j]) {
    				  b2[i][j] += b2[i][j+1];
    				  if (j != b[0].length-1) {
    					  for (int n = j+1; n < b[0].length-1; n ++) {
    						  b2[i][n]=b2[i][n+1];
    					  }
    					  b2[i][b[0].length-1]= 0; 
    				  }
    				  else{
    					  b2[i][j] = 0;
    				  }
    			  }
    		  }
    		  
    	  }
      }
      if (move == 1) {
    	  for (int i = 0; i < b.length; i ++) {
    		  
    		  for (int p = 0; p <3; p ++) {
	    		  for (int j = b[0].length-1 ; j >1 ; j --) {
	    			  if (b2[i][j]==0) {
	    				  for (int n = j; n > 0; n --) {
							  b2[i][n]=b2[i][n-1];
						  }
	    				  b2[i][0] = 0;
	    			  }
	    			  
	    			  
	    			  
	    		  }
    		  }
    		  
    		  for (int j = b[0].length-1 ; j >1 ; j --) {

    			  if (b2[i][j-1]==b2[i][j]) {
    				  b2[i][j] *=2;
    				  if (j != 0) {
    					  for (int n = j-1; n >  0; n --) {
    						  b2[i][n]=b2[i][n-1];
    					  }
    					  b2[i][0]= 0; 
    				  }
    				  else{
    					  b2[i][j] = 0;
    				  }
    			  }
    			  
    		  }
    	  }
      }
      return b2;

  }
  
  public static boolean[] valid(int[][] b) {
	  
      //0--> left
      //1-->right
      //2-->up
      //3-->down
      
      boolean[] moves = new boolean[4];
      
      for (int y0 = 0; y0 < b.length; y0 ++) {
    	  for (int x0 = 1; x0 < b[0].length; x0 ++) {
    		  if (b[y0][x0] != 0 && b[y0][x0-1] == 0){
    			  moves[0] = true;
    			  break;
    		  }
    		  if (b[y0][x0] != 0 && b[y0][x0] == b[y0][x0-1]) {
    			  moves[0] = true;
    			  break;
    		  }
    	  }
      }
      for (int y1 = 0; y1 < b.length; y1 ++) {
    	  for (int x1 = 0; x1 < b[0].length-1; x1 ++) {
    		  if (b[y1][x1] != 0 && b[y1][x1+1] == 0){
    			  moves[1] = true;
    			  break;
    		  }
    		  if (b[y1][x1] != 0 && b[y1][x1] == b[y1][x1+1]) {
    			  moves[1] = true;
    			  break;
    		  }
    	  }
      }
      for (int y2 = 1; y2 < b.length; y2 ++) {
    	  for (int x2 = 0; x2 < b[0].length; x2 ++) {
    		  if (b[y2][x2] != 0 && b[y2-1][x2] == 0){
    			  moves[2] = true;
    			  break;
    		  }
    		  if (b[y2][x2] != 0 && b[y2][x2] == b[y2-1][x2]) {
    			  moves[2] = true;
    			  break;
    		  }
    	  }
      }
      for (int y3 = 0; y3 < b.length-1; y3 ++) {
    	  for (int x3 = 0; x3 < b[0].length; x3 ++) {
    		  if (b[y3][x3] != 0 && b[y3+1][x3] == 0){
    			  moves[3] = true;
    			  break;
    		  }
    		  if (b[y3][x3] != 0 && b[y3][x3] == b[y3+1][x3]) {
    			  moves[3] = true;
    			  break;
    		  }
    	  }
      }
      return moves;
  }

}
