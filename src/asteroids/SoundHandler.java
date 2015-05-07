package asteroids;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


public class SoundHandler {
	
	/**
	 * Variables for the different sounds
	 */
	private Sound death, thrust, impact, shoot, overheat;
	
	/**
	 * Loads all the sounds
	 */
	public SoundHandler() {
		try {
			death = new Sound("sound/death.ogg");
			thrust = new Sound("sound/thrust.ogg");
			impact = new Sound("sound/impact.ogg");
			shoot = new Sound("sound/shoot.ogg");
			overheat = new Sound("sound/overheat.ogg");
		} catch (SlickException e) {
			System.out.println("Cannot load sound");
		}
	}
	
	/**
	 * Plays sound when player collides
	 */
	public void playDeath() {
		death.play();
	}
	
	/**
	 * Plays sound when player thrusts
	 */
	public void playThrust() {
		if(!thrust.playing())
			thrust.play();
	}
	
	/**
	 * Stops thrusting sound
	 */
	public void stopThrust() {
		thrust.stop();
	}
	
	/**
	 * Plays sound when shot hits asteroid
	 */
	public void playImpact() {
		impact.play();
	}
	
	/**
	 * Plays sound when shooting
	 */
	public void playShoot() {
		shoot.play();
	}
	
	/**
	 * Plays sound when overheating
	 */
	public void playOverheat() {
		if(!overheat.playing())
			overheat.loop();
	}
	
	/**
	 * Stops sound when overheating
	 */
	public void stopOverheat() {
		overheat.stop();
	}
}
