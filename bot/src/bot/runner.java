package bot;


import java.util.ArrayList;
import java.util.Collections; 
public class runner{

  public static int nextMove(int[][] b){
      int max = Integer.MIN_VALUE;
      int maxMove = 0;
      boolean[] list = valid(b);
      ArrayList<Integer> list2 = new ArrayList<Integer>();
      ArrayList<Integer[]> scores= new ArrayList<Integer[]>();
      
      for (int i = 0 ; i < list.length; i ++) {
    	  if (list[i] == true) {
    		  list2.add(i);
    	  }
      }
      for (int j : list2) {
    	  int[][] newB = move(b, j);
    	  ArrayList<Integer> list3 = new ArrayList<Integer>();
    	  int score = 0;
    	  for (int r = 0; r < b.length; r ++) {
    		  for (int c = 0; c < b.length; c ++) {
    			  if (newB[r][c] != 0) {
    				  list3.add(newB[r][c]);
    			  }
    		  }
    	  }
    	  Collections.sort(list3);
    	  if (list3.get(list3.size()-1) == newB[0][0] || list3.get(list3.size()-1) == newB[0][newB.length-1] || list3.get(list3.size()-1) == newB[newB.length-1][0] || list3.get(list3.size()-1) == newB[newB.length-1][newB.length-1]) {
    		  score += 1000;
    	  }
    	  score -= list3.size()*100;
    	  int numSameHor = 0;
    	  int numSameVer = 0;
    	  for (int i = 0; i < newB.length; i ++) {
    		  for (int p = 0; p <3; p ++) {
	    		  for (int jj = 0; jj <newB[0].length; jj ++) {
	    			  if (newB[i][jj]==0) {
	    				  for (int n = jj; n < newB[0].length-1; n ++) {
							  newB[i][n]=newB[i][n+1];
						  }
	    				  newB[i][b[0].length-1] = 0;
	    			  }
	    		  }
    		  }
    		  for (int jj = 0; jj <newB[0].length-1; jj ++) {
    			  if (newB[i][jj] != 0) {
    				  if (newB[i][jj] == newB[i][jj+1]) {
    					  numSameHor ++;
    				  }
    			  }
    		  }
    	  }
    	  for (int i = 0; i < b.length; i ++) {
    		  for (int p = 0; p < 3; p ++) {
				  for (int jj = 0; jj <b[0].length; jj ++) {
					  if (newB[jj][i]==0) {
						  for (int n = jj; n < b[0].length-1; n ++) {
							  newB[n][i]=newB[n+1][i];
						  }
						  newB[b[0].length-1][i] = 0;
						  
					  }
				  }
    		  }
    		  for (int jj = 0; jj <newB[0].length-1; jj ++) {
    			  if (newB[jj][i] != 0) {
    				  if (newB[jj][i] == newB[jj+1][i]) {
    					  numSameVer ++;
    				  }
    			  }
    		  }  
    	  }
    	  if (numSameVer >= numSameHor) {
    		  score += numSameVer * 100;
    	  }
    	  else {
    		  score += numSameHor * 100;
    	  }
    	  for (int n : list3) {
    		  score += n;
    	  }
    	  Integer[] temp = new Integer[2];
    	  temp[0] = score;
    	  temp[1] = j;
    	  scores.add(temp);
      }
      
      for (int x = 0; x < scores.size(); x ++) {
    	  if (scores.get(x)[0] > max) {
    		  max = scores.get(x)[0];
    		  maxMove = scores.get(x)[1];
    	  }
      }
      
      
      return maxMove;
  }
  
  public static int evaluate(int[][] newB) {
	  int score = 0;
	  
  }
  
