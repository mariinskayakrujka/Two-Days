package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public class Hall extends ScreenGame {
    Objects doorPrincipal, doorLeft, door, doorRight;
    List<String> talkWithKaiden = new ArrayList<>();
    Texture[] imgBG = new Texture[5];
    int numberOfHalls = 0;
    boolean talkingKai = true, isClassroom;

    public Hall(TwoDays context) {
        super(context);
        /*imgBG = new Texture("Hall0.png");
        kaiObj = new Objects();
        наполнение листа, текстур
        */
    }

    public void render(float delta) {
        /*if (!talkingKai) {
            if (tt.phrase.equals("") && gg.touch.x != runa.getX() && gg.touch.x != 0)
                runa.moveForRuna(gg.touch.x);
        }
        //события при выходе из комнаты в первый раз
        if (talkingKai) {
            outputText(talkWithKaiden);
            if (count == 0) {
                talkingKai = false;
                numberOfHalls = 1;
            }
        } else {
            //основные события игры
            if (Gdx.input.justTouched()) {
                gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                gg.camera.unproject(gg.touch);
                if (!talkWithKaiden.contains(tt.phrase)) tt.phrase = "";
                if (runa.getX() < END_OF_SCREEN_LEFT && numberOfHalls < 4) {
                    numberOfHalls++;
                    runa.x = 400;
                    isClassroom = false;
                } else if (numberOfHalls == 4) isClassroom = true;
                else if (runa.getX() > END_OF_SCREEN_LEFT && numberOfHalls > 1) {//игрок никогда не вернется к кайден
                    numberOfHalls--;
                    runa.x = 1700;
                    isClassroom = false;
                }
                if (gg.touch.x ){
                    // runa.moveForRuna(gg.touch.x);
                    if(isClassroom) gg.setScreen(gg.classroom);
                    else outputText("Р: Не лучшая идея вламываться к кому-то посреди урока");
                }
                if ( gg.touch.y < // && gg.touch.y > // && gg.touch.x >// &&
                    gg.touch.x <//&& numberOfHalls == 5){
                    gg.setScreen(gg.classroom);
                }
                isThreeMinutes();
                times();
    }
}
                //отрисовка
                gg.camera.update();
                gg.batch.setProjectionMatrix(gg.camera.combined);
                gg.batch.begin();
                gg.batch.draw(imgBG[numberOfHalls],0,0,SCR_WIDTH,SCR_HEIGHT);
                if(runa.isWalking){
                changePose();
                gg.batch.draw(texR,runa.getX(),runa.getY(),texR.getWidth(),texR.getHeight(),0,0,1280,1280,!runa.isFlip(),false);
                }else gg.batch.draw(texRuna[4],runa.getX(),runa.getY());//спокойствие
                gg.font.draw(gg.batch,tt.phrase,tt.getX(),tt.getY());
                gg.batch.end();

                }*/
    }
}