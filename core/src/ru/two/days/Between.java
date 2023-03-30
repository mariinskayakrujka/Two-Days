package ru.two.days;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class Between implements Screen {

    TwoDays sg;
    ScreenGame g;
    @Override
    public void show() {
        sg.setScreen(sg.roomOfRuna);
        g.isGameStart = true;
        g.timeStart = TimeUtils.millis();
    }

    @Override
    public void render(float delta) {

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
