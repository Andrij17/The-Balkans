package gdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;


public class isMarioHit {
    SprMario sprMario;
    SprPowerup sprPowerupGrowth;
    if(isHitMario(sprMario , sprPowerupGrowth;)){
        sprMario.setPosition(sprMario.getX(), sprMario.getY());
    }

        //if(isHitS(sprMario, sprNamAH)){
       // sprAni.setPosition(fSx, fSy);










    public boolean isHitMario(Sprite spr1, Sprite spr2) {
        return spr1.getBoundingRectangle().overlaps(spr2.getBoundingRectangle());



    }
}