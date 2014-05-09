package me.allman_dev.MyGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class menuScreen implements Screen {
	
	MyGame game;
	OrthographicCamera camera;
	SpriteBatch batch;
	BitmapFont font;
	float y;
	int numSelected;
	
	public menuScreen (MyGame game){
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(true,1920,1080);
		batch = new SpriteBatch();
		font = new BitmapFont(true);
		font.scale(3f);
		font.setColor(Color.BLACK);
		numSelected = 0;
		y = 800;
	}

	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		generalUpdate();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			//this is the rendering code.
			font.draw(batch, "Egg Catch", 1620, 650);
			font.draw(batch, "Play", 1770, 800);
			font.draw(batch, "Exit", 1770, 900);
			font.draw(batch, ">", 1690, y);
			
		
		batch.end();
	}

	public void generalUpdate(){
		
		if((Gdx.input.isKeyPressed(Keys.S) && numSelected == 0) || (Gdx.input.isKeyPressed(Keys.DOWN) && numSelected == 0)){
			numSelected = 1;
		}
		
		if((Gdx.input.isKeyPressed(Keys.W) && numSelected == 1)|| (Gdx.input.isKeyPressed(Keys.UP) && numSelected == 1)){
			numSelected = 0;
		}
		
		if(numSelected == 0) y=800;
		else if(numSelected == 1) y=900;
		
		if(((numSelected == 0) && Gdx.input.isKeyPressed(Keys.ENTER)) || ((numSelected == 0) && Gdx.input.isKeyPressed(Keys.SPACE))) game.setScreen(game.gameScreen); this.dispose();
		if(((numSelected == 1) && Gdx.input.isKeyPressed(Keys.ENTER)) || ((numSelected == 1) && Gdx.input.isKeyPressed(Keys.SPACE))) System.exit(0);
		
	}
	
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void dispose() {
		
		
	}

}
