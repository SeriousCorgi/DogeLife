package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;

public class GameApp extends ApplicationAdapter {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 450;

    public static final String TITLE = "Doge Life";
	GameStateManager gsm;

	@Override
	public void create () {
		gsm = new GameStateManager();
		gsm.create();
	}

	@Override
	public void render () {
		gsm.render();
	}
	
	@Override
	public void dispose () {
		gsm.dispose();
	}
}
