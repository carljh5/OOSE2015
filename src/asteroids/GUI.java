package asteroids;

import org.newdawn.slick.Graphics;


public class GUI extends ObjectHandler {
	int time = 0;
	public GUI() {
		
	}
	
	public void drawScore(Graphics grph) {
		grph.drawString("SCORE : " + Integer.toString(GameMaster.getScore()), 0, 0);
		grph.drawString("SHIPS : " + Integer.toString(GameMaster.getLife()), GameMaster.getWidth()-100, 0);
	}
	
	public void drawPlayer(Graphics grph) {
		if(immune) {
			if(time < 20) {
				time++;
				grph.draw(carl.getShape());
				System.out.println("DRAW  " + time);
			}
			else if (time < 40) {
				time++;
				System.out.println("NO DRAW  " + time);
			}
			else {
				time = 0;
			}
		}
		else {
			grph.draw(carl.getShape());
			System.out.println("NO IMMUNE DRAW");
		}
	}

}
