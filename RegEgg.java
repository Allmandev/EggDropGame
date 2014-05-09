package me.allman_dev.MyGame;

public class RegEgg extends Egg{

	public RegEgg(int i, GameScreen game, MyGame myGame) {
		super(i, game, myGame);
		this.setWorth(1);
		this.setSpriteEgg(this.io.setSprite("img/egg.png"));
		this.setIsGold(false);
	}

	

}
