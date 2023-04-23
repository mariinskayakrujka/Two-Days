package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Classroom extends ScreenGame{

    Texture imgBG;
    boolean isDialog = true;

    Objects desk, behindPoliam, trash, stand, tables;
    ArrayList<String> dialogfirst = new ArrayList<>(), dialognext = new ArrayList<>(),
            dialogKeys = new ArrayList<>();
    public Classroom(TwoDays context) {
        super(context);
        imgBG = new Texture("bg/bg4.jpg");
        behindPoliam = new Objects(0,0, 702, 1426);
        tables = new Objects(764, 950, 1148-764, 1380-950);
        desk = new Objects(1180, 708, 2066-1180, 1340-708);
        stand = new Objects(2158, 758, 2506-2158, 1314-758);
        trash = new Objects(2288, 210, 2418-2288, 456-210);
    }


    @Override
    public void show() {
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
        runa.x = 1700;
        gg.touch.x=0;
        runa.vx = 0;
        texR = texRuna[6];
    }

    @Override
    public void render(float delta) {
        if (tt.phrase.equals("") && gg.touch.x != 0 && gg.touch.x != runa.getX()) runa.moveForRuna(gg.touch.x);
        if (runa.x > END_OF_SCREEN_RIGHT) {
            gg.setScreen(gg.roomOfRuna);
        }
        // обработка касаний экрана
        if(Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            tt.phrase="";
            if(isDialog){

            }
            System.out.println("CLASSROOM " + gg.touch.x + " " + gg.touch.y);
            if (behindPoliam.hit(gg.touch.x, gg.touch.y)) {
                outputText("Р: Не надо оно мне");
            }
            if (tables.hit(gg.touch.x, gg.touch.y)) {
                outputText("some phrase");
            }
            if (desk.hit(gg.touch.x, gg.touch.y)) {
                outputText("Р: some about grace");
            }
            if (trash.hit(gg.touch.x, gg.touch.y)) {
                outputText("Р: Мусор. Ничего интересного");
            }
            if (stand.hit(gg.touch.x, gg.touch.y)) {
                outputText("Р: some about stand");
            }
            /*if (poliam.interaction(gg.touch.x, gg.touch.y)) {
                outputText(poste);
            }*/
            isThreeMinutes();
        }
        times();

        // события

        // отрисовка всей графики
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        if (runa.isWalking) {
            changePose();
            gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
        } else gg.batch.draw(texRuna[3], runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);//спокойствие
        gg.font.draw(gg.batch, tt.phrase, tt.getX(), tt.getY());
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
        super.dispose();
        imgBG.dispose();

    }
}

