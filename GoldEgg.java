package me.allman_dev.MyGame;

public class GoldEgg extends Egg{

	public GoldEgg(int i, GameScreen game, MyGame myGame) {
		super(i, game, myGame);
		this.setWorth(5);
		this.setSpriteEgg(this.io.setSprite("img/goldEgg.png"));
		this.setIsGold(true);
	}

	

}
