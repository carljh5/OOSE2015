package asteroids;

import java.util.ArrayList;

public class ObjectHandler {
	
	public boolean newLevel;
	public ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	public ArrayList<Shot> bullets = new ArrayList<Shot>();
	public Player carl = new Player();

	
	public ObjectHandler(){
		
	}
	
	public void runObject() {
		spawnNew(1);
		spawnUpdate();
		System.out.println(asteroids.size());
	}
	
	//Is called when the level is empty / completed
	public void spawnNew(int level){
		if (newLevel)
			for(int i = 0; i<level+1; i++)
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
			  if (bulletRemove != null)
				  bullets.remove(bulletRemove);
		  }
		  for (int k = 0; k<spawnNum; k++)
			  asteroids.add(new Asteroid(asteroidRemove.scale-1, (float)(2*Math.PI/(spawnNum))*k));
		  if (asteroidRemove != null)
			  asteroids.remove(asteroidRemove);

	  }
	  else
		  newLevel = true;
	}
	
	/**
	 * 
	 * Mirrors the Spaceobject
	 */
	public void mirror(SpaceObject object) {
		if (object.getX() < 0) {
			object.setX(GameMaster.getWidth());
			//mirrorLimit++;
			if(object.getClass().getName().contains("Shot")) {
				object.mirrorLimit++;
			}
		} 
		if (object.getY() < 0) {
			object.setY(GameMaster.getHeight());
			//mirrorLimit++;
			if(object.getClass().getName().contains("Shot")) {
				object.mirrorLimit++;
			}
		} 
		if (object.getX() > GameMaster.getWidth()) {
			object.setX(0);
			//mirrorLimit++;
			if(object.getClass().getName().contains("Shot")) {
				object.mirrorLimit++;
			}
		} 
		if (object.getY() > GameMaster.getHeight()) {
			object.setY(0);
			//mirrorLimit++;
			if(object.getClass().getName().contains("Shot")) {
				object.mirrorLimit++;
			}
		}	
	}
	
	/**
	 * 
	 * Makes sure that the shots fired will decay
	 */
	public boolean shotDecay (SpaceObject object) {
		if (object.mirrorLimit > 2) {
			object.mirrorLimit = 0;
			return true;
		} else {
			return false;
		}
	}
	
	public void updateMirror() {
		Shot bullet = null;
		for (Shot s : bullets) {
			bullet = s;
			mirror(s);
		}
		
		if (bullet != null && shotDecay(bullet)) {
			bullets.remove(bullet);
		}
		Asteroid ast = null;
		for (Asteroid a : asteroids) {
			ast = a;
			mirror(a);
		}
	}
	
}
