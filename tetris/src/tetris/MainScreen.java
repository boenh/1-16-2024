package tetris;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class MainScreen extends JComponent{
	public MainScreen() {
		this.setSize(300,600);
		this.setBackground(Color.LIGHT_GRAY);
	}
	

	
	public void update(Tile[][] tiles) {
		Graphics g = getGraphics();
		g.clearRect(0, 0, 300, 600);
		
		for (int i = 0; i < tiles.length; i ++) {
			for (int j = 0; j < tiles[0].length; j ++) {
				if (tiles[i][j] != null) {
					g.setColor(tiles[i][j].getColor());
					g.fillRect(j*30, i*30, 30, 30);
					g.setColor(Color.LIGHT_GRAY);
					g.drawRect(j*30, i*30, 30, 30);
				}
			}
		}
		
		this.update(g);
		
	}
	
	
}
