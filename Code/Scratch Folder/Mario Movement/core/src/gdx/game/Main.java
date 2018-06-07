package gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img1;
    Sprite sprMstanding;
    double dYspeed;


    @Override
	public void create () {
        batch = new SpriteBatch();
        img1 = new Texture("MStanding.png");
        sprMstanding = new Sprite (img1);
        sprMstanding.setPosition(50, 50);
        sprMstanding.setScale(1f);
    }

	@Override
	public void render () {

        //Mario keyboard control
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            sprMstanding.translateX(-4f);
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            sprMstanding.translateX(4f);
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            dYspeed=10;
            sprMstanding.translateY(10f);
        }
        if(sprMstanding.getY()>50){
            dYspeed-=1;
            sprMstanding.translateY((float) dYspeed);
        }
        if(sprMstanding.getY()>400){
            sprMstanding.setY(400);
        }

        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //draw Mario




        batch.draw(sprMstanding, sprMstanding.getX(),  sprMstanding.getY(),sprMstanding.getWidth()/2,sprMstanding.getHeight()/2,
                sprMstanding.getWidth(),sprMstanding.getHeight(),sprMstanding.getScaleX(),sprMstanding.getScaleY(),sprMstanding.getRotation());


        batch.end();


    }
	
	@Override
	public void dispose () {
		batch.dispose();
		img1.dispose();
	}
}
