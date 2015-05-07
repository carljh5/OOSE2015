package asteroids;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


public class SoundHandler {
	private Sound death;
	private Sound thrust;
	private Sound impact;
	private Sound shoot;
	private Sound overheat;
	
	public SoundHandler() {
		try {
			death = new Sound("sound/death.ogg");
			thrust = new Sound("sound/thrust.ogg");
			impact = new Sound("sound/impact.ogg");
			shoot = new Sound("sound/shoot.ogg");
			overheat = new Sound("sound/overheat.ogg");
		} catch (SlickException e) {
			System.out.println("Cannot load death.ogg");
		}
	}
	
	public void playDeath() {
		death.play();
	}

	public void playThrust() {
		if(!thrust.playing())
		thrust.play();
	}
	
	public void stopThrust() {
		thrust.stop();
	}
	
	public void playImpact() {
		impact.play();
	}
	
	public void playShoot() {
		shoot.play();
	}
	
	public void playOverheat() {
		if(!overheat.playing())
		overheat.loop();
	}
	
	public void stopOverheat() {
		overheat.stop();
	}
}