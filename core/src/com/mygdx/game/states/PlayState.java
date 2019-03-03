package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameApp;
import com.mygdx.game.sprites.Corgi;

public class PlayState implements Screen {
    private Corgi corgi;

    private OrthographicCamera cam;

    private Texture background;

    final GameStateManager game;

    public PlayState(GameStateManager game) {
        this.game = game;
        corgi = new Corgi(80, 35);

        cam = new OrthographicCamera();
        cam.setToOrtho(false, GameApp.WIDTH / 2, GameApp.HEIGHT / 2);

        background = new Texture("background.png");

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

        corgi.stateTime += Gdx.graphics.getDeltaTime();

        TextureRegion currentFrame = corgi.getAnimation().getKeyFrame(corgi.stateTime, true);

        game.sb.begin();
        game.sb.draw(background, cam.position.x - (cam.viewportWidth / 2), 0, GameApp.WIDTH, GameApp.HEIGHT);
        if (corgi.getPosition().y > 35) {
            game.sb.draw(corgi.getSprite(), corgi.getPosition().x, corgi.getPosition().y, 40, 40);
        } else {
            game.sb.draw(currentFrame, corgi.getPosition().x, corgi.getPosition().y, 40, 40);
        }
        game.sb.end();

        if (Gdx.input.isTouched()) {
            corgi.jump();
        }
        corgi.update(dt);
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
