import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Water extends Hazard {

	/** Constructs a Water tile
	 * @param image Image used to draw Water
	 * @param x x coordinate of Water	 
	 * @param y y coordinate of Water
     */
	public Water(Image image, float x, float y) {
		super(image, x, y);
	}
	/** Constructs a Water tile
	 * @param imageSrc Path of Image used to draw Water
	 * @param x x coordinate of Water
	 * @param y y coordinate of Water
	 * @throws SlickException
     */
	public Water(String imageSrc, float x, float y) 
			throws SlickException {
		this(new Image(imageSrc), x, y);
	}
}
