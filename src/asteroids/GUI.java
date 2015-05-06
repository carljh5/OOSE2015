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
		JFrame window = new JFrame();
		JPanel panel = new JPanel();
		JButton b1 = new JButton("Play Asteroids");
		grph.drawString("ASTEROIDS", GameMaster.getWidth()/2, GameMaster.getHeight()/3);
		
		window.setLayout(new GridLayout());
		window.add(panel);
		panel.add(b1);
		
		b1.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Heres a message");
				GameMaster.setState(1);
			}
		});
	}
	
	/*public void drawStart(Graphics grph) {
		grph.drawString("");
	}*/

}
