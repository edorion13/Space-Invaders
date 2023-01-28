import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;

public class GraphicsPanel extends JPanel implements KeyListener {
	ArrayList<Alien>aliens = new ArrayList<Alien>();
	ArrayList<Bullet>bullets = new ArrayList<Bullet>();
	Player player;
	boolean isPlaying;
	int width, height;
	
	public GraphicsPanel(Dimension size) {
		this.setPreferredSize(size);
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(this);
		this.player = new Player(650, 650);
		loadWave1();
	}
	
	public boolean isPlaying() {
		return isPlaying;
	}
	
	public void loadWave1() {
		for(int i = 0 ; i<9; i++) {
			aliens.add(new greenAlien(100+(150*i),100, 14, 10));
		}	
		for(int i = 0; i<9; i++) {
			aliens.add(new blueAlien(100+(150* i), 250, 14, 10));
		}
	}

	public void refresh() {
		player.move();
		for(int i = 0; i<aliens.size(); i++) {
			aliens.get(i).move();
			if(aliens.get(i).getY()>750) {
				player.receiveDamage(aliens.get(i).getDamage());
				aliens.remove(i);
				System.out.println(player.getHealth());
			}
		}
		for(int i = 0; i< bullets.size(); i++) {
			bullets.get(i).move();
		}
		for(int i = 0; i<aliens.size(); i++) {
			for(int j = 0; j<bullets.size(); j++)
				if (aliens.get(i).contains(bullets.get(j))) {
					aliens.get(i).receiveDamage(bullets.get(j).getDamage());
					bullets.remove(j);
					if(aliens.get(i).getHealth()<=0)
						aliens.remove(i);
			}
		}
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		player.paintSelf(g);
		
		for(int i = 0; i<aliens.size(); i++) {
			aliens.get(i).paintSelf(g);
			
		for(int j = 0; j<bullets.size(); j++)		
			bullets.get(j).paintSelf(g);
		}
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		System.out.println(e);
		if (e.getKeyCode() == 65)
			player.xVel = -5;
		if(e.getKeyCode() == 68)
			player.xVel = 5;
		if(e.getKeyCode() == 39)
			player.xVel = 5;
		if(e.getKeyCode() == 37)
			player.xVel = -5;
		if(e.getKeyCode() == 32) {
			bullets.add(new Bullet(player.getX(), player.getY())); 		
		}
	}
	public void keyReleased(KeyEvent e) {
		player.xVel = 0;
	}
}













