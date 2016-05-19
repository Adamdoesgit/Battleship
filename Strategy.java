
public class Strategy {
	
	public static Point hit; //first hit
	public static Point current; //most recent hit
	public static int direction = 1; //increment forward or backwards (for kill())
	public static boolean axis; //orientation of ship
	
	//a checker to make sure a point is valid
	public static boolean checker(Point p) {
		return (p.getX() < 0 || p.getX() > 9 || p.getY() < 0 || p.getY() > 9);
	}
	
	//hunting for a boat
	public static Point hunt() {
		//this method chooses alternating squares in order to more efficiently find a target
		if (0.5> Math.random()){
			Point p = new Point((2 * (int)(Math.random() * 5)), (2 * (int)(Math.random() * 5)));
			return p;
		}
		else {
			Point p = new Point((2 * (int)(Math.random() * 5) + 1), (2 * (int)(Math.random() * 5)) + 1);
			return p;
		}
	}
	
	//searching for where the rest of the boat is
	public static Point search() {
		int offsetX;
		int offsetY;
		// aims at adjacent squares to the initial hit, which are chosen at random
		double random = Math.random();
		
		if (0.25 > random) {
			offsetX = 1;
			offsetY = 0;
		}
		else if (0.5 > random) {
			offsetX = 0;
			offsetY = 1;
		}
		else if (0.75 > random) {
			offsetX = -1;
			offsetY = 0;
		}
		else {
			offsetX = 0;
			offsetY = -1;
		}
		Point p = new Point(hit.getX() + offsetX, hit.getY() + offsetY);
		return p;
	}
	
	//with two points, the computer can now attempt to follow the ship's length and sink it
	public static Point kill() {
		int x;
		int y;
		//tests if horizontal or vertical
		if (axis) {
			//step is determined by the direction (go forwards or backwards)
			x = current.getX();
			y = current.getY() + direction;
		}
		else {
			x = current.getX() + direction;
			y = current.getY();
		}
		Point p = new Point(x, y);
		return p;
	}
	
	//determines the orientation of the targeted ship
	public static void axisSetter() {
		if (hit.getX() == current.getX()) {
			axis = true;
		}
		else {
			axis = false;
		}
	}
}
