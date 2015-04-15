package asteroids;

import java.util.ArrayList;

public class ObjectHandler {
	
	public boolean newLevel;
	public ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	public ArrayList<Shot> bullets = new ArrayList<Shot>();
	
	
	public ObjectHandler(){
		
	}
	
	public void runObject() {
		spawnNew(1);
		spawnUpdate();
	}
	
	//Is called when the level is empty / completed
	public void spawnNew(int level){
		if (newLevel)
			for(int i = 0; i<level+1; i++)
				asteroids.add(new Asteroid(3));			
	}
	
	//Is called when the level is NOT empty / completed
	public void spawnUpdate(){
	  if (asteroids.size() > 0){
		  newLevel = false;
		  Asteroid asteroidRemove = null;
		  Shot bulletRemove = null;
		  for (Asteroid i : asteroids){
			  int spawnNum = 0;
			  for (Shot j : bullets){
				  if(i.isColliding(j.getShape())){
					  asteroidRemove = i;
					  bulletRemove = j;
						if (i.scale > 2) 
							spawnNum = 3;		
						else if (i.scale > 1) 
							spawnNum = 5;
						for (int k = 0; k<spawnNum; k++)
							asteroids.add(new Asteroid(i.scale-1));
						break;
				  }
			  }
		  }
		  if (asteroidRemove != null)
			  asteroids.remove(asteroidRemove);
		  if (bulletRemove != null)
			  bullets.remove(bulletRemove);
	  }
	  else
		  newLevel = true;
	}	
}
