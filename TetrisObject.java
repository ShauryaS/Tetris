package jrJava.tetris5_withGraveyards;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import resources.*;

      

public class TetrisObject implements KeyListener {

	public static Color[] colorMenu = new Color[]{ Color.RED, Color.BLUE,
		                                        Color.GREEN, Color.CYAN,
		                                        Color.ORANGE, Color.PINK, 
		                                        Color.YELLOW, Color.MAGENTA};
	
	public ArrayList<Block> blocks = new ArrayList<Block>();
	
	private int xCenter;
	private int yCenter;
	
	public TetrisObject(){    
		xCenter = 300;        
		yCenter = 60;        
		createTetrisObject();
	}
	
	
    protected void createTetrisObject(){}
	
	
    public void setAtGraveyardCoordinate(){
    	for(int i=0; i<blocks.size(); i++){
			Block each = blocks.get(i);
			each.xGraveyard = each.xDisplacement*Block.SIZE + xCenter;
			each.yGraveyard = each.yDisplacement*Block.SIZE + yCenter;
		}
    }
    
    
	public void moveDown(){
		yCenter = yCenter + Block.SIZE;
		boolean overlapped = StackManager.checkOverlapping(this);
		boolean outsideWall = Wall.isOutside(this);
		
		if(overlapped||outsideWall){
			yCenter = yCenter - Block.SIZE;
			Coordinator.killTetrisObject(this);
			StackManager.buryTetrisObject(this);
		}
	}
	
	protected void rotate(){
		for(int i=0; i<blocks.size(); i++){
			Block each = blocks.get(i);
			each.rotate();
		}
	}
	
	protected void counterRotate(){
		for(int i=0; i<blocks.size(); i++){
			Block each = blocks.get(i);
			each.counterRotate();
		}
	}	
	
	public void draw(DrawingBoard board){
		
		for(int i=0; i<blocks.size(); i++){
			Block block = blocks.get(i);
			block.draw(xCenter, yCenter, board);
		}
	}


	public void keyTyped(KeyEvent e) {}


	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			xCenter = xCenter - Block.SIZE;
			boolean overlapped = StackManager.checkOverlapping(this);
			boolean outsideWall = Wall.isOutside(this);
			
			if(overlapped||outsideWall){
				xCenter = xCenter + Block.SIZE;
			}
			Coordinator.draw();
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			xCenter = xCenter + Block.SIZE;
			boolean overlapped = StackManager.checkOverlapping(this);
			boolean outsideWall = Wall.isOutside(this);
			
			if(overlapped||outsideWall){
				xCenter = xCenter - Block.SIZE;
			}
			Coordinator.draw();
		}
		
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			while(true){
				yCenter = yCenter + Block.SIZE;
				boolean overlapped = StackManager.checkOverlapping(this);
				boolean outsideWall = Wall.isOutside(this);
				
				if(overlapped||outsideWall){
					yCenter = yCenter - Block.SIZE;
					Coordinator.killTetrisObject(this);
					StackManager.buryTetrisObject(this);
					break;
				}
			
			}
			
			Coordinator.draw();
		}
		else if(e.getKeyChar()=='r'){
			rotate();
			boolean overlapped = StackManager.checkOverlapping(this);
			boolean outsideWall = Wall.isOutside(this);
			
			if(overlapped||outsideWall){
				counterRotate();
			}
			Coordinator.draw();
		}
		else if(e.getKeyChar()=='m'){
			for(int i=0; i<blocks.size(); i++){
				Block each = blocks.get(i);
				each.mirror();
			}
			boolean overlapped = StackManager.checkOverlapping(this);
			boolean outsideWall = Wall.isOutside(this);
			
			if(overlapped||outsideWall){
				for(int i=0; i<blocks.size(); i++){
					Block each = blocks.get(i);
					each.counterMirror();
				}
			}
			Coordinator.draw();
		}
	}

	public void keyReleased(KeyEvent e) {}


	
}

































