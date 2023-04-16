package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;

import androidx.annotation.NonNull;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;
import java.util.List;

public class ScreenGame implements Screen {

    TwoDays gg;
    Text tt;
    boolean soundOn = true;
    Sound[] sounds = new Sound[6];
    //Texture texPaper, button, button1;
    Texture[] texRuna = new Texture[16], texKaiden = new Texture[11];
    long timeStart, timeCurrent;

    public static final int END_OF_SCREEN_RIGHT = SCR_WIDTH*190/200,END_OF_SCREEN_LEFT = SCR_WIDTH/10;
    boolean isGameStart;

    boolean isTalking, isReading;

    Texture texK, texR;

    Endings end;

    RunaMilekum runa;
    PoliamSt poliam;
    KaidenMorem kaiden;


    int count;

    public ScreenGame(@NonNull TwoDays context){
        try {

            gg = context;
            tt = new Text(gg.font, "", SCR_WIDTH/4f, SCR_HEIGHT/ 11f);
        /*button = new Texture("button.png");
        button1 = new Texture("button1.png");*/
            runa = new RunaMilekum(SCR_WIDTH / 2f);
            kaiden = new KaidenMorem(SCR_WIDTH / 3f);
            poliam = new PoliamSt(SCR_WIDTH / 20f);
            end = new Endings(this);
            /*end = new Endings(this);
            sounds[0] = Gdx.audio.newSound(Gdx.files.internal("sounds/beg-v-kablukah.mp3"));
            sounds[1] = Gdx.audio.newSound(Gdx.files.internal("sounds/Ringings in ye.mp3"));
            sounds[2] = Gdx.audio.newSound(Gdx.files.internal("sounds/shelest.mp3"));
            sounds[3] = Gdx.audio.newSound(Gdx.files.internal("sounds/WalkingKover.mp3"));
            sounds[4] = Gdx.audio.newSound(Gdx.files.internal("sounds/WalkingRuna.mp3"));
            sounds[5] = Gdx.audio.newSound(Gdx.files.internal("sounds/withoutUn.mp3"));*/
            for (int i = 0; i < texRuna.length; i++) {
                texRuna[i] = new Texture("runa/runa" + i + ".png");
            }
            for (int i = 0; i < texKaiden.length; i++) {
                texKaiden[i] = new Texture("kaiden/kaiden" + i + ".png");
            }

        }catch (NullPointerException ignored){}
        //возможно, перетащить все из рендера

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(isGameStart) {
            timeCurrent = TimeUtils.millis() - timeStart;
        }

    }
    void isThreeMinutes(){
        if (timeCurrent >= 180000){
            outputText("Р: Что-то я так устала...");
        }
    }

    public BitmapFont whatIsFont(String phrase) {
        if (!phrase.equals("")) {
            switch (phrase.charAt(0)) {
                case 'Р':
                    return gg.fontRuna;
                case 'П':
                    return gg.fontPoliam;
                case 'К':
                    return gg.fontKaiden;
                case 'В':
                    return gg.fontValo;
                case ':':
                    return gg.fontMassovka;
                default:
                    return gg.font;
            }
        }else return gg.font;
    }

    public void outputText(List<String> list){
        isTalking = true;
        runa.isWalking = false;
        tt.phrase = list.get(count);
        gg.setFont(whatIsFont(tt.phrase));
        if(++count == list.size()) {
            tt.phrase = "";
            isTalking = false;
            runa.isWalking = true;
            count = 0;
        }
    }

    public void outputText(String phrase){
        tt.phrase = phrase;
        isTalking = true;
        runa.isWalking = false;
        gg.setFont(whatIsFont(tt.phrase));
    }


    public void changeScreen(Texture changed, Texture changing, int x, int y){
        if (y < 120 && y > 90 && (x >= END_OF_SCREEN_RIGHT || x <= END_OF_SCREEN_LEFT)){
            changed = changing;
        }
    }

    void gameStart(){
        timeStart = TimeUtils.millis();
        isGameStart = true;
    }

    void changePose(){
        texR = texRuna[runa.faza + 10];
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
        Gdx.input.setCatchKey(Input.Keys.BACK, false);    }

    @Override
    public void dispose() {
        for (Texture texture : texKaiden) {
            texture.dispose();
        }
        for (Texture texture : texRuna) {
            texture.dispose();
        }
    }
}
