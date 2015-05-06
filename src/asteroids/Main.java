package asteroids;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame
{
	public GUI gui;
	public InputListener inputListener;
	
	public Main(String gamename)
	{
		super(gamename);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		GameMaster.setHeight(gc.getHeight());
		GameMaster.setWidth(gc.getWidth());
		GameMaster.setLife(3);
		gui = new GUI();
		inputListener = new InputListener();
	}
	
	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		inputListener.updateMove(gc);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		if (GameMaster.getState() == 0) {
			gui.drawStartScene(g);
		} else if (GameMaster.getState() == 2) {
			gui.drawEndScene(g);
			GameMaster.setLife(3);
		} else {
			gui.drawContent(g);
		}
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Main("Asteroids"));
			appgc.setTargetFrameRate(60);
			appgc.setDisplayMode(640, 480, false);
			appgc.setShowFPS(false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

