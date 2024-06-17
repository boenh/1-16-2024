package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Runner implements KeyListener{

	private Block currBlock;
	private JFrame mainFrame;
	private MainScreen mainScreen;
	private Tile[][] board;
	private boolean end;
	private int level;
	private int waitTime;
	private boolean touchDown;
	
	public Runner() throws InterruptedException {
		mainFrame = new JFrame();
		mainFrame.setSize(350,650);
		mainScreen = new MainScreen();
		mainFrame.add(mainScreen);
		waitTime = 1000;
		end = false;
		board = new Tile[20][10];
		touchDown = true;
		
		oneRound();
//		while (!end) {
//			if (touchDown == true) {
//				oneRound();
//				System.out.println("loop running");
//				
//			}
//		}
		
		
	}
	
	public void oneRound() throws InterruptedException {
		touchDown = false;
		
		
		
		
		
		String[] blockTypes = {"straight", "t", "square", "s", "sm", "l", "lm"};
		int blockInt = (int)(Math.random()*7)+0;
		
		Block testBlock = new Block(blockTypes[blockInt]);
		
		currBlock = testBlock;
		
		Tile[] blockTiles = currBlock.getTiles();
		
		for (int i = 0; i< 4; i ++) {
			Tile tempTile = blockTiles[i];
			int c = tempTile.getC();
			int r = tempTile.getR();
			if (c >= 0 && c < 10 && r >= 0 && r < 20) {
				board[r][c] = tempTile;
			}
		}
		
	
		
		
		//mainScreen.update(board);
//			while(!atBottom()) {
//				currBlock.down();
//				mainScreen.update(board);
//			}
		
		//sleepTester();

		mainFrame.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				//System.out.println(mainScreen.getGraphics());
				
				//System.out.println(mainScreen.getGraphics());
				//System.out.println(e.getKeyCode());
				//down = 40
				//right = 39
				//up = 38
				//left =37 
				int code = e.getKeyCode();

				
				if (e.getKeyCode() == 40&&!atBottom()) {
					currBlock.down();
				}
				if (e.getKeyCode() == 39&& !atRight()) {
					currBlock.right();
				}
				if (e.getKeyCode() == 37&&!atLeft()) {
					currBlock.left();
				}
				if (e.getKeyCode() == 38&&canTurn()) {
					currBlock.turn();
				}
				if (e.getKeyCode() == 32) {
					while(!atBottom()) {
						currBlock.down();
						for (int i = 0; i < 20; i ++) {
							for (int j = 0; j < 10; j ++) {
								if (board[i][j] != null && board[i][j].getBlock().equals(currBlock)) {
									board[i][j] = null;
								}
							}
						}
						Tile[] blockTiles = currBlock.getTiles();
						
						for (int i = 0; i< 4; i ++) {
							Tile tempTile = blockTiles[i];
							int c = tempTile.getC();
							int r = tempTile.getR();
							if (c >= 0 && c < 10 && r >= 0 && r < 20) {
								board[r][c] = tempTile;
							}
						}
						mainScreen.update(board);
					}
				}
				
				if (code ==40 ||code == 39 || code == 38 || code == 37 || code == 32) {
					for (int i = 0; i < 20; i ++) {
						for (int j = 0; j < 10; j ++) {
							if (board[i][j] != null && board[i][j].getBlock().equals(currBlock)) {
								board[i][j] = null;
							}
						}
					}
					Tile[] blockTiles = currBlock.getTiles();
					
					for (int i = 0; i< 4; i ++) {
						Tile tempTile = blockTiles[i];
						int c = tempTile.getC();
						int r = tempTile.getR();
						if (c >= 0 && c < 10 && r >= 0 && r < 20) {
							board[r][c] = tempTile;
						}
					}
					
//					for (int i = 0; i < 20; i ++) {
//						for (int j = 0; j < 10; j ++) {
//							if (board[i][j] == null) {
//								System.out.print(" ,");
//							}
//							else {
//								System.out.print("x,");
//							}
//						}
//						System.out.println();
//					}
//					System.out.println("/////////////////////////////////////////////");
					mainScreen.update(board);
					
				}
				
				
			}

			
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//mainScreen.update(board);
		mainFrame.addMouseListener((MouseListener) new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				Thread t = new Thread(new Runnable() {
				    public void run() {
				    	
				    	
				    	while(!atBottom()) {
				    		
				    		
							mainScreen.update(board);
							currBlock.down();
							for (int i = 0; i < 20; i ++) {
								for (int j = 0; j < 10; j ++) {
									if (board[i][j] != null && board[i][j].getBlock().equals(currBlock)) {
										board[i][j] = null;
									}
								}
							}
							Tile[] blockTiles = currBlock.getTiles();
							
							for (int i = 0; i< 4; i ++) {
								Tile tempTile = blockTiles[i];
								int c = tempTile.getC();
								int r = tempTile.getR();
								if (c >= 0 && c < 10 && r >= 0 && r < 20) {
									board[r][c] = tempTile;
								}
							}
							
							
							
							for (int i = 0; i < 20; i ++) {
							for (int j = 0; j < 10; j ++) {
								if (board[i][j] == null) {
									System.out.print(" ,");
								}
								else {
									System.out.print("x,");
								}
							}
							System.out.println();
						}
						System.out.println("/////////////////////////////////////////////");
							
							
							
							mainScreen.update(board);
							try {
								pause();
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
				    	
				    	try {
				    		currBlock = null;
							oneRound();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	
				    	touchDown = true;
				    	System.out.println(touchDown);
				    	
				    }
				});
				t.start();
				
				
			}
		});
		
		//}
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	
	private void sleepTester() throws InterruptedException {
		for (int i = 0; i < 10; i ++) {
			System.out.println(i);
			Thread.sleep(1000);
		}
	}
	private void pause() throws InterruptedException {
		Thread.sleep(waitTime);
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Runner();
		// TODO Auto-generated method stub
//		for (int i = 0; i < 5; i ++) {
//			System.out.println(i);
//			Thread.sleep(1000);
//		}
		
		
		

		
//		for (int i = 0; i < 20; i ++) {
//			for (int j = 0; j < 10; j ++) {
//				if (testBoard[i][j] == null) {
//					System.out.print(" ,");
//				}
//				else {
//					System.out.print("x,");
//				}
//			}
//			System.out.println();
//		}

		
	}
	
	private boolean atBottom() {
		
		Block temp = currBlock;
		temp.down();
		
		Tile[] tiles2 = temp.getTiles();
		
		for (int i = 0; i < 4; i ++) {
			if (tiles2[i].getR() < 20  && board[tiles2[i].getR()][tiles2[i].getC()] != null&&!board[tiles2[i].getR()][tiles2[i].getC()].getBlock().equals(currBlock)) {
				
				return true;
			}
		}
		temp.up();
		int bottom = 0;
		Tile[] tiles = currBlock.getTiles();
		for (int i = 0; i < 4; i ++) {
			if (tiles[i].getR()>bottom) {
				bottom = tiles[i].getR();
			}
		}
		
		return bottom >= 19;
	}
	
	private boolean atRight() {
		//System.out.println("run");
		
		
		Block temp = currBlock;
		temp.right();
		
		Tile[] tiles2 = temp.getTiles();
		
		for (int i = 0; i < 4; i ++) {
			if (tiles2[i].getC() < 10  && board[tiles2[i].getR()][tiles2[i].getC()] != null && !board[tiles2[i].getR()][tiles2[i].getC()].getBlock().equals(currBlock)) {
				//System.out.println("stuff");
				return true;
				
			}
		}
		temp.left();
		int right = 0;
		Tile[] tiles = currBlock.getTiles();
		for (int i = 0; i < 4; i ++) {
			if (tiles[i].getC()>right) {
				right = tiles[i].getC();
			}
		}
		
		return right >=9 ;
	}
	
	private boolean atLeft() {
		Block temp = currBlock;
		temp.left();
		
		Tile[] tiles2 = temp.getTiles();
		
		for (int i = 0; i < 4; i ++) {
			if (tiles2[i].getC() >= 0 && board[tiles2[i].getR()][tiles2[i].getC()] != null&& !board[tiles2[i].getR()][tiles2[i].getC()].getBlock().equals(currBlock)) {
				return true;
			}
		}
		temp.right();
		int left = 9;
		Tile[] tiles = currBlock.getTiles();
		for (int i = 0; i < 4; i ++) {
			if (tiles[i].getC()<left) {
				left = tiles[i].getC();
			}
		}
		return left <= 0;
	}
	
	private boolean canTurn() {
		Block temp = currBlock;
		temp.turn();
		
		Tile[] tiles2 = temp.getTiles();
		
		
		
		for (int i = 0; i < 4; i ++) {
			
			if (tiles2[i].getR()>=0) {
				if (tiles2[i].getR()>19 || tiles2[i].getC()>9 || tiles2[i].getC()<0) {
					temp.counterTurn();
					System.out.println("run");
					return false;
				}
				if (board[tiles2[i].getR()][tiles2[i].getC()] != null && !board[tiles2[i].getR()][tiles2[i].getC()].getBlock().equals(currBlock)) {
					temp.counterTurn();
					return false;
			}

			}
		}
		temp.counterTurn();
		return true;
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
