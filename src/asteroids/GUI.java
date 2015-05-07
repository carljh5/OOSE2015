package asteroids;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;


public class GUI extends ObjectHandler {
	/**
	 * Time variable used for drawing player
	 */
	int time = 0;
	
	/**
	 * Draws heating bar
	 * @param Graphics
	 */
	private void drawHeatingBar(Graphics grph){
		if (overHeat) {
			grph.setColor(Color.red);
		} else {
			grph.setColor(Color.white);
		}
		grph.drawString("HEAT O-METER", 2*GameMaster.getWidth()/5, 0);
		grph.drawRect(2*GameMaster.getWidth()/5, GameMaster.getHeight()/20, GameMaster.getWidth()/5, GameMaster.getHeight()/20);
		grph.fillRect(2*GameMaster.getWidth()/5, GameMaster.getHeight()/20, (heat/maxHeat)*GameMaster.getWidth()/5, GameMaster.getHeight()/20);
	}
	
	/**
	 * Draws all content
	 * @param Graphics
	 */
	public void drawContent(Graphics grph) {
		drawScore(grph);
		drawPlayer(grph);
		drawSpaceObjects(grph);
		drawHeatingBar(grph);
	}
	
	/**
	 * Draws score
	 * @param Graphics
	 */
	private void drawScore(Graphics grph) {
		grph.drawString("SCORE : " + Integer.toString(GameMaster.getScore()), 10, 0);
		grph.drawString("SHIPS : " + Integer.toString(GameMaster.getLife()), GameMaster.getWidth()-100, 0);
		grph.drawString("LVL : " + Integer.toString(GameMaster.getLevel()), 10, 20);
	}
	
	/**
	 * Draws player
	 * @param Graphics
	 */
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
	
	/**
	 * Draws space objects
	 * @param Graphics
	 */
	private void drawSpaceObjects(Graphics grph) {
		for(Shot s : bullets) {
			grph.draw(s.getShape());
		}
		for(Asteroid a : asteroids)
			grph.draw(a.getShape());
	}
	
	/**
	 * Draws starting scene
	 * @param Graphics
	 */
	void drawStartScene(Graphics grph) {
		grph.drawString("ASTEROIDS", GameMaster.getWidth()/2-40, GameMaster.getHeight()/3);
		grph.drawString("PRESS SPACE WHEN READY TO PLAY!", GameMaster.getWidth()/2-160, GameMaster.getHeight()/3+40);
	}
	
	/**
	 * Draws game over scene
	 * @param Graphics
	 */
	void drawEndScene(Graphics grph) {
		grph.drawString("GAME OVER!", GameMaster.getWidth()/2-40, GameMaster.getHeight()/3);
		grph.drawString("YOUR SCORE WAS: " + Integer.toString(GameMaster.getScore()), GameMaster.getWidth()/2-160, GameMaster.getHeight()/3+40);
		grph.drawString("PRESS SPACE WHEN READY TO PLAY AGAIN!", GameMaster.getWidth()/2-160, GameMaster.getHeight()/3+80);
	}

}
