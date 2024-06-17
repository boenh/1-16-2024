package tetris;

import java.awt.*;
import java.util.*;

public class Tile {
	private Block block;
	private int r;
	private int c;
	private Color color;
	
	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Tile(Block block, int r, int c, Color color) {
		this.block = block;
		this.r = r;
		this.c = c;
		this.color = color;
	}

}
