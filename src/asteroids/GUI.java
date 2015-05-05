package asteroids;

import org.newdawn.slick.Graphics;


public class GUI extends ObjectHandler {
	int time = 0;
	public GUI() {
		
	}
	
	public void drawContent(Graphics grph) {
		drawScore(grph);
		drawPlayer(grph);
		drawSpaceObjects(grph);
	}
	
	private void drawScore(Graphics grph) {
		grph.drawString("SCORE : " + Integer.toString(GameMaster.getScore()), 0, 0);
		grph.drawString("SHIPS : " + Integer.toString(GameMaster.getLife()), GameMaster.getWidth()-100, 0);
	}
	
	private void drawPlayer(Graphics grph) {
		if(isImmune()) {
			if(time < 20) {
				time++;
				grph.draw(carl.getShape());
			}
			else if (time < 40) {
				time++;
			}
			else {
				time = 0;
			}
		}
		else {
			grph.draw(carl.getShape());
		}
	}
	
	private void drawSpaceObjects(Graphics grph) {
		for(Shot s : bullets) {
			grph.draw(s.getShape());
		}
		for(Asteroid a : asteroids)
			grph.draw(a.getShape());
	}
	
	/*public void drawStart(Graphics grph) {
		grph.drawString("");
	}*/

}
