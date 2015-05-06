package asteroids;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;


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
		grph.drawString("SCORE : " + Integer.toString(GameMaster.getScore()), 10, 0);
		grph.drawString("SHIPS : " + Integer.toString(GameMaster.getLife()), GameMaster.getWidth()-100, 0);
		grph.drawString("LVL : " + Integer.toString(GameMaster.getLevel()), 10, 20);
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
	
	void drawStartScene(Graphics grph) {

		grph.drawString("ASTEROIDS", GameMaster.getWidth()/2-40, GameMaster.getHeight()/3);
		grph.drawString("PRESS SPACE WHEN READY TO PLAY!", GameMaster.getWidth()/2-160, GameMaster.getHeight()/3+40);
		
	}
	
	void drawEndScene(Graphics grph) {

		grph.drawString("GAME OVER!", GameMaster.getWidth()/2-40, GameMaster.getHeight()/3);
		grph.drawString("PRESS SPACE WHEN READY TO PLAY AGAIN!", GameMaster.getWidth()/2-160, GameMaster.getHeight()/3+40);
		
	}
	
	/*public void drawStart(Graphics grph) {
		grph.drawString("");
	}*/

}
