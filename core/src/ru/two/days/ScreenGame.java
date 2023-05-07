package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;
import static ru.two.days.TwoDays.isGameStart;
import static ru.two.days.TwoDays.timeCurrent;
import static ru.two.days.TwoDays.timeStart;

import androidx.annotation.NonNull;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.List;

public class ScreenGame implements Screen {

    TwoDays gg;
    Text tt;
    boolean soundOn = true;
    Sound shelest;
    Music[] music = new Music[4];

    //Texture texPaper;
    Texture[] texRuna = new Texture[16], texKaiden = new Texture[11]
            /*,texValo = new Texture[]*/;

    //TextButton [] buttons = new TextButton[5];
    Texture[] forButtons = new Texture[5];

    public static final int END_OF_SCREEN_RIGHT = SCR_WIDTH*190/200,END_OF_SCREEN_LEFT = SCR_WIDTH/10;

    boolean isTalking;

    Texture texK, texR, texP, texV;

    RunaMilekum runa;

    KaidenMorem kaiden;


    int count = 0;

    public ScreenGame(@NonNull TwoDays context){
        try {
            gg = context;
            /*buttons[0] = new TextButton(gg.font, "пропустить", 0, SCR_HEIGHT*15/20f);//кнопка
            buttons[1] = new TextButton(gg.font, 0, SCR_HEIGHT/2f);//стрелки
            buttons[2] = new TextButton(gg.font, SCR_WIDTH-100, SCR_HEIGHT/2f);//стрелки
            buttons[3] = new TextButton(gg.font, 0, SCR_HEIGHT/2f);//при пролистывании
            buttons[4] = new TextButton(gg.font, SCR_WIDTH-100, SCR_HEIGHT/2f);//при пролистывании*/
            tt = new Text(gg.font, "", SCR_WIDTH/5f, SCR_HEIGHT/ 11f);
            runa = new RunaMilekum(703);
            kaiden = new KaidenMorem(SCR_WIDTH*3/4f);
            shelest = Gdx.audio.newSound(Gdx.files.internal("sounds/shelest.mp3"));
            music[0] = Gdx.audio.newMusic(Gdx.files.internal("sounds/WalkingKover.mp3"));
            music[1] = Gdx.audio.newMusic(Gdx.files.internal("sounds/beg-v-kablukah.mp3"));
            music[2] = Gdx.audio.newMusic(Gdx.files.internal("sounds/walkingRuna.mp3"));
            music[3] = Gdx.audio.newMusic(Gdx.files.internal("sounds/withoutUn.mp3"));

            forButtons[0] = new Texture("buttons/buttonRestrt.png");
            forButtons[1] = new Texture("buttons/lScreen.png");
            forButtons[2] = new Texture("buttons/rScreen.png");
            forButtons[3] = new Texture("buttons/left.png");
            forButtons[4] = new Texture("buttons/right.png");
            for (int i = 0; i < texRuna.length; i++) {
                texRuna[i] = new Texture("runa/runa" + i + ".png");
            }
            for (int i = 0; i < texKaiden.length; i++) {
                texKaiden[i] = new Texture("kaiden/kaiden" + i + ".png");
            }
            /*
            for (int i = 0; i < texPoliam.length; i++) {
                texValo[i] = new Texture("valo/valo" + i + ".png");
            }*/

        }catch (NullPointerException ignored){}
    }
    @Override
    public void show() {

    }
    @Override
    public void render(float delta) {
        times();
        /*gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();

        gg.batch.end();*/
    }
    void isThreeMinutes(){
        if (timeCurrent == 180000){
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

    void rightOutput(List<String>list){
        if(list.contains((tt.phrase))) outputText(list);
    }
    public void outputText(List<String> list){
        try {
            isTalking = true;
            runa.isWalking = false;
            tt.phrase = list.get(count);
            gg.setFont(whatIsFont(tt.phrase));
            if (++count == list.size()) {
                tt.phrase = "";
                isTalking = false;
                runa.isWalking = true;
                count = 0;
            }
        }catch(IndexOutOfBoundsException e){
            count =0;
        }
    }
    void times(){
        if(isGameStart) {
            TwoDays.timeCurrent = TimeUtils.millis() - timeStart;
        }
    }

    public void outputText(String phrase){
        tt.phrase = phrase;
        isTalking = true;
        runa.isWalking = false;
        gg.setFont(whatIsFont(tt.phrase));
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
    public void hide() {Gdx.input.setCatchKey(Input.Keys.BACK, false); }
    @Override
    public void dispose() {
        for (Texture texture : texKaiden) {
            texture.dispose();
        }
        for (Texture texture : texRuna) {
            texture.dispose();
        }
        shelest.dispose();
        for (Music music : music) {
            music.dispose();
        }

    }
}
