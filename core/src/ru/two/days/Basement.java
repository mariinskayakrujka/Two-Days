package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;
import static ru.two.days.TwoDays.timeCurrent;

import androidx.annotation.NonNull;

import com.badlogic.gdx.graphics.Texture;

public class Basement extends ScreenGame{

    boolean isKeyStage = true;
    Texture[] imgBg = new Texture[2];
    public Basement(@NonNull TwoDays context) {
        super(context);
        for (int i = 0; i < imgBg.length; i++) {
            imgBg[i] = new Texture("basement"+i+".png");
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBg[0], 0, 0, SCR_WIDTH, SCR_HEIGHT);
        gg.font.draw(gg.batch, timeCurrent+"", 200, 600);
        gg.batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        for (Texture texture : imgBg) {
            texture.dispose();
        }
    }
}
