package mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture txImg;
	Sprite sprGrowth;


	@Override
	public void create () {
		batch = new SpriteBatch();
		txImg = new Texture("cant die.png");
		sprGrowth= new Sprite (txImg);
		sprGrowth.setPosition(Gdx.graphics.getWidth(),0);
		sprGrowth.setScale(1f);


	}

	@Override
	public void render () {
		sprGrowth.translateX(-1f);
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprGrowth.draw(batch);
		batch.end();



	}

	@Override
	public void dispose () {
		batch.dispose();
		txImg.dispose();
	}
}
