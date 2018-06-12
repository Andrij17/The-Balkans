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
    SprPowerup sprPowerup;
    Texture teximg;
    TextureRegion texbackgroundTexture;
    double dYspeed;

	@Override
	public void create () {
		batch = new SpriteBatch();
        sprMario= new SprMario(80,135,50,50);
        sprGoomba=new SprGoomba(690,700,600,50);
        sprPowerup=new SprPowerup(0, 0, "Growth_power_up.png");
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
            sprMario.setY(sprMario.getY() +8);
        }
        if(sprMario.getY()>50){
            dYspeed-=1;
            sprMario.translateY((float) dYspeed);
        }
        //Bounds
        if(sprMario.getY()>Gdx.graphics.getHeight()-sprMario.getHeight()){
            sprMario.setY(Gdx.graphics.getHeight()-sprMario.getHeight());
        }
        if(sprMario.getX()>Gdx.graphics.getWidth()-sprMario.getWidth()){
            sprMario.setX(Gdx.graphics.getWidth()-sprMario.getWidth());
        }
        if(sprMario.getX()<0){
            sprMario.setX(0);
        }
        if(sprGoomba.getX()==-60){
            sprGoomba.setX(Gdx.graphics.getWidth());
        }

        //Goomba sliding
        sprGoomba.setX(sprGoomba.getX() -2);

        batch.begin();
        //Background
        batch.draw(texbackgroundTexture, 0, 0);
        sprPowerup.draw(batch);
        sprMario.draw(batch);
        sprGoomba.draw(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }   //Kieran's final project
}
