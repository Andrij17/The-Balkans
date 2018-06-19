package gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprGoomba extends Sprite {
    public SprGoomba(int nW, int nH, int nX, int nY){
        super(new Texture(Gdx.files.internal("Goomba_edited-1.png"))); //Kieran's final project
        setSize(nW, nH);
        setPosition(nX, nY);
        setFlip(false, false);
    }
}
