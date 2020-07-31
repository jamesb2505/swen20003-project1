import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player extends Sprite {
	
	/** Constructs a Player
	 * @param image Image used to draw Player
	 * @param x x coordinate of Player	 
	 * @param y y coordinate of Player
     */
	public Player(Image image, float x, float y) {
		super(image, x, y);
	}
	/** Constructs a Player 
	 * @param imageSrc Path of Image used to draw Player
	 * @param x x coordinate of Player	 
	 * @param y y coordinate of Player
     * @throws SlickException
     */
	public Player(String imageSrc, float x, float y) 
			throws SlickException {
		this(new Image(imageSrc), x, y);
	}
	
	/** Moves the player based on user input
     * @param input The Slick input object
     * @param delta Time passed since last update (ms)
     */
	@Override
	public void update(Input input, int delta) {
		// accumulate the total movement in x and y directions
		float xMovement = 0, yMovement = 0;
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			xMovement -= World.TILE_WIDTH;
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			xMovement += World.TILE_WIDTH;
		}
		if (input.isKeyPressed(Input.KEY_UP)) {
			yMovement -= World.TILE_HEIGHT;
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			yMovement += World.TILE_HEIGHT;
		}

		move(xMovement, yMovement);		
	}
	
	/** Moves a Player's location
	 * @param dx Change in x position
	 * @param dy Change in y position
     */
	@Override
	public void move(float dx, float dy) {
		float newX = getX() + dx;
		float newY = getY() + dy;
		// check if x movement is within screen
		if (newX + getWidth() / 2 <= App.SCREEN_WIDTH &&
			newX - getWidth() / 2 >= 0) {
			setX(newX);
		}
		// check if y movement is within screen
		if (newY + getHeight() / 2 <= App.SCREEN_HEIGHT &&
			newY - getHeight() / 2 >= 0) {
			setY(newY);
		}
	}
}
