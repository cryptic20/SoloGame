package tile_maps;

import java.awt.Graphics2D;
import java.awt.image.*;
import javax.imageio.ImageIO;

import panel.GamePanel;


public class Background {


	private BufferedImage image;
	private double x;
	private double y;
	private double dx;
	private double dy;
	private double moveScale;
	/**
	 * 
	 * @param s Image path from resources.
	 * @param ms Move Scale amount (double).
	 */
	public Background(String s, double ms) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(s));
			moveScale = ms;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void setPosition(double x, double y) {
		this.x = (x * moveScale) % GamePanel.WIDTH;
		this.y = (y * moveScale) % GamePanel.HEIGHT;
	}
	
	/**
	 * 
	 * @param dx Move the x-axis by pixel amount.
	 * @param dy Move the y-axis by pixel amount.
	 */
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public void update() {
		this.x = (x + dx) % GamePanel.WIDTH;
		this.y = (y + dy) % GamePanel.WIDTH;
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, (int)x, (int)y, null);
		if(x < 0) {
			g.drawImage(image,(int)x + GamePanel.WIDTH, (int)y, null);
		}
		if(x > 0) {
			g.drawImage(image,(int)x - GamePanel.WIDTH, (int)y, null);
		}
		
	}
}

