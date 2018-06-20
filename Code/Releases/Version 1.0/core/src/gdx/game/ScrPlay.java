package gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.Random;



public class ScrPlay implements Screen, InputProcessor {
    SpriteBatch batch;
    MarioGame marioGame;
    OrthographicCamera oc;
    SprMario sprMario;
    SprGoomba sprGoomba;
    SprPowerup sprPowerupGrowth;
    SprPowerup sprPowerupInvincibility;
    SprPowerup sprPowerupSpeed;
    SprRectangle sprRectangle;
    SprRectangle btnPlay;
    Texture teximg;
    TextureRegion texbackgroundTexture;
    Random rand1 = new Random();
    Random rand2 = new Random();
    double dYspeedM;
    double dYspeedP;
    int n = rand1.nextInt(5000) + 1, nLives=17;
    double d = rand2.nextInt(1001) / 1000;
    boolean isTouching=false;


    public
    ScrPlay(MarioGame _marioGame) {  //Referencing the main class.
        marioGame = _marioGame;
    }

    @Override
    public void show () {
        batch = new SpriteBatch();
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        sprMario= new SprMario(60,95,50,50);
        sprGoomba=new SprGoomba(55,45,600,50);
        sprPowerupGrowth=new SprPowerup(600, 50, "Growth_power_up.png");
        sprPowerupInvincibility=new SprPowerup(600, 50, "Invincibility_power_up.png");
        sprPowerupSpeed=new SprPowerup(600, 50, "speed_power_up.png");
        sprRectangle=new SprRectangle(180,90,600, 200, "Platform for computer science_-1_.png");
        teximg = new Texture("background.jpg");
        texbackgroundTexture = new TextureRegion(new Texture("background.jpg"), 0, 0, 640, 500);
    }

    @Override
    public void render (float delta) {
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
        if(sprGoomba.getX()==0){
            sprGoomba.setX(600);
        }

        n++;
        //Platform sliding
        sprRectangle.setX(sprRectangle.getX()-1);
        if(n%630==0){
            sprPowerupInvincibility.setX(600);
        }


        //Growth Powerup spawning
        sprPowerupGrowth.setX(sprPowerupGrowth.getX() -5);
        if(n%14000==0){
            sprPowerupGrowth.setX(600);
        }

        //Invincibility Powerup spawning
        sprPowerupInvincibility.setX(sprPowerupInvincibility.getX() -6);
        if(n%29630==0){
            sprPowerupInvincibility.setX(600);
        }


        //Speed Powerup spawning
        sprPowerupSpeed.setX(sprPowerupSpeed.getX() -5);
        if(n % 21290 == 0){
            sprPowerupSpeed.setX(600);
        }

        //Hit detection with goomba on side
        if (isHitS(sprMario, sprGoomba) && Math.abs(sprMario.getY()-sprGoomba.getY())<50 && Math.abs(sprMario.getX()-sprGoomba.getX())>50) {
            nLives-=1;
            System.out.println("Lives:"+nLives);
        }

        //Hit detection with goomba on top
        if (isHitS(sprMario, sprGoomba) && Math.abs(sprMario.getX()-sprGoomba.getX())<50){
            sprGoomba.setPosition(700, 50);
        }

        //Hit detection with platform
        if (isHitS(sprMario, sprRectangle)){
            sprMario.setY(sprRectangle.getY()+sprRectangle.getHeight());
        }

        if(nLives<0){
            marioGame.updateState(2);
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
    public void resize(int width, int height) {
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        batch.dispose();
    }   //Kieran's final project
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            if (isHitB(screenX, screenY, btnPlay)) {
                System.out.println("Hit Play");
                marioGame.updateState(1);
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    public boolean isHitB(int nX, int nY, Sprite sprBtn) {
        if (nX > sprBtn.getX() && nX < sprBtn.getX() + sprBtn.getWidth() && nY > sprBtn.getY() && nY < sprBtn.getY() + sprBtn.getHeight()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isHitS(Sprite spr1, Sprite spr2) {
        return spr1.getBoundingRectangle().overlaps(spr2.getBoundingRectangle());
    }

}
