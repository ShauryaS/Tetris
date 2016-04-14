package jrJava.tetris5_withGraveyards;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.*;


public class Block {

	public static int SIZE = 20;
	
	public int xDisplacement;
	public int yDisplacement;
	
	public int xGraveyard;
	public int yGraveyard;
	
	public Color color;
	
	public Block(int _xDisplacement, int _yDisplacement, Color _color){
		xDisplacement = _xDisplacement;
		yDisplacement = _yDisplacement;
		color = _color;
	}
	
	
	public boolean checkOverlapping(Block tetrisBlock){
		// we will check the x and y coordinate values of
		// the tetrisBlock against this.
		return false;
	}
	
	
	
	
	public void rotate(){
		int xNew = - yDisplacement;
	    int yNew = xDisplacement;
	    xDisplacement = xNew;
	    yDisplacement = yNew;
	}
	
	public void counterRotate(){
		int xNew = yDisplacement;
	    int yNew = -xDisplacement;
	    xDisplacement = xNew;
	    yDisplacement = yNew;
	}
	
	
	public void mirror(){
		xDisplacement = -xDisplacement;
	}
	
	public void counterMirror(){
		mirror();
	}
	
	
	public void draw(int _xCenter, int _yCenter, DrawingBoard board){
		
		int x = _xCenter + xDisplacement*SIZE;
		int y = _yCenter + yDisplacement*SIZE;
		
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillRect(x, y, SIZE, SIZE);
		canvas.setColor(Color.black);
		canvas.drawRect(x, y, SIZE, SIZE);
		
		if(xDisplacement==0 && yDisplacement==0){
			canvas.setColor(Color.black);
			canvas.drawOval(x+5, y+5, 10, 10);
		}
	}
	
}



















