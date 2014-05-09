package me.allman_dev.MyGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;



public class MyGame extends Game {

	public GameScreen gameScreen;
	public menuScreen menuscreen;
	public GameOverScreen gameOverScreen;
	private int GAMESCORE, LIVES, HIGHSCORE, DEFAULTLIVES;
	Preferences prefs;

	
	@Override
	public void create() {
		prefs = Gdx.app.getPreferences("High Score");
		gameScreen = new GameScreen(this, prefs);
		menuscreen = new menuScreen(this);
		gameOverScreen = new GameOverScreen(this);
		setScreen(menuscreen);
		GAMESCORE = 0;
		DEFAULTLIVES = 10;
		LIVES = DEFAULTLIVES;
		HIGHSCORE = prefs.getInteger("HighScore");
	}
	
	public void setLives(int lives){
		this.LIVES = lives;
	}
	
	
	public int getLives(){
		return LIVES;
	}
	
	public void minusLives(){
		this.LIVES--;
	}
	public void setGameScore(int score){
		this.GAMESCORE = score;
	}

	public int getGameScore(){
		return GAMESCORE;
	}
	
	public int getHighScore(){
		return HIGHSCORE;
	}
	
	public void setHighScore(int highScore){
		this.HIGHSCORE = highScore;
	}
	
	public int getDefaultLives(){
		return DEFAULTLIVES;
	}
}
