package jrJava.tetris5_withGraveyards;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import resources.*;



public class Stack {

	public ArrayList<Block> blocks = new ArrayList<Block>();
	
	
	public void add(Block block){
		blocks.add(block);
	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		for(int i=0; i<blocks.size(); i++){
			Block block = blocks.get(i);
			canvas.setColor(block.color);
			canvas.fillRect(block.xGraveyard, block.yGraveyard, block.SIZE, block.SIZE);
			canvas.setColor(Color.BLACK);
			canvas.drawRect(block.xGraveyard, block.yGraveyard, block.SIZE, block.SIZE);
		}
	}	
	
	
	public boolean checkOverlapping(Block block){
		for(int i=0; i<blocks.size(); i++){
			Block each = blocks.get(i);
			if(block.xGraveyard==each.xGraveyard && block.yGraveyard==each.yGraveyard){
				return true;
			}
		}
		return false;
    }
	
}
