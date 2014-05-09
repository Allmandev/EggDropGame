package me.allman_dev.MyGame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Basket {
	

	private Texture textureBasket;
	private Sprite spriteBasket;

	private Rectangle bounds;
	
	
	double x,y,centerX;
	
	public Basket(){
		x = 960 - 128;
		y = 800;
		bounds = new Rectangle((float)x, (float)y + 145, 256, 30 );
	}
	
	public void load(){
		textureBasket = new Texture(Gdx.files.internal("img/basket.png"));
		spriteBasket = new Sprite(textureBasket);
		spriteBasket.flip(false,  true);
		
	}
	
	
	
	public void Render(SpriteBatch batch){
		batch.draw(spriteBasket, (float)x, (float)y);
	}
	
	public void update(Vector3 touch, OrthographicCamera camera){
		
		if(Gdx.input.isTouched()){
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			x = touch.x-128;
			bounds.x = touch.x -128;
		}
		
	}

	
	public Rectangle getBounds(){
		return bounds;
	}
}
