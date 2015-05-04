
package asteroids;

import org.newdawn.slick.GameContainer;

public class GameMaster {
	
	public int height;
	public int width;
	public int mirrorLimit = 0;
	//public SpaceObject object = new SpaceObject();
	
	public GameMaster(GameContainer gcon) {
		width = gcon.getWidth();
		height = gcon.getHeight();
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	/**
	 * 
	 * Mirrors the Spaceobject
	 */
	public void mirror(SpaceObject object) {
		if (object.getX() < 0) {
			object.setX(width);
			mirrorLimit++;
		} 
		if (object.getY() < 0) {
			object.setY(height);
			mirrorLimit++;
		} 
		if (object.getX() > width) {
			object.setX(0);
			mirrorLimit++;
		} 
		if (object.getY() > height) {
			object.setY(0);
			mirrorLimit++;
		}	
	}
	
	/**
	 * 
	 * Makes sure that the shots fired will decay
	 */
	public boolean shotDecay (SpaceObject object) {
		if (mirrorLimit > 2) {
			mirrorLimit = 0;
			return true;
		} else {
			return false;
		}
	}

}
