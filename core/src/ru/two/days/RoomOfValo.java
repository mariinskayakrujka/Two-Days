package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class RoomOfValo extends ScreenGame {
    Objects feliopter, bed, radio, trash, fridge, posters, closer;
    //InputKeyboard keyboard;
    ArrayList<String> feli = new ArrayList<>(), poste = new ArrayList<>(),
            history = new ArrayList<>();

    boolean isEnterWays, isKeyboard;
    String numberOfWays;
    Texture imgBG;

    public RoomOfValo(TwoDays context) {
        super(context);
        //keyboard = new InputKeyboard(SCR_WIDTH, SCR_HEIGHT/2f, 15);
        feli.add("Р: Прикольное устройство.");
        feli.add("Р: Он пишет, что у меня почти все в норме. Никаких повреждений.");
        feli.add("Р: С печенью только... неполадки.");
        feli.add("Р: ...");
        imgBG = new Texture("bg/bg1.jpg");
        poste.add("");
        poste.add("");
        poste.add("");

        history.add("Р:...");
        history.add("Р: Это помогло мне многое вспомнить.");
        history.add("Р: Все же я очень удачливая.");
        //keyboard = new InputKeyboard(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 4);
    }

    @Override
    public void show() {
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
        gg.touch.x=0;
        runa.vx = 0;
        runa.x = 200;
    }

    @Override
    public void render(float delta) {
        if (tt.phrase.equals("") && gg.touch.x != 0 && gg.touch.x != runa.x) runa.moveForRuna(gg.touch.x);
        if (Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);

            /*if (isKeyboard) {
                if (keyboard.endOfEdit(gg.touch.x, gg.touch.y)) {
                    numberOfWays = keyboard.getText();
                    isEnterWays = false;
                    if(numberOfWays.equals("4413")) {
                        outputText(history);
                        if (tt.phrase.equals(history.get(20)) ||tt.phrase.equals(history.get(21))
                                || tt.phrase.equals(history.get(22))) outputText(history);
                    }else if(numberOfWays.equals("666")) {
                        outputText("Р: Не работает. Похоже, тут нет записей от Академии Дыма.");
                    }else {
                        outputText("Р: Не работает. Наверное, я не то включаю..");
                    }
                    isKeyboard= false;

                }
            } else {
                if (radio.hit(gg.touch.x, gg.touch.y)) {
                    runa.moveForRuna(gg.touch.x);
                    outputText("Р: Приемник? Хм, какую дорожку мне включить?");
                    isKeyboard = true;
                    isEnterWays = true;
                }
                if (feliopter.hit(gg.touch.x, gg.touch.y)) {
                    runa.moveForRuna(gg.touch.x);
                    outputText(feli);
                    if (tt.phrase.equals(feli.get(2))) texR = new Texture("runa/runa4.png");
                }
                if (bed.hit(gg.touch.x, gg.touch.y)) {
                    runa.moveForRuna(gg.touch.x);
                    outputText("Р: Я не имею право спать на чужой кровати.");
                }
                if (trash.hit(gg.touch.x, gg.touch.y)) {
                    runa.moveForRuna(gg.touch.x);
                    outputText("Р: Мусор. Не существо же.");
                }
                if (fridge.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: Совсем не хочется есть.");
                }
                if (posters.hit(gg.touch.x, gg.touch.y)) {
                    outputText(poste);
                }
            }
            if (gg.touch.y < 120 && gg.touch.y > 90 && gg.touch.x <= END_OF_SCREEN_LEFT){
                gg.setScreen(new RoomOfRuna(gg));
            }

            isThreeMinutes();*/
            if (runa.x < END_OF_SCREEN_LEFT) {
                gg.setScreen(gg.roomOfRuna);

            }
        }
        //отрисовка
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        if (runa.isWalking) {
            changePose();
            gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
        } else gg.batch.draw(texRuna[4], runa.getX(), runa.getY());//спокойствие
            /*if(isReading){
                gg.batch.draw(texPaper, 0, 20);
                gg.batch.draw(button, SCR_WIDTH*7/8f, 0, 250, 250);
                gg.batch.draw(button1, SCR_WIDTH/8f, 0, 250, 250);
            }*/
        gg.font.draw(gg.batch, tt.phrase, tt.getX(), tt.getY());
        //if(isEnterWays) keyboard.draw(gg.batch);
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
        //super.dispose();
        //keyboard.dispose();
    }
}
