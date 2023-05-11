package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenAbout implements Screen {
    TwoDays gg;
    Texture imgBG;
    TextButton btnBack;
    String textAbout =  "\"У меня так болела голова, казалось,\n" +
            " она вот-вот треснет пополам, но нет, боль только усиливалась.\n" +
            " К горлу подкатывала мнимая тошнота,\n" +
            "мельтешило в глазах и звенело в ушах.\n" +
            " Это росло понимание,\n" +
            " что есть моя жизнь.\" - Р.М.\n\n\n\n" +

            "Проект создан в IT-школе Samsung\n " +
            "и готов к употреблению:)";


    public ScreenAbout(TwoDays myGG) {
        gg = myGG;
        imgBG = new Texture("img_1.png");
        btnBack = new TextButton(gg.fontLarge, "НАЗАД", 100);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // обработка касаний экрана
        if(Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);

            if(btnBack.hit(gg.touch.x, gg.touch.y)) {
                gg.setScreen(gg.screenIntro);
            }
        }
        // отрисовка всей графики
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        gg.getFont().draw(gg.batch, textAbout, 100, 1000);
        btnBack.font.draw(gg.batch, btnBack.text, btnBack.x, btnBack.y);
        gg.batch.end();
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
        imgBG.dispose();
    }
}

