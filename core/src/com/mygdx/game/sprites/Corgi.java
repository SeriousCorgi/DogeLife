package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;


public class Corgi {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 50;

    private Vector3 position;
    private Vector3 velocity;

    private Animation<TextureRegion> corgiAni;
    private Texture corgi_move;
    private Texture corgi;
    private TextureRegion[] corgiFrames;

    private Sprite corgiSp;
    public float stateTime;


    public Corgi(int x, int y) {
        // Corgi position
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);

        // Corgi sprite when jumping
        corgi_move = new Texture("corgi-move.png");
        corgiSp = new Sprite(corgi_move);

        // Corgi walking animation
        corgi = new Texture("corgi-animation.png");
        corgiFrames = new TextureRegion[2];
        corgiFrames[0] = new TextureRegion(corgi, 0,0, 395, 438);
        corgiFrames[1] = new TextureRegion(corgi, 395,0, 415, 438);

        corgiAni = new Animation<TextureRegion>((float) 0.2, corgiFrames);
        stateTime = 0f;
    }

    public void update(float dt){
        // Apply gravity when jumping and add horizontal movement
        if (position.y > 35) {
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);

        // Put Corgi on the ground
        if (position.y < 35) {
            position.y = 35;
        }


        velocity.scl(1 / dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public void jump() {
        // Only jump when corgi is on the ground
        if (position.y == 35) {
            velocity.y = 380;
        }
    }

    public Sprite getSprite() { return corgiSp; }

    public Animation<TextureRegion> getAnimation() { return corgiAni; }
}
