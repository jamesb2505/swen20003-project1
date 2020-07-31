import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Hazard extends Sprite {
	
	/** Constructs a Hazard
	 * @param image Image used to draw Hazard
	 * @param x x coordinate of Hazard	 
	 * @param y y coordinate of Hazard
     */
	public Hazard(Image image, float x, float y) {
		super(image, x, y);
	}
	/** Constructs a Hazard
	 * @param imageSrc Path of Image used to draw Hazard
	 * @param x x coordinate of Hazard	 
	 * @param y y coordinate of Hazard
	 * @throws SlickException
     */
	public Hazard(String imageSrc, float x, float y) 
			throws SlickException {
		this(new Image(imageSrc), x, y);
	}
	
	/** Kills the game if the two Sprites intersect and other is a Player
     * @param other Another Sprite object
     */
    @Override
	public void contactSprite(Sprite other) {
		if (other instanceof Player && this.intersects(other)) {
			System.err.format("%s killed %s\n", this.toString(), other.toString());
			System.exit(0);
		}
    }
}
