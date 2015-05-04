
package asteroids;


public final class GameMaster {
	
	private static int height;
	private static int width;
	//public SpaceObject object = new SpaceObject();
	
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

}
