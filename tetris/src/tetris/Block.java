package tetris;

import java.awt.Color;

public class Block {
	private Tile[] tiles;
	private String type;
	private int centerR;
	private int centerC;

	public Block(String type) {
		this.type = type;
		tiles = new Tile[4];
		if (type.equals("straight")) {
			tiles[0]=new Tile(this, 0, 3, Color.CYAN);
			tiles[1] = new Tile(this, 0, 4, Color.CYAN);
			tiles[2] = new Tile(this, 0, 5, Color.CYAN);
			tiles[3] = new Tile(this, 0, 6, Color.CYAN);
			centerR=1;
			centerC=5;
		}
		if (type.equals("square")) {
			tiles[0]=new Tile(this, 0, 4, Color.YELLOW);
			tiles[1] = new Tile(this, 0, 5, Color.YELLOW);
			tiles[2] = new Tile(this, 1, 4, Color.YELLOW);
			tiles[3] = new Tile(this, 1, 5, Color.YELLOW);
			centerR=1;
			centerC=5;
		}
		if (type.equals("t")) {
			tiles[0] = new Tile(this, 0, 4, Color.PINK);
			tiles[1] = new Tile(this, 1, 3, Color.PINK);
			tiles[2] = new Tile(this, 1, 4, Color.PINK);
			tiles[3] = new Tile(this, 1, 5, Color.PINK);
			centerR=1;
			centerC=4;
		}
		if (type.equals("l")) {
			tiles[0] = new Tile(this, 0, 5, Color.ORANGE);
			tiles[1] = new Tile(this, 1, 3, Color.ORANGE);
			tiles[2] = new Tile(this, 1, 4, Color.ORANGE);
			tiles[3] = new Tile(this, 1, 5, Color.ORANGE);
			centerR=1;
			centerC=4;
		}
		if (type.equals("lm")) {
			tiles[0] = new Tile(this, 0, 3, Color.BLUE);
			tiles[1] = new Tile(this, 1, 3, Color.BLUE);
			tiles[2] = new Tile(this, 1, 4, Color.BLUE);
			tiles[3] = new Tile(this, 1, 5, Color.BLUE);
			centerR=1;
			centerC=4;
		}
		if (type.equals("s")) {
			tiles[0] = new Tile(this, 0, 4, Color.GREEN);
			tiles[1] = new Tile(this, 0, 5, Color.GREEN);
			tiles[2] = new Tile(this, 1, 3, Color.GREEN);
			tiles[3] = new Tile(this, 1, 4, Color.GREEN);
			centerR=1;
			centerC=4;
		}
		
		
		if (type.equals("sm")) {
			tiles[0] = new Tile(this, 0, 3, Color.RED);
			tiles[1] = new Tile(this, 0, 4, Color.RED);
			tiles[2] = new Tile(this, 1, 4, Color.RED);
			tiles[3] = new Tile(this, 1, 5, Color.RED);
			centerR=1;
			centerC=4;
		}
	}
	
	public void turn() {
		for (int i = 0; i < 4; i ++) {
			int c = tiles[i].getC()-centerC;
			int r = tiles[i].getR()-centerR;
			
			tiles[i].setR(c+centerR);
			tiles[i].setC(-r+centerC);
			
			//System.out.println(tiles[i].getR() + "   " + tiles[i].getC());
		}
	}
	
	public void counterTurn() {
		for (int i = 0; i < 4; i ++) {
			int c = tiles[i].getC()-centerC;
			int r = tiles[i].getR()-centerR;
			
			tiles[i].setR(-c+centerR);
			tiles[i].setC(r+centerC);
			
			//System.out.println(tiles[i].getR() + "   " + tiles[i].getC());
		}
	}
	
	public void down() {
		centerR++;
		for (int i = 0; i < 4; i ++) {
			tiles[i].setR(tiles[i].getR()+1);
			
		}
	}
	
	public void up() {
		centerR--;
		for (int i = 0; i < 4; i ++) {
			tiles[i].setR(tiles[i].getR()-1);
			
		}
	}
	
	public void left() {
		centerC--;
		for (int i = 0; i < 4; i ++) {
			tiles[i].setC(tiles[i].getC()-1);
		}
	}
	
	public void right() {
		centerC++;
		for (int i = 0; i < 4; i ++) {
			tiles[i].setC(tiles[i].getC()+1);
		}
	}
	
	public Tile[] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[] tiles) {
		this.tiles = tiles;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	
}
