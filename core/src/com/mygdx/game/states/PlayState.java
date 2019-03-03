package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameApp;
import com.mygdx.game.sprites.Corgi;

public class PlayState implements Screen {
    private Corgi corgi;

    private OrthographicCamera cam;

    private Texture background;
    private Vector2 bgPos1, bgPos2;

    final GameStateManager game;

    public PlayState(GameStateManager game) {
        this.game = game;
        corgi = new Corgi(60, 35);

        cam = new OrthographicCamera();
        cam.setToOrtho(false, GameApp.WIDTH / 2, GameApp.HEIGHT / 2);

        background = new Texture("background.png");
        bgPos1 = new Vector2(cam.position.x - (cam.viewportWidth / 2),0);
        bgPos2 = new Vector2((cam.position.x - (cam.viewportWidth / 2)) + GameApp.WIDTH, 0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float dt) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Set viewpoint focus on corgi
        updateBg();
        game.sb.setProjectionMatrix(cam.combined);
        cam.position.x = corgi.getPosition().x + 140;
        cam.update();

        // State time for animation
        corgi.stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = corgi.getAnimation().getKeyFrame(corgi.stateTime, true);

        // Begin drawing
        game.sb.begin();

        game.sb.draw(background, bgPos1.x, bgPos1.y, GameApp.WIDTH, GameApp.HEIGHT);
        game.sb.draw(background, bgPos2.x, bgPos2.y, GameApp.WIDTH, GameApp.HEIGHT);

        // Change Corgi display and animation base on position
        if (corgi.getPosition().y > 35) {
            game.sb.draw(corgi.getSprite(), corgi.getPosition().x, corgi.getPosition().y, 40, 40);
        } else {
            game.sb.draw(currentFrame, corgi.getPosition().x, corgi.getPosition().y, 40, 40);
        }

        game.sb.end();
        // End drawing

        if (Gdx.input.justTouched()) {
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
        background.dispose();
    }

    // Take already scrolled through background and put it at the end of the slider
    private void updateBg() {
        if (cam.position.x - (cam.viewportWidth / 2) > bgPos1.x + GameApp.WIDTH) {
            bgPos1.add(GameApp.WIDTH * 2, 0);
        }
        if (cam.position.x - (cam.viewportWidth / 2) > bgPos2.x + GameApp.WIDTH) {
            bgPos2.add(GameApp.WIDTH * 2, 0);
        }
    }
}
