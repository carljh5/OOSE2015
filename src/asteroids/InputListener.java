package asteroids;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class InputListener extends ObjectHandler {
	
	public InputListener() {
		
	}
	
	public void updateMove(GameContainer gaco) {
		runObject();
		if(gaco.getInput().isKeyPressed(Input.KEY_SPACE)){

			switch(GameMaster.getState()){
			case 0: 
				GameMaster.setState(1);
				break;
			case 1: 
				if(!overHeat){
					bullets.add(new Shot(carl.getX(), carl.getY(), carl.radians));
					sound.playShoot();
					if (heat + 15f <= maxHeat){
						heat += 15f;
					}
					else{
						heat = maxHeat;
					}
				}
				break;
			default:
				GameMaster.resetGame();
				asteroids.clear();
				bullets.clear();
				break;
			}
			
		}
		if(gaco.getInput().isKeyDown(Input.KEY_UP)) {
			carl.thrust();
			sound.playThrust();
		}
		else {
			sound.stopThrust();
		}
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
