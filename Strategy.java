
public class Strategy {
	
	public static Point hit;
	public static Point current;
	public static int direction = 1;
	
	public static boolean checker(Point p) {
		return (p.getX() < 0 || p.getX() > 9 || p.getY() < 0 || p.getY() > 9);
	}
	
	public static Point hunt() {
		if (0.5> Math.random()){
			Point p = new Point((2 * (int)(Math.random() * 5)), (2 * (int)(Math.random() * 5)));
			return p;
		}
		else {
			Point p = new Point((2 * (int)(Math.random() * 5) + 1), (2 * (int)(Math.random() * 5)) + 1);
			return p;
		}
	}
	
	public static Point search() {
		int offsetX;
		int offsetY;
		if (0.25 > Math.random()) {
			offsetX = 1;
			offsetY = 0;
		}
		else if (0.5 > Math.random()) {
			offsetX = 0;
			offsetY = 1;
		}
		else if (0.75 > Math.random()) {
			offsetX = -1;
			offsetY = 0;
		}
		else {
			offsetX = 0;
			offsetY = -1;
		}
		Point p = new Point(hit.getX() + offsetX, hit.getY() + offsetY);
		//if (checker(p)) {
			//search();
		//}
		return p;
	}
	
	public static Point kill() {
		int x;
		int y;
		int direct;
		if (hit.getX() == current.getX()) {
			x = current.getX();
			y = current.getY() + direction;
		}
		else {
			x = current.getX() + direction;
			y = current.getY();
		}
		Point p = new Point(x, y);
		/*if (checker(p)) {
			current = hit;
			direction = false;
			kill();
		}*/
		return p;
	}
}
