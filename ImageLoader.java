package me.allman_dev.MyGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ImageLoader {
	
	public Sprite setSprite(String path){
		Texture text = new Texture(Gdx.files.internal(path));
		Sprite sprite = new Sprite(text);
		sprite.flip(false,  true);
		return sprite;
		
	}

}
