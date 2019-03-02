package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameApp;

public class MenuState implements Screen {
    private OrthographicCamera cam;

    private Texture background;
    private Texture playBtn;

    final GameStateManager gsm;

    public MenuState(GameStateManager gsm) {

        this.gsm = gsm;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 800, 450);

        background = new Texture("background.png");
        playBtn = new Texture("playbtn.png");
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float dt) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();
        gsm.sb.setProjectionMatrix(cam.combined);
        gsm.sb.begin();
        gsm.sb.draw(background, 0, 0, GameApp.WIDTH, GameApp.HEIGHT);
        gsm.sb.draw(playBtn, (GameApp.WIDTH - playBtn.getWidth()) / 2 , GameApp.HEIGHT / 2);
        gsm.sb.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
