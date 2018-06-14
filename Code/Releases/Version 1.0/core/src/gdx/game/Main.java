package gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.Random;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	SprMario sprMario;
    SprGoomba sprGoomba;
    SprPowerup sprPowerupGrowth;
    SprPowerup sprPowerupInvincibility;
    SprPowerup sprPowerupSpeed;
    SprRectangle sprRectangle;
    Texture teximg;
    TextureRegion texbackgroundTexture;
    Random rand1 = new Random();
    Random rand2 = new Random();
    double dYspeedM;
    double dYspeedP;
    int n = rand1.nextInt(5000) + 1;
    double d = rand2.nextInt(1001) / 1000;


	@Override
	public void create () {
		batch = new SpriteBatch();
        sprMario= new SprMario(60,95,50,50);
        sprGoomba=new SprGoomba(690,700,600,50);
        sprPowerupGrowth=new SprPowerup(600, 50, "Growth_power_up.png");
        sprPowerupInvincibility=new SprPowerup(600, 50, "Invincibility_power_up.png");
        sprPowerupSpeed=new SprPowerup(600, 50, "speed_power_up.png");
        sprRectangle=new SprRectangle(600, 250, "Platform for computer science_-1_.png");
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
            dYspeedM=10;
            sprMario.setY(sprMario.getY() +8);
        }
        if(sprMario.getY()>50){
            dYspeedM-=1;
            sprMario.translateY((float) dYspeedM);
        }
        //Mario Bounds
        if(sprMario.getY()>Gdx.graphics.getHeight()-sprMario.getHeight()){
            sprMario.setY(Gdx.graphics.getHeight()-sprMario.getHeight());
        }
        if(sprMario.getY()<50){
            sprMario.setY(50);
        }
        if(sprMario.getX()>Gdx.graphics.getWidth()-sprMario.getWidth()){
            sprMario.setX(Gdx.graphics.getWidth()-sprMario.getWidth());
        }
        if(sprMario.getX()<0){
            sprMario.setX(0);
        }

        //Goomba sliding
        sprGoomba.setX(sprGoomba.getX()-2);
        if(sprGoomba.getX()==-sprGoomba.getWidth()){
            sprGoomba.setX(Gdx.graphics.getWidth());
        }

        //Platform sliding
        sprRectangle.setX(sprRectangle.getX()-1);
        if(sprRectangle.getX()==-sprRectangle.getWidth()){
            sprRectangle.setX(Gdx.graphics.getWidth());
        }

        n++;
        //Growth Powerup spawning
        sprPowerupGrowth.setX(sprPowerupGrowth.getX() -5);
        if(n%1400==0){
            sprPowerupGrowth.setX(600);
        }

        //Invincibility Powerup spawning
        sprPowerupInvincibility.setX(sprPowerupInvincibility.getX() -6);
        if(n%2963==0){
            sprPowerupInvincibility.setX(600);
        }

        //Speed Powerup spawning
        sprPowerupSpeed.setX(sprPowerupSpeed.getX() -5);
        if(n % 2129 == 0){
            sprPowerupSpeed.setX(600);
        }

        batch.begin();
        batch.draw(texbackgroundTexture, 0, 0);
        sprPowerupGrowth.draw(batch);
        sprPowerupInvincibility.draw(batch);
        sprPowerupSpeed.draw(batch);
        sprRectangle.draw(batch);
        sprMario.draw(batch);
        sprGoomba.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }   //Kieran's final project
}
