
package asteroids;


public final class GameMaster {
	
	/**
	 * Values for width, height, score, life, level and GamesState
	 */
	private static int height, width, score, life, level, state;
	
	/**
	 * Sets height of screen
	 * @param int height
	 */
	public static void setHeight(int _height) {
		height = _height;
	}
	
	/**
	 * Sets width of screen
	 * @param int width
	 */
	public static void setWidth(int _width) {
		width = _width;
	}
	
	/**
	 * Gets height of screen
	 * @return int height
	 */
	public static int getHeight(){
		return height;
	}
	
	/**
	 * Gets width of screen
	 * @return int width
	 */
	public static int getWidth(){
		return width;
	}
	
	/**
	 * Sets score by incrementing with s
	 * @param int score
	 */
	public static void setScore(int s) {
		score += s;
	}
	
	/**
	 * Resets score to 0
	 */
	public static void resetScore() {
		score = 0;
	}
	
	/**
	 * Gets current score
	 * @return int score
	 */
	public static int getScore() {
		return score;
	}
	
	/**
	 * Sets GameState
	 * @param int GamesState
	 */
	public static void setState(int s) {
		state = s;
	}
	
	/**
	 * Gets current GamesState
	 * @return int GamesState
	 */
	public static int getState() {
		return state;
	}
	
	/**
	 * Sets lives by incrementing with int
	 * @param int lives
	 */
	public static void setLife(int l) {
		life += l;
	}
	
	/**
	 * Gets current lives
	 * @return int lives
	 */
	public static int getLife() {
		return life;
	}
	
	/**
	 * Sets level: increments with 1 when called 
	 */
	public static void setLevel() {
		level += 1;
	}
	
	/**
	 * Sets level
	 * @param int level
	 */
	public static void setLevel(int i) {
		level = i;
	}
	
	/**
	 * Gets level
	 * @return int level
	 */
	public static int getLevel() {
		return level;
	}
	
	/**
	 * Resets the score, level, life and GamesState
	 */
	public static void resetGame() {
		setState(1);
		setLevel(0);
		setLife(4);
		resetScore();
	}

}
