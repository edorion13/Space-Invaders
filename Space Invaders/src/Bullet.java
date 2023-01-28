public class Bullet extends Mover{
	int damage;
	public Bullet(double x, double y) {
		super(x, y, 40, 40, 0, -5, "Ball.png");
		this.damage = 10;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage() {
		this.damage = 10;
	}
}
