package mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import javax.swing.plaf.synth.Region;

public class Stage extends ApplicationAdapter {
	SpriteBatch batch;
	Texture teximg;
	TextureRegion texbackgroundTexture;



	@Override
	public void create () {
		batch = new SpriteBatch();
		teximg = new Texture("background.jpg");
        texbackgroundTexture = new TextureRegion(new Texture("background.jpg"), 0, 0, 640, 500);

	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(texbackgroundTexture, 0, 0);
	    batch.draw(texbackgroundTexture, 0, Gdx.graphics.getHeight());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		teximg.dispose();
        // I've used this site to help me with setting a image as a background https://stackoverflow.com/questions/25468270/libgdx-how-do-i-add-a-background-image?rq=1
	}
}
