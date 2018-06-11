package gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	SprMario sprMario;
    SprGoomba sprGoomba;
    Texture teximg;
    TextureRegion texbackgroundTexture;
    double dYspeed;

	@Override
	public void create () {
		batch = new SpriteBatch();
        sprMario= new SprMario(90,160,50,50);
        sprGoomba=new SprGoomba(690,700,600,50);
        teximg = new Texture("background.jpg");
        texbackgroundTexture = new TextureRegion(new Texture("background.jpg"), 0, 0, 640, 500);
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
        if(sprGoomba.getX()==-60){
            sprGoomba.setX(600);
        }


        batch.begin();
        //Background
        batch.draw(texbackgroundTexture, 0, 0);
        batch.draw(texbackgroundTexture, 0, Gdx.graphics.getHeight());

        //Goomba sliding
        sprGoomba.setX(sprGoomba.getX() -2);
        sprMario.draw(batch);
        sprGoomba.draw(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }   //Kieran's final project
}
