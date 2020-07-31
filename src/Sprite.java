import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import utilities.BoundingBox;

public abstract class Sprite {
	
	private Image image;
	private float x;
	private float y;
	private BoundingBox bb;

	/** Constructs a Sprite 
	 * @param image Image used to draw Sprite
	 * @param x x coordinate of Sprite	 
	 * @param y y coordinate of Sprite
     */
	public Sprite(Image image, float x, float y) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.bb = new BoundingBox(image, x, y);
	}
	/** Constructs a Sprite 
	 * @param imageSrc Path of Image used to draw sprite
	 * @param x x coordinate of Sprite	 
	 * @param y y coordinate of Sprite
	 * @throws SlickException 
     */
	public Sprite(String imageSrc, float x, float y) 
			throws SlickException {
		this(new Image(imageSrc), x, y);
	}
	
	/** @return String representation of Sprite. "Class:(x,y)"
     */
    @Override
	public String toString() {
		return String.format("%s@(%.3f, %.3f)", getClass().getSimpleName(), getX(), getY());
	}
    
    /** Placeholder for further Sprite updates
     * @param input The Slick input object
     * @param delta Time passed since last update (ms)
     */
	public void update(Input input, int delta) {
		// nothing
	}
	
	/** Draws image at the Sprite's x,y location
     */
	public void render() {
		image.drawCentered(getX(), getY());	
	}
	
	/** Placeholder for further sprite Collision
     */
	public void contactSprite(Sprite other) {
		// nothing
	}
	
	public boolean intersects(Sprite other) {
		return bb.intersects(other.bb);
	}
	
	/** Moves a Sprite's location
	 * @param dx Change in x position
	 * @param dy Change in y position
     */
	public void move(float dx, float dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public void setX(float x) {
		this.bb.setX(x);
		this.x = x;
	}
	public void setY(float y) {
		this.bb.setY(y);
		this.y = y;
	}
	
	public float getWidth() {
		return image.getWidth();
	}
	public float getHeight() {
		return image.getHeight();
	}
}
