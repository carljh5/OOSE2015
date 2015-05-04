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
	public ObjectHandler objecthandler = new ObjectHandler();
	public Player carl = new Player();
	public GameMaster game;
	
	public Main(String gamename)
	{
		super(gamename);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		game = new GameMaster(gc);
	}
	
	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		objecthandler.runObject();
			
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE)){
			objecthandler.bullets.add(new Shot(carl.getX(), carl.getY(), carl.radians));
			System.out.println(carl.getX());
		}
		if(gc.getInput().isKeyDown(Input.KEY_UP))
			carl.thrust();
		if(gc.getInput().isKeyDown(Input.KEY_LEFT))
			carl.rotateLeft();
		if(gc.getInput().isKeyDown(Input.KEY_RIGHT))
			carl.rotateRight();
		for(Shot s : objecthandler.bullets) {
			s.move();
		}
		for(Asteroid a : objecthandler.asteroids) {
			a.move();
		}
		carl.move();
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.draw(carl.getShape());
		for(Shot s : objecthandler.bullets) {
			g.draw(s.getShape());
		}
		for(Asteroid a : objecthandler.asteroids)
			g.draw(a.getShape());
		
		// Finde plads til mirror
		// FEST
		
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

