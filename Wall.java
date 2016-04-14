package jrJava.tetris5_withGraveyards;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import resources.*;


public class Wall {

	public static int LEFT = 100;
	public static int RIGHT = 500;
	public static int TOP = 40;
	public static int BOTTOM = 600;
	
	private static Color wallColor = Color.BLACK;
	private static Color gridColor = Color.GRAY;
	
	public static void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(gridColor);
		
		for(int i=LEFT; i<=RIGHT; i=i+Block.SIZE){
			canvas.drawLine(i, TOP, i, BOTTOM);
		}
		for(int i=TOP; i<=BOTTOM; i=i+Block.SIZE){
			canvas.drawLine(LEFT, i, RIGHT, i);
		}
		
		canvas.setColor(wallColor);
		canvas.drawRect(LEFT, TOP, RIGHT-LEFT, BOTTOM-TOP);
		
	}
	
	
	public static boolean isOutside(TetrisObject tetris){
		tetris.setAtGraveyardCoordinate();
		ArrayList<Block> theBlocks = tetris.blocks;
		for(int i=0; i<theBlocks.size(); i++){
			Block each = theBlocks.get(i);
			if(each.xGraveyard<Wall.LEFT ||
			   each.xGraveyard>=Wall.RIGHT ||
			   each.yGraveyard>=Wall.BOTTOM){
				return true;
			}
		}
		return false;
	}
	
}
