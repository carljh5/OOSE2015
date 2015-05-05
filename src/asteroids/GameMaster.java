
package asteroids;


public final class GameMaster {
	
	private static int height;
	private static int width;
	private static int score;
	private static int life;	
	
	public static void setHeight(int _height) {
		height = _height;
	}
	
	public static void setWidth(int _width) {
		width = _width;
	}
	
	public static int getHeight(){
		return height;
	}
	
	public static int getWidth(){
		return width;
	}
	
	public static void setScore(int s) {
		score += s;
	}
	
	public static int getScore() {
		return score;
	}
	
	public static void setLife(int l) {
		life += l;
	}
	
	public static int getLife() {
		return life;
	}

}
