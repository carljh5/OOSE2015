package asteroids;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class InputListener extends ObjectHandler {
	
	public InputListener() {
		
	}
	
	public void updateMove(GameContainer gaco) {
		runObject();
		if(gaco.getInput().isKeyPressed(Input.KEY_SPACE)){
			if(!overHeat){
				bullets.add(new Shot(carl.getX(), carl.getY(), carl.radians));
				heat += 20f;
			}
			if (GameMaster.getState() == 0) {
				GameMaster.setState(1);
			}
			if (GameMaster.getState() == 2) {
				GameMaster.setState(1);
				GameMaster.setLife(4);
			}
		}
		if(gaco.getInput().isKeyDown(Input.KEY_UP))
			carl.thrust();
		if(gaco.getInput().isKeyDown(Input.KEY_LEFT))
			carl.rotateLeft();
		if(gaco.getInput().isKeyDown(Input.KEY_RIGHT))
			carl.rotateRight();
		
		for(Shot s : bullets) {
			s.move();
		}
		for(Asteroid a : asteroids) {
			a.move();
		}
		carl.move();
	}

}
