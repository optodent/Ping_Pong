import java.awt.Point;

public class Collidable {

	protected Point min;
	protected Point max;
	
	protected int positionX = 0; 
	protected int positionY = 0;	
	
	public boolean Intersect(Collidable other) {

		if ((max.x + positionX) < (other.min.x + other.positionX))
			return false; // a is left of b
		if ((min.x + positionX) > (other.max.x + other.positionX))
			return false; // a is right of b
		if ((max.y + positionY) < (other.min.y + other.positionY))
			return false; // a is above b
		if ((min.y + positionY) > (other.max.y + other.positionY))
			return false; // a is below b
		return true; // boxes overlap

	}
}
