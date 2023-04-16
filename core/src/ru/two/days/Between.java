package ru.two.days;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class Between implements Screen {

    TwoDays sg;
    ScreenGame g;
    Between(TwoDays context){
        sg = context;
    }
    @Override
    public void show() {
        g = new ScreenGame(sg);
        try {
            sg.setScreen(sg.roomOfRuna);
            g.isGameStart = true;
            g.timeStart = TimeUtils.millis();
        }catch (NullPointerException ignored){}
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        sg.camera.update();
        sg.batch.setProjectionMatrix(sg.camera.combined);
        sg.batch.begin();
        sg.font.draw(sg.batch, "Load...", Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sg.batch.end();

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

    }
}
