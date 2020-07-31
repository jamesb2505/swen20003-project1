import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Grass extends Sprite {
	
	/** Constructs a Grass tile
	 * @param imageSrc Image used to draw Grass
	 * @param x x coordinate of Grass
	 * @param y y coordinate of Grass
     */
	public Grass(Image image, float x, float y) {
		super(image, x, y);
	}
	/** Constructs a Grass tile
	 * @param imageSrc Path of Image used to draw Grass
	 * @param x x coordinate of Grass
	 * @param y y coordinate of Grass
     * @throws SlickException
     */
	public Grass(String imageSrc, float x, float y) 
			throws SlickException {
		this(new Image(imageSrc), x, y);
	}
}
