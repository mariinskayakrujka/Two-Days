package ru.two.days;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.MathUtils;
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
            sg.setScreen(new RoomOfRuna(sg));
            g.isGameStart = true;
            g.timeStart = TimeUtils.millis();
        }catch (NullPointerException ignored){}
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
