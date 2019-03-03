package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.GameApp;

public class MenuState implements Screen {

    private OrthographicCamera cam;

    private Texture background;
    private Texture playBtn;


    final GameStateManager game;

    public MenuState(GameStateManager game) {

        this.game = game;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, GameApp.WIDTH / 2, GameApp.HEIGHT / 2);

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
        game.sb.setProjectionMatrix(cam.combined);

        game.sb.begin();
        game.sb.draw(background, cam.position.x - (cam.viewportWidth / 2), 0, GameApp.WIDTH, GameApp.HEIGHT);
        game.sb.draw(playBtn, (cam.viewportWidth - playBtn.getWidth()) / 2 , (cam.viewportHeight - playBtn.getHeight()) / 2);
        game.sb.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new PlayState(game));
            dispose();
        }
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
        background.dispose();
        playBtn.dispose();
    }
}
