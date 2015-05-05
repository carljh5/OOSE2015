package asteroids;

import java.util.ArrayList;
import java.util.Random;

public class ObjectHandler {
	
	public boolean newLevel;
	public ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	public ArrayList<Shot> bullets = new ArrayList<Shot>();
	public Player carl = new Player();
	public int level = 1;

	
	public ObjectHandler(){
		
	}
	
	public void runObject() {
		spawnNew();
		spawnUpdate();
		System.out.println(asteroids.size());
	}
	
	//Is called when the level is empty / completed
	public void spawnNew(){
		if (newLevel)
			for(int i = 0; i<level; i++)
				asteroids.add(new Asteroid(3, (float)(2*Math.PI/(level+1))*i));			
	}
	
	//Is called when the level is NOT empty / completed
	public void spawnUpdate(){
	  if (asteroids.size() > 0){
		  newLevel = false;
		  Asteroid asteroidRemove = null;
		  Shot bulletRemove = null;
		  int spawnNum = 0;
		  for (Asteroid i : asteroids){
			  for (Shot j : bullets){
				  if(i.isColliding(j.getShape())){
					  asteroidRemove = i;
					  bulletRemove = j;
						if (i.scale > 2) 
							spawnNum = 3;		
						else if (i.scale > 1) 
							spawnNum = 5;
						break;
				  }
			  } 
		  }
		  for (int k = 0; k<spawnNum; k++){
			  Random rand = new Random();
			  float ranNum = rand.nextFloat();
			  float degree = (float) ((ranNum*2*Math.PI/spawnNum)+(k*2*Math.PI/spawnNum));
			  asteroids.add(new Asteroid(asteroidRemove.scale-1,degree));
			  asteroids.get(asteroids.size()-1).setSpeed(50);
		  }
		  if (asteroidRemove != null)
			  asteroids.remove(asteroidRemove);
		  if (bulletRemove != null)
			  bullets.remove(bulletRemove);

	  }
	  else{
		  newLevel = true;
		  level++;
	  }
	}
	
	/**
	 * 
	 * Mirrors the Spaceobject
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
	
	public void updateMirror() {
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
