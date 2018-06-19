package gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprPowerup extends Sprite {
    public SprPowerup(int nX, int nY, String sFilename){
        super(new Texture(Gdx.files.internal(sFilename))); //Kieran's final project
        setPosition(nX, nY);
        setFlip(false, false);
    }
}
