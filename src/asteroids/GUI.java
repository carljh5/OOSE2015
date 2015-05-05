package asteroids;

import org.newdawn.slick.Graphics;


public class GUI {
	
	public GUI() {
		
	}
	
	public void display(Graphics grph) {
		grph.drawString("SCORE : " + Integer.toString(GameMaster.getScore()), 0, 0);
		grph.drawString("SHIPS : " + Integer.toString(GameMaster.getLife()), GameMaster.getWidth()-100, 0);
	}

}
