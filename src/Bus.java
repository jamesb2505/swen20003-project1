import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Bus extends Hazard {
	
	private float speed;

	/** Constructs a Bus
	 * @param image Image used to draw Bus
	 * @param x x coordinate of Bus
	 * @param y y coordinate of Bus
	 * @param speed speed of Bus (px/ms)
     */
	public Bus(Image image, float x, float y, float speed) {
		super(image, x, y);
		this.speed = speed;
	}
	/** Constructs a Bus
	 * @param imageSrc String location of Image used to draw Bus
	 * @param x x coordinate of Bus
	 * @param y y coordinate of Bus
	 * @param speed speed of Bus (px/ms)
	 * @throws SlickException
     */
	public Bus(String imageSrc, float x, float y, float speed) 
			throws SlickException {
		this(new Image(imageSrc), x, y, speed);
	}

	/** Moves a bus in the direction it is travelling. Wraps to the other side of screen
	 * once off screen
     * @param input The Slick input object
     * @param delta Time passed since last frame (ms)
     */
    @Override
	public void update(Input input, int delta) {
    	// check if off left of screen
		if (getX() + getWidth() / 2 < 0) {
			// wrap to right
			setX(App.SCREEN_WIDTH + getWidth() / 2);
		// check if off right of screen
		} else if (getX() - getWidth() / 2 > App.SCREEN_WIDTH) {
			// wrap to left
			setX(- getWidth() / 2);
		} else {
			// move by speed units in x direction
			move(speed, 0);
		}
	}
}
