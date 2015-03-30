package asteroids;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame
{
	public Player carl = new Player();
	
	public Main(String gamename)
	{
		super(gamename);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {

	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		if(gc.getInput().isKeyDown(Input.KEY_UP))
			carl.thrust();
		if(gc.getInput().isKeyDown(Input.KEY_LEFT))
			carl.rotateLeft();
		if(gc.getInput().isKeyDown(Input.KEY_RIGHT))
			carl.rotateRight();
		carl.move();
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.draw(carl.getShape());
		
		
		
		
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Main("Asteroids"));
			appgc.setTargetFrameRate(60);
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

