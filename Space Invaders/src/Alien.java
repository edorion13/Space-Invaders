import java.awt.*;
import java.util.ArrayList;
public abstract class Alien extends Mover {
	int health, damage;
	int minXBoundary, maxXBoundary; 

	public Alien(double x, double y, String fileName, int minXBoundary, int maxXBoundary, int health, int damage){
		super(x ,y ,100 ,100 ,20 ,0.0 , fileName);
		this.minXBoundary = 0;
		this.maxXBoundary = 1450;
		this.health = health;
		this.damage = damage;
	}
	public int getMinXBoundary(){
		return minXBoundary;
	}
	public void setMinXBoundary(int minXBound) {
		this.minXBoundary = minXBound;
	}
	public int getMaxXBoundary() {
		return maxXBoundary;
	}
	public void setMaxXBoundary(int maxXBound) {
		this.maxXBoundary = maxXBound;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int h) {
		this.health = h;
	}
	public int getDamage() {
		return damage;
	}	
	public void setDamage(int d) {
		this.damage = d;
	}
	public void receiveDamage(int damage) {
		health = health-damage;
	}
	public boolean contains(Bullet b) {
		double distance = Math.hypot((this.getX()-b.getX()),((this.getY()-b.getY())));
		double sumOfRadii = (this.width/2 + b.width/2);
		if(distance<sumOfRadii)
			return true;
		return false;
	}
	public void move() {
		super.move();
		if(x <= minXBoundary || x >= maxXBoundary-100) {
			 xVel = this.xVel*-1;
			 y = this.y+100;
		}
	}
}
