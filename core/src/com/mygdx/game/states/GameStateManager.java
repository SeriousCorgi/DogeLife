package com.mygdx.game.states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameStateManager extends Game{

    public MenuState menuState;

    public SpriteBatch sb;


    public void create() {
        sb = new SpriteBatch();
        menuState = new MenuState(this);
        this.setScreen(menuState);
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        sb.dispose();
    }

}
