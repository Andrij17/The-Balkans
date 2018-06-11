package mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture teximgPTF;
	Texture teximgBG;
	TextureRegion texbackgroundTexture;
	Sprite sprPlatfrom;



	@Override
	public void create () {
		batch = new SpriteBatch();
		teximgBG = new Texture("background.jpg");
		teximgPTF = new Texture("Platform for computer science_-1.png");
		sprPlatfrom= new Sprite (teximgPTF);
		texbackgroundTexture = new TextureRegion(new Texture("background.jpg"), 0, 0, 640, 500);
        sprPlatfrom.setPosition(320, 250);

 	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(texbackgroundTexture, 0, 0);
		batch.draw(texbackgroundTexture, 0, Gdx.graphics.getHeight());
        batch.draw(sprPlatfrom, 320, 250);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		teximgBG.dispose();
		// I've used this site to help me with setting a image as a background https://stackoverflow.com/questions/25468270/libgdx-how-do-i-add-a-background-image?rq=1
	}
}
