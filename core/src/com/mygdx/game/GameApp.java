package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.states.GameStateManager;

public class GameApp extends ApplicationAdapter {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 450;

    public static final String TITLE = "Doge Life";
	GameStateManager game;

	@Override
	public void create () {
		game = new GameStateManager();
		game.create();
	}

	@Override
	public void render () { game.render(); }
	
	@Override
	public void dispose () {
		game.dispose();
	}
}
