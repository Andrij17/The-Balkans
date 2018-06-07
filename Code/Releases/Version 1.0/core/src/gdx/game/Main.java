package gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	SprMario sprMario;
    SprGoomba sprGoomba;
    double dYspeed;

	@Override
	public void create () {
		batch = new SpriteBatch();
        sprMario= new SprMario(90,160,50,50);
        sprGoomba=new SprGoomba(690,700,600,50);
    }

	@Override
	public void render () {
        //Mario keyboard control
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            sprMario.setX(sprMario.getX() -4);
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            sprMario.setX(sprMario.getX() +4);
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            dYspeed=10;
            sprMario.setY(sprMario.getY() +9);
        }
        if(sprMario.getY()>50){
            dYspeed-=1;
            sprMario.translateY((float) dYspeed);
        }
        if(sprMario.getY()>400){
            sprMario.setY(400);
        }

        //Goomba sliding
        sprGoomba.setX(sprGoomba.getX() -1);

		Gdx.gl.glClearColor(0, 0.498f, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        sprMario.draw(batch);
        sprGoomba.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }   //Kieran's final project
}
