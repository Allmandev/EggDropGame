package me.allman_dev.MyGame;

import java.util.Random;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Egg {
	

	
	private Sprite spriteEgg;
	private Random r;
	private GameScreen game;
	private double fallSpeed = 10;
	double x,y;
	private boolean hasTouched;
	private Rectangle bounds;
	MyGame myGame;
	private int WORTH;
	ImageLoader io;
	private boolean isGold;
	
	public Egg(double d, double e){
		x = d;
		y = e;
	}
	
	public Egg(int i, GameScreen game, MyGame myGame){
		io = new ImageLoader();
		r = new Random();
		x = r.nextInt(1920 - 300) + i*60;
		y = -r.nextInt(1080) - (i * 600) / (game.SCORE + 1);
		this.game = game;
		bounds = new Rectangle((float)x, (float)y + 108, 128, 20);
		hasTouched = false;
		this.myGame = myGame;
	}
	
	public int getWorth(){
		return WORTH;
	}
	
	public void setWorth(int worth){
		this.WORTH = worth;
	}
	
	public Sprite getSpriteEgg(){
		return spriteEgg;
	}
	
	public void setSpriteEgg(Sprite sprite){
		this.spriteEgg = sprite;
	}
	
	public void Render(SpriteBatch batch){

		batch.draw(spriteEgg, (float)bounds.x, (float)bounds.y);
	}
	
	public void update(){
		bounds.y += fallSpeed;
		if(bounds.y >= 1080){
			bounds.x = r.nextInt(1920 - 300) + r.nextInt(5)*60;
			bounds.y -= r.nextInt(1500) + 1080;
			game.miss.play();
			myGame.minusLives();
		}
		
		if(game.SCORE > 25){
			fallSpeed = (game.SCORE / 4.38)* 100 /60;
		}
		
		if(game.SCORE > 67){
			fallSpeed = 24; 
		}
	}
	
	public double getY(){
		return y;
	}
	
	public Rectangle getBounds(){
		return bounds;
	}
	
	public boolean getHasTouched(){
		return hasTouched;
	}
	
	public void setHasTouched(boolean touch){
		this.hasTouched = touch;
	}
	
	public float setBoundsX(){
		this.bounds.x = r.nextInt(1920 - 300) + r.nextInt(5)*60;
		return bounds.x;
	}
	
	public float setBoundsY(){
		if(!getIsGold()){
			this.bounds.y -= r.nextInt(1500) + 1080;
		} else {
			this.bounds.y -= r.nextInt(10000) + 6000;
		}
		return bounds.y;
	}
	
	public boolean getIsGold(){
		return isGold;
	}
	
	public void setIsGold(boolean isGold){
		this.isGold = isGold;
	}
	
	
	
	
}
