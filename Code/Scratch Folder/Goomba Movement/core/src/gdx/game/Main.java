package gdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;




public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img2;
	Sprite sprGoomba;


	@Override
	public void create () {
		batch = new SpriteBatch();
		img2 = new Texture("Goomba.png");
        sprGoomba= new Sprite (img2);
        sprGoomba.setPosition(Gdx.graphics.getWidth(),0);
        sprGoomba.setScale(1f);


	}

	@Override
	public void render () {
        sprGoomba.translateX(-1f);
	    Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprGoomba.draw(batch);
        batch.end();



	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img2.dispose();
	}
}
