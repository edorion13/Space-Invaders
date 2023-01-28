public class Player extends Mover {
int health;
	public Player(double x,double y) {
		super(x,y,100,100,0,0, "Peppa_Pig.png");
		health = 5;
	}
	public void setHealth(int h) {
		this.health = h;
	}
	public int getHealth() {
		return health;
	}
	public void goLeft() {
		xVel = -5;
	}
	public void goRight() {
		xVel = 5;
	}
	public void stop() {
		xVel = 0;
	}
	public void receiveDamage(int damage) {
		health = health-damage;
	}
}
