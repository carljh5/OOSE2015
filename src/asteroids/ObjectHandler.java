package asteroids;

import java.util.ArrayList;
import java.util.Random;

public class ObjectHandler {
	
	private static boolean newLevel = true;
	protected static ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	protected static ArrayList<Shot> bullets = new ArrayList<Shot>();
	protected static Player carl = new Player();
	protected static float immuneTime = 0f;
	
	public void runObject() {
		// Only run the ObjectHandler when the game is in play mode (state 1)
		if (GameMaster.getState() == 1) {
			spawnNew();
			spawnUpdate();
			spawnPlayer();
			updateMirror();
		}
	}
	
	/**
	 * 
	 * Is called when the level is empty / completed
	 */	
	private void spawnNew(){
		if (newLevel){
			/* The level is incremented and the bullets are cleared from the screen when
			 * a new level is loaded.
			 */
			GameMaster.setLevel();
			bullets.clear();
			/* The amount of asteroids spawned is determined by the game level (level + 1).
			 * The position of the newly spawned asteroids is determined by random floats.
			 * Lastly, the asteroids are not allowed to spawn on top of the player, in 
			 * order to not lose lives by random.
			 */
			for(int i = 0; i<GameMaster.getLevel()+1; i++){
				Random rnd = new Random();
				int width = GameMaster.getWidth();
				float xPos = rnd.nextFloat()*width;
				int height = GameMaster.getHeight();
				float yPos = rnd.nextFloat()*height/4;
				float xBound = GameMaster.getWidth()/15;
				float yBound = GameMaster.getHeight()/15;
				if (yPos < carl.getY()+yBound && yPos > carl.getY()-yBound)
					yPos = carl.getY()-yBound;
				if (xPos < carl.getX()+xBound && xPos > carl.getX()-xBound)
					xPos = carl.getX()-xBound;
				asteroids.add(new Asteroid(3,(float)(2*Math.PI/(GameMaster.getLevel()+1))*i,xPos,yPos));	
			}
		}
	}
	
	/**
	 * 
	 * Is called when the level is NOT empty / completed
	 */
	private void spawnUpdate(){
	  if (asteroids.size() > 0){
		  // If the size of the arraylist is bigger than 0, then the level is still going
		  newLevel = false;
		  // Initialise a temporary asteroid and bullet to be removed during collision
		  Asteroid asteroidRemove = null;
		  Shot bulletRemove = null;
		  int spawnNum = 0;
		  /*
		   * The following statement checks if any bullet is colliding with any asteroid.
		   * If true, bulletRemove will be set to the colliding bullet and asteroidRemove will
		   * be set to the colliding asteroid
		   */
		  for (Asteroid i : asteroids){
			  for (Shot j : bullets){
				  if(i.isColliding(j.getShape())){
					  asteroidRemove = i;
					  bulletRemove = j;
					  /*
					   *  Decide how many asteroids should spawn, depending on the scale of the colliding 
					   *  asteroid
					   */
						if (i.scale > 2) {
							spawnNum = 3;
						}
						else if (i.scale > 1) {
							spawnNum = 5;
							
						}
						else {
							spawnNum = 0;
						}
						break;
				  }
			  } 
		  }
		  // Create new asteroids.
		  for (int k = 0; k<spawnNum; k++){
			  Random rand = new Random();
			  float ranNum = rand.nextFloat();
			  /*
			   * Give the asteroid a random direction while making sure that two asteroids will not get
			   * the same direction.
			   */
			  float degree = (float) ((ranNum*2*Math.PI/spawnNum)+(k*2*Math.PI/spawnNum));
			  asteroids.add(new Asteroid(asteroidRemove.scale-1,degree,asteroidRemove.getX(),asteroidRemove.getY()));
		  }
		  // Remove the colliding asteroid and bullet from their array lists
		  if (asteroidRemove != null) {
			  asteroids.remove(asteroidRemove);
			  GameMaster.setScore(1);
		  }
		  if (bulletRemove != null)
			  bullets.remove(bulletRemove);
	  }
	  else{
		  newLevel = true;
	  }
	  
	  // Set state 2 (game over) when the player loses all his life.
	  if (GameMaster.getLife() < 0) {
		  GameMaster.setState(2);
	  }
	}
	
	/*
	 * 
	 * Method to check whether the player is immune or not
	 */
	protected boolean isImmune() {
		if (immuneTime > 2f) {
			return false;
		  }
		  else {
			  immuneTime += 0.005f;
			  return true;
		  }
	}
	
	/**
	 * 
	 * Method for spawning player when he collides with an asteroid.
	 * The player will gain immunity for a short amount of time when spawned
	 */
	private void spawnPlayer() {
		if(!isImmune()) {
			for(Asteroid a : asteroids) {
				if(a.isColliding(carl.getShape())) {
					carl = new Player(carl.radians);
					GameMaster.setLife(-1);
					immuneTime = 0f;
				}
			}
		}
	  }

	/**
	 * 
	 * Mirrors a SpaceObject
	 */
	private void mirror(SpaceObject object) {
		if (object.getX() < 0) {
			object.setX(GameMaster.getWidth());
			if(object.getClass().getName().contains("Shot")) {
				object.mirrorLimit++;
			}
		} 
		if (object.getY() < 0) {
			object.setY(GameMaster.getHeight());
			if(object.getClass().getName().contains("Shot")) {
				object.mirrorLimit++;
			}
		} 
		if (object.getX() > GameMaster.getWidth()) {
			object.setX(0);
			if(object.getClass().getName().contains("Shot")) {
				object.mirrorLimit++;
			}
		} 
		if (object.getY() > GameMaster.getHeight()) {
			object.setY(0);
			if(object.getClass().getName().contains("Shot")) {
				object.mirrorLimit++;
			}
		}	
	}
	
	/**
	 * 
	 * Makes sure that the shots fired will decay
	 */
	private boolean shotDecay (SpaceObject object) {
		if (object.mirrorLimit >= 2) {
			object.mirrorLimit = 0;
			return true;
		} else {
			return false;
		}
	}
	

	/**
	 * 
	 * Updates the mirror method for bullets, player and asteroids
	 */
	private void updateMirror() {
		Shot bullet = null;
		for (Shot s : bullets) {
			mirror(s);
			if(shotDecay(s)) {
				bullet = s;
			}
		}
		if (bullet != null) {
			bullets.remove(bullet);
			
		}
		for (Asteroid a : asteroids) {
			mirror(a);
		}
		mirror(carl);
	}
	
}
