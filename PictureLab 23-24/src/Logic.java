
import java.awt.Color;

public class Logic {
	
	/**
	 * Alters the picture so that each pixel's blue channel has been zeroed out.
	 * All other channels remain the same 
	 * @param picture the image to be altered
	 */
	public static void zeroBlue(DigitalPicture picture) {
		
		//obtain the 23D array rep. of the picture
		Pixel[][] pixel2D = picture.getPixels2D();
		
		//traverse the pixels and alter their values per filter spec
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				pixel2D[r][c].setRed(0);				//set red to 0 to remove redi
			}
		}
		
	}
	
	public static void blackAndWhite(DigitalPicture pic) {
		//1) obtain a 2D rep of the pixels that we an traverse
		Pixel[][] pixel2D = pic.getPixels2D();
		
		/* what makes something black and white?! */
		//find the average of the red, green, blue pixel values
		
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				pixel2D[r][c].setRed((int)pixel2D[r][c].getAverage());//set rgb values to the average of the three values
				pixel2D[r][c].setBlue((int)pixel2D[r][c].getAverage());
				pixel2D[r][c].setGreen((int)pixel2D[r][c].getAverage());
			}
		}
	}
	
	public static void negative(DigitalPicture pic) {
		//1) obtain a 2D rep of the pixels that we an traverse
		Pixel[][] pixel2D = pic.getPixels2D();
		
		/* what makes something black and white?! */
		//find the average of the red, green, blue pixel values
		
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				pixel2D[r][c].setRed((int)Math.abs(pixel2D[r][c].getRed()-255));//substract the value of the colors from 255 to get the inverse
				pixel2D[r][c].setBlue((int)Math.abs(pixel2D[r][c].getBlue()-255));
				pixel2D[r][c].setGreen((int)Math.abs(pixel2D[r][c].getGreen()-255));
			}
		}
	}
	
	
	public static void mirrorHorizontal(DigitalPicture pic) {
		//1) obtain a 2D rep of the pixels that we an traverse
		Pixel[][] pixel2D = pic.getPixels2D();
		
		
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length/2; c++) {//loop traverse for half of row
				int tempRed = pixel2D[r][c].getRed();//temp variable stores rgb values for first value
				int tempBlue = pixel2D[r][c].getBlue();
				int tempGreen = pixel2D[r][c].getGreen();
				
				pixel2D[r][c].setRed(pixel2D[r][pixel2D[0].length-1-c].getRed());//set rgb of first to last
				pixel2D[r][c].setBlue(pixel2D[r][pixel2D[0].length-1-c].getBlue());
				pixel2D[r][c].setGreen(pixel2D[r][pixel2D[0].length-1-c].getGreen());
				
				pixel2D[r][pixel2D[0].length-1-c].setRed(tempRed);//set rgb of last to temp
				pixel2D[r][pixel2D[0].length-1-c].setBlue(tempBlue);
				pixel2D[r][pixel2D[0].length-1-c].setGreen(tempGreen);
			}
		}
	}
	
	public static void mirrorVertical(DigitalPicture pic) {
		//1) obtain a 2D rep of the pixels that we an traverse
		Pixel[][] pixel2D = pic.getPixels2D();
		
		
		for (int r = 0; r < pixel2D.length/2; r++) {//loop traverse for half
			
			for (int c = 0; c < pixel2D[r].length; c++) {//loop traverse the collum to apply flip to each row in a single collum.
				int tempRed = pixel2D[r][c].getRed();//traverse loop, temp variable stores each color value
				int tempBlue = pixel2D[r][c].getBlue();
				int tempGreen = pixel2D[r][c].getGreen();
				
				pixel2D[r][c].setRed(pixel2D[pixel2D.length-1-r][c].getRed());//set first to last
				pixel2D[r][c].setBlue(pixel2D[pixel2D.length-1-r][c].getBlue());
				pixel2D[r][c].setGreen(pixel2D[pixel2D.length-1-r][c].getGreen());
				
				pixel2D[pixel2D.length-1-r][c].setRed(tempRed);//set last to temp
				pixel2D[pixel2D.length-1-r][c].setBlue(tempBlue);
				pixel2D[pixel2D.length-1-r][c].setGreen(tempGreen);
			}
		}
	}
	
	public static void makeSunset(DigitalPicture pic, double rr, double gb) {
		//1) obtain a 2D rep of the pixels that we an traverse
		Pixel[][] pixel2D = pic.getPixels2D();
		
		/* what makes something black and white?! */
		//find the average of the red, green, blue pixel values
		double redM = rr;
		double bgM = gb;
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				if (pixel2D[r][c].getRed()*redM <255) {//if statement prevents red from going out of bound
					pixel2D[r][c].setRed((int)(pixel2D[r][c].getRed()*redM));//multiply red pixel by correct factor
				}
				else {
					pixel2D[r][c].setRed(255);//set red to max if multiply will result in red going out of bound
				}
				pixel2D[r][c].setBlue(((int)(pixel2D[r][c].getBlue()*bgM)));//multiply blue and green pixel by correct color
				pixel2D[r][c].setGreen(((int)(pixel2D[r][c].getGreen()*bgM)));
			}
		}
	}
	
	public static void blur(DigitalPicture picture) {
		
		//obtain the 23D array rep. of the picture
		Pixel[][] pixel2D = picture.getPixels2D();
		
		//traverse the pixels and alter their values per filter spec
		for (int r = 0; r < pixel2D.length-1; r++) {//loop moving the 2x2 window
			for (int c = 0; c < pixel2D[r].length-1; c++) {
				int sumR = 0;
				int sumB = 0;
				int sumG = 0;
				//if (r+2 < pixel2D.length && c+2 < pixel2D[0].length) {
					for (int i = 0; i < 2; i ++) {
						for(int j = 0; j < 2; j ++) {
							sumR += pixel2D[r+i][c+j].getRed();//sum up each color and store in the variables
							sumB += pixel2D[r+i][c+j].getBlue();
							sumG += pixel2D[r+i][c+j].getGreen();
						}
					}
				//}
				
					
				pixel2D[r][c].setRed(sumR/4);//set each color to average
				pixel2D[r][c].setBlue(sumB/4);
				pixel2D[r][c].setGreen(sumG/4);
					
				
			}
		}
		
	}


//	/**
//	 * Alters the picture so that is is black and white by setting each pixels color value to be the average
//	 * of the pixels red, green, and blue channel. 
//	 * @param picture,  the image to be altered
//	 */
//	public static void ????(??? ???) {
//		
//		
//		
//	}

	


}
