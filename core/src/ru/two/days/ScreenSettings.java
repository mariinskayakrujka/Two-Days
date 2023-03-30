package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenSettings implements Screen {
    TwoDays c;

    Texture imgBG;

    TextButton btnSound, btnExit;

    public ScreenSettings(TwoDays context){
        c = context;
        // создание изображений
        imgBG = new Texture("img_1.png");
        btnSound = new TextButton(c.fontLarge, "ЗВУК ВКЛ", 650);
        btnExit = new TextButton(c.fontLarge, "НАЗАД", 350);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // обработка касаний экрана
        if(Gdx.input.justTouched()) {
            c.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            c.camera.unproject(c.touch);
            if(btnSound.hit(c.touch.x, c.touch.y)) {
                c.soundOn = !c.soundOn;
                btnSound.setText(c.soundOn ? "ЗВУК ВКЛ" : "ЗВУК ВЫКЛ");
            }
            if(btnExit.hit(c.touch.x, c.touch.y)) {
                c.setScreen(c.screenIntro);
            }
        }
        // отрисовка всей графики
        c.camera.update();
        c.batch.setProjectionMatrix(c.camera.combined);
        c.batch.begin();
        c.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnSound.font.draw(c.batch, btnSound.text, btnSound.x, btnSound.y);
        btnExit.font.draw(c.batch, "НАЗАД", btnExit.x, btnExit.y);
        c.batch.end();
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
