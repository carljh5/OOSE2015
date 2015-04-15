package asteroids;

import java.util.ArrayList;

public class ObjectHandler {
	
	public boolean newLevel;
	public ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	public ArrayList<Shot> bullets = new ArrayList<Shot>();
	
	public ObjectHandler(){
		
	}
	
	//Is called when the level is empty / completed
	public void spawnNew(int level){
		for(int i = 0; i<level+1; i++){
			asteroids.add(new Asteroid(3));	
		}
	}
	
	//Is called when the level is NOT empty / completed
	public void spawnUpate(){
	  if (asteroids.size() > 0){
		  newLevel = false;
		  for (Asteroid i : asteroids){
			  int spawnNum = 0;
			  for (Shot j : bullets){
				  if(i.isColliding(j.getShape())){
						if (i.scale > 2) {
							spawnNum = 3;
						}
						else if (i.scale > 1) {
							spawnNum = 5;
						}
						for (int k = 0; k<spawnNum; k++){
							asteroids.add(new Asteroid(i.scale-1));
							asteroids.remove(i);
						}
						break;
				  }
			  }
		  }
	  }
	  else
		  newLevel = true;
	}	
}
