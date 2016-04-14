package jrJava.tetris5_withGraveyards;

import java.awt.Color;

public class Shape4 extends TetrisObject{

	protected void createTetrisObject(){
		
		int colorSelection = (int)(Math.random()*colorMenu.length);
		Color selected = colorMenu[colorSelection];
		
		blocks.add(new Block(-1, 0, selected));
		blocks.add(new Block(0, 0, selected));
		blocks.add(new Block(1, 0, selected));
		blocks.add(new Block(1, 1, selected));
		
		int numOfRotation = (int)(Math.random()*4);
		for(int i=0; i<numOfRotation; i++){
			rotate();
		}
	}
}
