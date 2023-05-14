package ru.two.days;

import static ru.two.days.TwoDays.isGameStart;
import static ru.two.days.TwoDays.timeStart;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.TimeUtils;


public class Between implements Screen {

    TwoDays gg;
    Between(TwoDays context){
        gg = context;
    }
    @Override
    public void show() {
        try {
            gg.setScreen(gg.roomOfRuna);
            isGameStart = true;
            timeStart = TimeUtils.millis();
        }catch (NullPointerException ignored){}
    }

    @Override
    public void render(float delta) {}

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
