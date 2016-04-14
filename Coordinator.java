package jrJava.tetris5_withGraveyards;

import java.awt.Color;
import javax.swing.JFrame;
import resources.*;


public class Coordinator {

	public static boolean CREATE_TETRIS_OBJECT = true;
	
	private static Timer timer = new Timer();
	private static DrawingBoard board = new DrawingBoard(600, 700);
	private static TetrisObject t1;
	private static JFrame frame;
	
	
	public static void main(String[] args) {
		
		frame = board.getJFrame();
				
		while(true){
			
			if(CREATE_TETRIS_OBJECT){
				t1 = createNewTetrisObject();
				frame.addKeyListener(t1);
				CREATE_TETRIS_OBJECT = false;
			}
			
			t1.moveDown();
			draw();
			
			timer.pause(300);
		}
	}
	
	
	public static void killTetrisObject(TetrisObject tetris){
		frame.removeKeyListener(tetris);
		CREATE_TETRIS_OBJECT = true;
	}
	
	
	private static TetrisObject createNewTetrisObject(){
		
		int select = (int)(Math.random()*5);
		if(select==0){
			return new Shape1();
		}
		else if(select==1){
			return new Shape2();
		}
		else if(select==2){
			return new Shape3();
		}
		else if(select==3){
			return new Shape4();
		}
		else if(select==4){
			return new Shape5();
		}
		
		return null;
	}
	

	public static void draw(){
		board.clear();
		Wall.draw(board);
		StackManager.draw(board);
		t1.draw(board);
		board.repaint();
	}
	
}















