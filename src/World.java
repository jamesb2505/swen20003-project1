import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Input;

public class World {
	/** Tile width (px) */
	public static final float TILE_WIDTH = 48;
	/** Tile height (px) */
	public static final float TILE_HEIGHT = 48;

	/** Player image source */
	private static final String PLAYER_SRC = "assets/frog.png";
	/** Grass image source */
	private static final String GRASS_SRC = "assets/grass.png";
	/** Water image source */
	private static final String WATER_SRC = "assets/water.png";
	/** Bus image source */
	private static final String BUS_SRC = "assets/bus.png";

	/** Initial Player x coordinate */
	private static final float PLAYER_X = 512;
	/** Initial Player y coordinate */
	private static final float PLAYER_Y = 720;
	/** Y coordinates of the rows of Grass */
	private static final float[] GRASS_ROWS = {384, 672};
	/** Start y coordinate of the rows of Water  */
	private static final float WATER_START = 96;
	/** End y coordinate of the rows of Water */
	private static final float WATER_END = 336;
	/** Parameters for the rows of Buses. Format: {offset, y, separation} */
	private final static float[][] BUS_ROWS = {{48,  432, 6.5F}, 
											   {0,   480, 5},
											   {64,  528, 12},
											   {128, 576, 5},	
											   {250, 624, 6.5F}};
	/** Speed of Buses */
	private static final float BUS_SPEED = 0.15F;

	/** World's Player */
	private Player player;
	/** Stores all Sprites, excluding Player */
	private ArrayList<Sprite> sprites;
	
	/** Constructs a World 
	 * @throws SlickException
	 */
	public World() 
			throws SlickException {
		// Perform initialisation logic
		
		// create Player
		player = new Player(PLAYER_SRC, PLAYER_X, PLAYER_Y);
		
		// create Sprites
		sprites = new ArrayList<Sprite>();
		float maxX = App.SCREEN_WIDTH + TILE_WIDTH / 2;
		
		// create Grass
		for (float y : GRASS_ROWS) {
			// fill width of screen
			for (float x = TILE_WIDTH / 2; x <= maxX; x += TILE_WIDTH) {
				sprites.add(new Grass(GRASS_SRC, x, y));
			}
		}
		
		// create Water
		for (float y = WATER_START; y <= WATER_END; y += TILE_HEIGHT) {
			// fill width of screen
			for (float x = TILE_WIDTH / 2; x <= maxX; x += TILE_WIDTH) {
				sprites.add(new Water(WATER_SRC, x, y));
			}
		}
		
		// create Busses
		float speed = BUS_SPEED;
		for (float[] busRow : BUS_ROWS) {
			// alternate direction of speed
			speed *= -1;
			
			float offset = busRow[0], y = busRow[1], separation = busRow[2] * TILE_WIDTH;
			// fill width of screen
			for (float x = offset; x <= maxX; x += separation) {
				sprites.add(new Bus(BUS_SRC, x, y, speed));
			}
		}
	}
	
	/** Updates all Sprites in the World
     * @param input The Slick input object
     * @param delta Time passed since last update (ms)
     */
	public void update(Input input, int delta) {
		// Update all of the sprites in the game
		for (Sprite sprite : sprites) {
			sprite.update(input, delta);
			// check for contact with player
			sprite.contactSprite(player);
		}
		player.update(input, delta);
	}
	
	/** Renders all Sprites in the World
     * @param g The Slick Graphics object
     */
	public void render(Graphics g) {
		for (Sprite sprite : sprites) {
			sprite.render();
		}
		player.render();
	}
}
