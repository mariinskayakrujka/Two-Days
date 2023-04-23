package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;
import static ru.two.days.TwoDays.timeCurrent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class RoomOfRuna extends ScreenGame {
    Objects feliopter, bed, bottles, clothes, cup, paper, docWithDairy;

    boolean isIntro = true, isAfterIntro, dairyNotPaper;

    Texture imgBG;
    Texture atlasDocWithDairy;
    TwoDays gg;


    ArrayList<String> intro = new ArrayList<>(), afterintro = new ArrayList<>(), feli = new ArrayList<>(),
            paperi = new ArrayList<>(), docs = new ArrayList<>();

    public RoomOfRuna(TwoDays myGG) {
        super(myGG);
        gg = myGG;
        feliopter = new Objects(1380, 1042, 1636-1380, 31406-1042);
        bed = new Objects(0, 310, 1038, 602-310);
        bottles = new Objects(0, 208, 1016, 310-208);
        clothes = new Objects(1040, 208, 1374-1040, 454-208);
        cup = new Objects(1648, 768, 1730-1648, 852-768);
        imgBG = new Texture("bg/bg0.png");

        intro.add("Р: ...");
        intro.add("К: Проснулась наконец, пьянь.");
        intro.add("Р: ...");
        intro.add("К: А я ведь говорила тебе, что до добра это никогда не доведет.");
        intro.add("К: Но нет же, «поверьте, Морэм, я успею все сделать и со всем справлюсь»!");
        intro.add("Р: \"Это кто?..\"");
        intro.add("К: Что смотришь на меня такими невинными глазами?");
        intro.add("К: Думаешь, тебя не заметили ночью? Вся общага видела.");
        intro.add("К: Вало рассказала все. Сдала с потрохами тебя.");
        intro.add("Р: ...");
        intro.add("К: Зачем же ты жизнь свою губишь? Алкоголь этот...");
        intro.add("К: У тебя ведь послезавтра...");
        intro.add("К: *вздох* А ты... Тьфу!");
        intro.add("К: Вставай, приводи себя в порядок и готовься.");
        intro.add("К: Глаза б мои тебя не видели.");
        intro.add("the end of intro");

        afterintro.add("Р:...");
        afterintro.add("Р: \"Где я?..\"");
        afterintro.add("Р: \"Эта женщина... Она меня знает...\"");
        afterintro.add("Р: \"А я...\"");
        afterintro.add("Р: ...");
        afterintro.add("Р: \"Я ничего не понимаю...\"");
        afterintro.add("Р: \"...и не помню?..\"");
        afterintro.add("Р: \"Ужас какой-то, если это действительно от алкоголя\"");
        afterintro.add("Р: \"Я должна все вспомнить\"");
        afterintro.add("The end of afterintro");

        feli.add("Р: Прикольное устройство.");
        feli.add("Р: Он пишет, что у меня почти все в норме. Никаких повреждений.");
        feli.add("Р: С печенью только... неполадки.");
        feli.add("Р: ...");

        paperi.add("Р:...");
        paperi.add("Р: Что это могло быть?");
        docs.add("Р:...");
        docs.add("Р: Это стоило бы и выкинуть из памяти.");
        docs.add("Р:...");


    }

    @Override
    public void show() {
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
        if(isIntro) runa.x = 400;
        //runa.y = 450;
        else {
            if (gg.touch.x > 1600) runa.x = 400;
            else runa.x = 1600;
        }
        gg.touch.x=0;
        runa.vx = 0;
        texR = texRuna[6];

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


    @SuppressWarnings("SuspiciousIndentation")
    public void render(float delta) {
        //основные события игры
        if (isAfterIntro) kaiden.move(10);
        if (!isIntro && !isAfterIntro) {
            if (tt.phrase.equals("") && gg.touch.x != runa.getX() && gg.touch.x != 0 && !tt.phrase.equals(feli.get(0))
                    && !tt.phrase.equals(feli.get(1)) && !tt.phrase.equals(feli.get(2))) runa.moveForRuna(gg.touch.x);
        }
        if (runa.x >= END_OF_SCREEN_RIGHT) {
            gg.setScreen(gg.roomOfValo);
        }
        if (runa.x < END_OF_SCREEN_LEFT) {
            gg.setScreen(gg.classroom);//временная мера
        }
        if (Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            //интро
            if (gg.touch.y > SCR_HEIGHT - 100) {
                isIntro = false;
                isAfterIntro = false;
            }
            if (isIntro) {
                outputText(intro);
                if (count == 0) {
                    isIntro = false;
                    isAfterIntro = true;
                }
                changeTexture();
            }
            if (isAfterIntro) {
                outputText(afterintro);
                if (count == 0) {
                    isAfterIntro = false;
                }
                changeTexture();
            }
            if (!isIntro && !isAfterIntro) {
                System.out.println("RUNA" + gg.touch.x + " " + gg.touch.y);
                if (!feli.contains(tt.phrase)) tt.phrase = "";
                if (feliopter.hit(gg.touch.x, gg.touch.y)) {
                    //runa.moveForRuna(gg.touch.x);
                    outputText(feli);
                    if (tt.phrase.equals(feli.get(2)))
                        texR = texRuna[4];//серьезность
                }
                if (clothes.hit(gg.touch.x, gg.touch.y)) {
                    //runa.moveForRuna(gg.touch.x);
                    outputText("Р: Мне сейчас не до того, чтобы разбирать эту кучу.");
                }
                if (bed.hit(gg.touch.x, gg.touch.y)) {
                    //runa.moveForRuna(gg.touch.x);
                    if (timeCurrent < 1000 * 60 * 3) outputText("Р: Пока я не хочу спать.");
                    else {
                        outputText("Р: Мне правда стоит передохнуть.");
                        texR = texRuna[5];
                        outputText("Р: Я поспала.");
                        end.sleeping = true; // ключевой момент
                    }
                }
                if(bottles.hit(gg.touch.x, gg.touch.y)){
                    outputText("Р: ...Мне правда стыдно.");
                }

                if (cup.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: Пахнет алкоголем и чабрецом одновременно.");
                }
                /*if (paper.hit(gg.touch.x, gg.touch.y)){
                    isReading = true;
                    texPaper = new Texture("paper.png");
                }
                    if (isReading && (gg.touch.x < SCR_WIDTH / 8f) || (gg.touch.x > SCR_WIDTH / 8f + 250 &&
                            gg.touch.x < SCR_WIDTH * 7 / 8f) || (gg.touch.x > SCR_WIDTH * 7 / 8f + 250)) {
                        isReading = false;
                        if (dairyNotPaper) {
                            outputText(docs);
                            end.docAbenrollment = true;
                            end.countKeys++;
                        } else {
                            texR = new Texture("runa/runa4.png");//удивление
                            outputText(paperi);
                            end.dairy = true;
                            end.countKeys++;
                        }
                    }
                if(docWithDairy.hit(gg.touch.x, gg.touch.y)) {
                    isReading = true;
                    texPaper = new Texture("docWithDairy1.png");
                }*/
            }
            isThreeMinutes();
        }
        times();

        //отрисовка
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        //отрисовка интро
        if (isIntro) {
            texR = texRuna[0];
            changeTexture();
            gg.batch.draw(texK, kaiden.getX(), kaiden.getY());
            gg.batch.draw(texR, runa.getX(), runa.getY());
        } else if (isAfterIntro) {
            changeTexture();
            gg.batch.draw(texKaiden[kaiden.faza + 7], kaiden.getX(), kaiden.getY());
            gg.batch.draw(texR, runa.getX(), runa.getY());
        }
        if (!isIntro && !isAfterIntro) {
            if (runa.isWalking) {
                changePose();
                gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
            } else gg.batch.draw(texRuna[4], runa.getX(), runa.getY());//спокойствие
        }
        /*if(isReading){
            gg.batch.draw(texPaper, 0, 20);
            gg.batch.draw(button, SCR_WIDTH*7/8f, 0, 250, 250);
            gg.batch.draw(button1, SCR_WIDTH/8f, 0, 250, 250);
        }*/
        gg.font.draw(gg.batch, tt.phrase, tt.getX(), tt.getY());

        gg.batch.end();

    }


    public void changeTexture() {
        if (tt.phrase.equals(intro.get(12)) || tt.phrase.equals(intro.get(13)) ||
                tt.phrase.equals(intro.get(14))) texK = texKaiden[0];//calm
        else texK = texKaiden[1];//angry


        if (tt.phrase.equals(afterintro.get(2)) || tt.phrase.equals(afterintro.get(3)) ||
                tt.phrase.equals(afterintro.get(7)) || tt.phrase.equals(afterintro.get(8)))
            texR = texRuna[1];
        else texR = texRuna[2];
    }


    @Override
    public void dispose() {

    }
}
