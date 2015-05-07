package asteroids;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class InputListener extends ObjectHandler {
	
	public InputListener() {
		
	}
	
	/**
	 * Method to run the ObjectHandler as well as respond to input and move objects.
	 * @param gaco
	 */
	public void updateMove(GameContainer gaco) {
		runObject();
		respondToInput(gaco);
		moveObjects();
	}
		
	/**
	 * Method that responds to input
	 * @param gaco
	 */
	private void respondToInput(GameContainer gaco) {
		if(gaco.getInput().isKeyPressed(Input.KEY_SPACE))
			decideSpaceAction();	
		if(gaco.getInput().isKeyDown(Input.KEY_UP)) {
			carl.thrust();
			sound.playThrust();
		}
		else 
			sound.stopThrust();
		if(gaco.getInput().isKeyDown(Input.KEY_LEFT))
			carl.rotateLeft();
		if(gaco.getInput().isKeyDown(Input.KEY_RIGHT))
			carl.rotateRight();
	}
	
	/**
	 * Method that moves all objects in the scene
	 */
	private void moveObjects() {
		for(Shot s : bullets) {
			s.move();
		}
		for(Asteroid a : asteroids) {
			a.move();
		}
		carl.move();
	}
	
	/**
	 * Method that decides what action to perform when space is pressed, based on the game state.
	 */
	private void decideSpaceAction(){
		switch(GameMaster.getState()){
			case 0: 
				GameMaster.setState(1);
				break;
			case 1: 
				// Only respond to input when the player is not overheated
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
				// Reset the game and clear the screen (and Array Lists)
				GameMaster.resetGame();
				asteroids.clear();
				bullets.clear();
				break;
		}
	}
}
