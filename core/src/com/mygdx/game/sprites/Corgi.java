package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;


public class Corgi {
    private static final int GRAVITY = -15;

    private Vector3 position;
    private Vector3 velocity;

    private Animation<TextureRegion> corgiAni;
    private Texture corgi_move;
    private Texture corgi;
    private TextureRegion[] corgiFrames;

    private Sprite corgiSp;
    public float stateTime;


    public Corgi(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);

        corgi_move = new Texture("corgi-move.png");
        corgiSp = new Sprite(corgi_move);

        corgi = new Texture("corgi-animation.png");
        corgiFrames = new TextureRegion[2];
        TextureRegion[][] tmp = TextureRegion.split(corgi, 397, corgi.getHeight() );

        corgiFrames = new TextureRegion[2];
        corgiFrames[0] = tmp[0][0];
        corgiFrames[1] = tmp[0][1];

        corgiAni = new Animation<TextureRegion>((float) 0.2, corgiFrames);
        stateTime = 0f;
    }

    public void update(float dt){
        if (position.y > 35) {
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(dt);
        position.add(0, velocity.y, 0);
        if (position.y < 35) {
            position.y = 35;
        }


        velocity.scl(1 / dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public void jump() {
        if (position.y == 35) {
            velocity.y = 380;
        }
    }

    public Sprite getSprite() {
        return corgiSp;
    }

    public Animation<TextureRegion> getAnimation() {
        return corgiAni;
    }
}
