package asteroids;

import java.util.ArrayList;

public class ObjectHandler {
	
	boolean newLevel;

	protected ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	
	//Should be called when the level is empty
	void spawnNew(int level){
		for(int i = 0; i<level+1; i++){
			asteroids.add(new Asteroid(3));	
		}
	}
	void spawnUpate(){
	  int spawnNum = 0;
	  for (int i = 0; i<asteroids.size(); i++){
	  
		  if(asteroids(i).iscollide()){
			if (asteroids(i).scale > 2) {
				spawnNum = 3;
			}
			else if (asteroids(i).scale > 1) {
				spawnNum = 5;
			}
			for (int j = 0; j<spawnNum; j++){
				asteroids.add(new Asteroid(scale-1));
			}
			asteroids.remove(i);
		}
	  }
	  if (asteroids.size() == 0)
		  newLevel = true;
	}	

}
