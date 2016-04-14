package jrJava.tetris5_withGraveyards;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import resources.*;


public class StackManager {

	public static int NUM_OF_STACKS;
	public static Stack[] stacks;
	
	static {
		NUM_OF_STACKS = (Wall.RIGHT-Wall.LEFT)/Block.SIZE;
		stacks = new Stack[NUM_OF_STACKS];
		for(int i=0; i<NUM_OF_STACKS; i++){
			stacks[i] = new Stack();
		}
	}
	
	
	public static void draw(DrawingBoard board){
		for(int i=0; i<stacks.length; i++){
			Stack each = stacks[i];
			each.draw(board);
		}
	}
	
	
	
	public static void clearFullRows(){}
	
	
	public static boolean checkOverlapping(TetrisObject tetris){
		tetris.setAtGraveyardCoordinate();
		ArrayList<Block> theBlocks = tetris.blocks;
		for(int i=0; i<theBlocks.size(); i++){
			Block each = theBlocks.get(i);
			for(int j=0; j<stacks.length; j++){
				boolean overlapped = stacks[j].checkOverlapping(each);
				if(overlapped) return true;
			}
		}
		return false;
	}
	
	
	
	public static void buryTetrisObject(TetrisObject tetris){
		ArrayList<Block> theBlocks = tetris.blocks;
		tetris.setAtGraveyardCoordinate();
		for(int i=0; i<theBlocks.size(); i++){
			Block each = theBlocks.get(i);
			int stackIndexToBury = (each.xGraveyard-Wall.LEFT)/Block.SIZE;
			stacks[stackIndexToBury].add(each);
		}
	}
	
	
}



























