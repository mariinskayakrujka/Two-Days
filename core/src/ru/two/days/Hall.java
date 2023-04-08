package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public class Hall extends ScreenGame {
    Objects kaiObj;
    List<String> talkWithKaiden;
    Texture imgBG;
    int numberOfHalls;
    boolean talking;
    public Hall(TwoDays context) {
        super(context);
        //imgBG = new Texture("Hall0.png");
        //kaiObj = new Objects();
        //наполнение листа

    }

    public void render(float delta) {
            //основные события игры

        /* if(Gdx.input.justTouched() ) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            if (gg.touch.y < 120 && gg.touch.y > 90) {
                runa.moveForRuna(gg.touch.x); //передвижение Руны
            }
            if(kaiObj.hit(gg.touch.x, gg.touch.y)){
                runa.moveForRuna(gg.touch.x);
                outputText(talkWithKaiden);
            }
            if(gg.touch.x < // && gg.touch.x > //){
               runa.moveForRuna(gg.touch.x);
                outputText("Р: Не лучшая идея вламываться к кому-то посреди урока");
            }
            if (gg.touch.y < 120 && gg.touch.y > 90 && gg.touch.x >= END_OF_SCREEN_RIGHT && numberOfHalls < 5){
                imgBG = new Texture("Hall" + numberOfHalls + ".png");
                numberOfHalls += 1;
            }
            if (gg.touch.y < // && gg.touch.y > // && gg.touch.x >// &&
                    gg.touch.x <//&& numberOfHalls == 5){
                gg.setScreen(gg.classRoom);
            }
            if (gg.touch.y < 120 && gg.touch.y > 90 && gg.touch.x <= END_OF_SCREEN_LEFT && numberOfHalls > -1){
                imgBG = new Texture("Hall" + numberOfHalls + ".png");
                numberOfHalls -= 1;
            }

            isThreeMinutes();

        }

        //отрисовка
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        if(numberOfHalls == 0 && !talking) {
            //gg.batch.draw("kaiden0.png", );
            //изменения мимики персов во время разговора
            talking = true;
        }
        gg.font.draw(gg.batch, tt.phrase, tt.getX(), tt.getY());
        gg.batch.end();*/

    }
}
