package graficProject.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.awt.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends Game implements ApplicationListener {
    Texture backgroundTexture;
    Texture pnjTexture;
    Texture backgroundRoots;
    Sprite spritePnj;

    SpriteBatch spriteBatch;
    FitViewport viewport;

    @Override
    public void create()
    {
        setScreen(new FirstScreen());
        backgroundTexture = new Texture("textures/fondo_espacio.jpg");
        backgroundRoots = new Texture("textures/fondo_raices.jpg");
        pnjTexture = new Texture("textures/stick_man.png");
        spritePnj = new Sprite(pnjTexture);
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8, 5);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true); // true centers the camera
    }

    @Override
    public void render()
    {
        input();
        logic();
        draw();
    }

    private void input()
    {
        float speed = 0.25f;
        float delta = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            spritePnj.translateX(speed * delta);
        }
    }

    private void logic()
    {

    }

    private void draw() {
        ScreenUtils.clear(Color.WHITE);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        spriteBatch.draw(backgroundRoots, 0, 0, worldWidth, worldHeight);
        //spriteBatch.draw(pnjTexture, 2, 1, 1, 2);
        spritePnj.draw(spriteBatch); // Sprites have their own draw method


        spriteBatch.end();
    }
}