  public static void main(String Arg[]) {
	  int[][] board = {{2, 0, 2, 8},
			  		  {2, 0, 0, 0},
			  		  {2, 0, 0, 0},
			  		  {2, 0, 2, 16}};
//	  boolean[] posMove = valid(board);
//	  for (int i = 0; i < posMove.length; i ++) {
//		  System.out.println(posMove[i]);
//	  }
	  int next = nextMove(board);
	  int[][] board2 = move(board, next);
	  for (int i = 0; i < board.length; i ++) {
		  for (int j = 0; j < board[0].length; j ++) {
			  System.out.print(board2[i][j] + " ");
		  }
		  System.out.println();
	  }
	  System.out.println(next);


	  
	  
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
	    		  for (int j = 0; j <b[0].length; j ++) {
	    			  if (b2[i][j]==0) {
	    				  for (int n = j; n < b[0].length-1; n ++) {
							  b2[i][n]=b2[i][n+1];
						  }
	    				  b2[i][b[0].length-1] = 0;
	    				  
	    			  }
	    		  }
    		  }
    		  

    	  }
    	  for (int ii = 0; ii < b.length; ii ++) {
    		  for (int j = 0; j <b[0].length-1; j ++) {
    			  if (b2[ii][j+1]==b2[ii][j]) {
    				  b2[ii][j] += b2[ii][j+1];
    				  if (j != b[0].length-1) {
    					  for (int n = j+1; n < b[0].length-1; n ++) {
    						  b2[ii][n]=b2[ii][n+1];
    					  }
    					  b2[ii][b[0].length-1]= 0; 
    				  }
    				  else{
    					  b2[ii][j] = 0;
    				  }
    			  }
    		  }
    	  }
      }
      if (move == 1) {
    	  for (int i = 0; i < b.length; i ++) {
    		  for (int p = 0; p < 3; p ++) {
	    		  for (int j = b[0].length-1 ; j >0 ; j --) {
	    			  if (b2[i][j]==0) {
	    				  for (int n = j; n > 0; n --) {
							  b2[i][n]=b2[i][n-1];
						  }
	    				  b2[i][0] = 0;
	    			  }
	    		  }
    		  }
    	  }
    	  for (int ii = 0; ii < b.length; ii ++) {
    		  for (int j = b[0].length-1 ; j >1 ; j --) {

    			  if (b2[ii][j-1]==b2[ii][j]) {
    				  b2[ii][j] *=2;
    				  if (j != 0) {
    					  for (int n = j-1; n >  0; n --) {
    						  b2[ii][n]=b2[ii][n-1];
    					  }
    					  b2[ii][0]= 0; 
    				  }
    				  else{
    					  b2[ii][j] = 0;
    				  }
    			  }
    			  
    		  }
    	  }
      }
      if (move == 2) {
    	  
    	  for (int i = 0; i < b.length; i ++) {
    		  for (int p = 0; p < 3; p ++) {
				  for (int j = 0; j <b[0].length; j ++) {
					  if (b2[j][i]==0) {
						  for (int n = j; n < b[0].length-1; n ++) {
							  b2[n][i]=b2[n+1][i];
						  }
						  b2[b[0].length-1][i] = 0;
						  
					  }
				  }
    		  }
    	  
    	  }
    	  for (int ii = 0; ii < b.length; ii ++) {
    		  for (int j = 0; j <b[0].length-1; j ++) {
    			  if (b2[j+1][ii]==b2[j][ii]) {
    				  b2[j][ii] += b2[j+1][ii];
    				  if (j != b[0].length-1) {
    					  for (int n = j+1; n < b[0].length-1; n ++) {
    						  b2[n][ii]=b2[n+1][ii];
    					  }
    					  b2[b[0].length-1][ii]= 0; 
    				  }
    				  else{
    					  b2[j][ii] = 0;
    				  }
    			  }
    		  }
    	  }
      }
      if (move == 3) {
    	  for (int i = 0; i < b.length; i ++) {
    		  for (int p = 0; p < 3; p ++) {
	    		  for (int j = b[0].length-1 ; j >0 ; j --) {
	    			  if (b2[j][i]==0) {
	    				  for (int n = j; n > 0; n --) {
							  b2[n][i]=b2[n-1][i];
						  }
	    				  b2[0][i] = 0;
	    			  }
	    		  }
    		  }
    	  }
    	  for (int ii = 0; ii < b.length; ii ++) {
    		  for (int j = b[0].length-1 ; j >1 ; j --) {

    			  if (b2[j-1][ii]==b2[j][ii]) {
    				  b2[j][ii] *=2;
    				  if (j != 0) {
    					  for (int n = j-1; n >  0; n --) {
    						  b2[n][ii]=b2[n-1][ii];
    					  }
    					  b2[0][ii]= 0; 
    				  }
    				  else{
    					  b2[j][ii] = 0;
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
