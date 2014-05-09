package me.allman_dev.MyGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen {
	
	MyGame game;
	OrthographicCamera camera;
	SpriteBatch batch;
	BitmapFont font;
	Egg eggs[];
	int x, y;
	int SCORE = 0;
	int LIVES;
	Basket basket;
	Vector3 touch;
	public Sound collect, miss, gold;
	Preferences prefs;
	
	public GameScreen (MyGame game, Preferences prefs){
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(true,1920,1080);
		batch=new SpriteBatch();
		eggs= new Egg[6];
		font = new BitmapFont(true);
		font.scale(3.2f);
		font.setColor(Color.BLACK);
		basket = new Basket();
		basket.load();
		for(int i = 0; i < eggs.length; ++i){
			
			if(i < eggs.length - 2){
				eggs[i] = new RegEgg(i, this, game);
			} else {
				eggs[i] = new GoldEgg(i, this, game);
			}
		}

		touch = new Vector3();
		collect = Gdx.audio.newSound(Gdx.files.internal("sounds/collect.wav"));
		miss = Gdx.audio.newSound(Gdx.files.internal("sounds/miss.wav"));
		gold = Gdx.audio.newSound(Gdx.files.internal("sounds/gold.wav"));
		LIVES = game.getLives();
		this.prefs = prefs;
	}

	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		generalUpdate(camera);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			//this is the rendering code.
		for(int i = 0; i< eggs.length - 1;i++){
			eggs[i].Render(batch);
		}
		
		basket.Render(batch);
		font.draw(batch, "Score: " + SCORE, 100, 100);
		font.draw(batch, "Lives: " + game.getLives(), 1600, 100);
		batch.end();
	}

	public void generalUpdate(OrthographicCamera camera){
		for(int i = 0; i< eggs.length - 1;i++){
			eggs[i].update();
		}
		basket.update(touch, camera);
		
		for(int i = 0; i < eggs.length; i++){ //use full because all will collide with basket.
			
			if(eggs[i].getBounds().overlaps(basket.getBounds()) && !eggs[i].getHasTouched()){
				eggs[i].setHasTouched(true);
				if(!eggs[i].getIsGold()){
					collect.play();
				} else {
					gold.play();
				}
				SCORE += eggs[i].getWorth();
				eggs[i].setBoundsX();
				eggs[i].setBoundsY();
				
				eggs[i].setHasTouched(false);
			}
			
		}
		
		if(game.getLives() <= 0){
			game.setGameScore(SCORE);
			saveHighScore(prefs);
			game.setScreen(game.gameOverScreen);
		}
	}
	
	public void saveHighScore(Preferences prefs){
		
		if(game.getGameScore() > game.getHighScore()){
			game.setHighScore(game.getGameScore());
			System.out.println("writing");
			System.out.println(game.getHighScore());
			prefs.putInteger("HighScore", game.getHighScore());
			prefs.flush();
		}
		
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
