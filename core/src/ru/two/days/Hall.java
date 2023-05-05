package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;
import static ru.two.days.TwoDays.end;
import static ru.two.days.TwoDays.timeCurrent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public class Hall extends ScreenGame {
    Objects door;
    List<String> talkWithKaiden = new ArrayList<>();
    Texture[] imgBG = new Texture[5];
    int numberOfHalls = 0;
    boolean talkingKai = true, isClassroom;

    public Hall(TwoDays context) {
        super(context);
        for (int i = 0; i < imgBG.length; i++) {
            imgBG[i] = new Texture("bg/hall" + i + ".png");
        }
        door = new Objects(1092, 202, 1608-1092, 1436-202);
        talkWithKaiden.add("К: Руна?");
        talkWithKaiden.add("Р: Это прозвучит глупо... но я все забыла, понимаете?");
        talkWithKaiden.add("Р: Вы можете мне помочь? Скажите, кто я?");
        talkWithKaiden.add("К: Забыла?");
        talkWithKaiden.add("К: Ахахаха, ты превзошла себя.");
        talkWithKaiden.add("К: И на что только не пойдешь ради спасения своей попы, да?");
        talkWithKaiden.add("Р: Я правда все забыла. Я не помню ничего с момента, как вы меня разбудили.");
        talkWithKaiden.add("К: Я не будила тебя. Ты до меня уже сидела.");
        talkWithKaiden.add("К: Перестань, Руна, все это очень глупо.");
        talkWithKaiden.add("К: Глупее только то, когда ты сбежала с зачета, сказав, что ребенка из садика забрать надо.");
        talkWithKaiden.add("Р: \"Какой ужас...\"");
        talkWithKaiden.add("Р: \"Я думаю, она мне не поверит\"");
        talkWithKaiden.add("Р: \"Но мне нужна хоть какая-то информация\"");
        talkWithKaiden.add("Р: Мне нужно позвонить родителям. Вы можете дать телефон?");
        talkWithKaiden.add("К: Зачем это? Не общались 15 лет, а тут вдруг надо звонить.");
        talkWithKaiden.add("Р: \"Да, как я могла это забыть...\"");
        talkWithKaiden.add("Р: Тогда мне нужен... Этот...");
        talkWithKaiden.add("К: Что?");
        talkWithKaiden.add("Р: Вы не видели его сегодня? Ну, он...");
        talkWithKaiden.add("К: Аа, этот несчастный? Он в своем кабинете.");
        talkWithKaiden.add("К: Но не думаю, что он будет рад тебя видеть.");
        talkWithKaiden.add("Р: \"Интересно, кто же это...\"");
        talkWithKaiden.add("Р: \"Помолчу, может сама скажет\"");
        talkWithKaiden.add("К: ...");
        talkWithKaiden.add("К: Я удивлена, что Ст вообще захотел с тобой работать.");
        talkWithKaiden.add("Р: \"Так, осталось узнать, кто это и что я ему сделала\"");
        talkWithKaiden.add("К: Как бы неприятно тебе ни было, он не лучшего мнения о тебе.");
        talkWithKaiden.add("К: И на то есть много причин.");
        talkWithKaiden.add("Р: Например?");
        talkWithKaiden.add("К: Например? Милая, ты такая шумная, импульсивная и безответственная.");
        talkWithKaiden.add("К: Ты злоупотребляешь алкоголем. Водишь непонятно кого в общежитие.");
        talkWithKaiden.add("К: Ты чудом в академии-то держишься. Я многое утаиваю от ректора.");
        talkWithKaiden.add("К: Ты невесть когда забила на учебу. На тебя все жалуются.");
        talkWithKaiden.add("К: И ты клеишься к Ст.");
        talkWithKaiden.add("Р: ...");
        talkWithKaiden.add("К: Уважаемое существо. На отношения, особенно с такими, не способен.");
        talkWithKaiden.add("Р: Оттого уважаем?");
        talkWithKaiden.add("К: Не дерзи. Он уважаем в том числе оттого, что к тебе холоден.");
        talkWithKaiden.add("Р: Правда?");
        talkWithKaiden.add("К: А ты думала, он в тебя влюблен? Ради Верховного, откуда такие мысли?");
        talkWithKaiden.add(" К: Он ведь с тобой однажды говорил об этом, ты рассказывала. Забыла?");
        talkWithKaiden.add("Р: \"Забыла\"");
        talkWithKaiden.add("К: Не трогай его хотя бы сегодня, дай отдохнуть мужчине.");
        talkWithKaiden.add("Р: Как, еще раз, его найти?");
        talkWithKaiden.add("К:...");
        talkWithKaiden.add("Р:...");
        talkWithKaiden.add("К: Он в своем кабинете.");
        talkWithKaiden.add("Р: Напомните номер, пожалуйста.");
        talkWithKaiden.add("К: Я не понимаю, что с тобой. Руна, ты в порядке?");
        talkWithKaiden.add("Р: Я говорила, что все забыла.");
        talkWithKaiden.add("К:...");
        talkWithKaiden.add("Р:...");
        talkWithKaiden.add("К: 214.");
        talkWithKaiden.add("Р: Спасибо.");
        talkWithKaiden.add("Р: \"Не верит\"");
        talkWithKaiden.add("end");

        texK = texKaiden[1];
        texR = texRuna[3];
    }

    public void render(float delta) {
        if (!talkingKai) {
            if (tt.phrase.equals("") && gg.touch.x != runa.getX() && gg.touch.x != 0)
                runa.moveForRuna(gg.touch.x);
            if(soundOn && runa.isWalking) music[2].play();
            else music[2].stop();
        } else {
            switch (tt.phrase) {
                case ("Р: Вы можете мне помочь? Скажите, кто я?"):
                case ("К: Я не будила тебя. Ты до меня уже сидела."):
                case ("К: Что?"):
                case (" К: Он ведь с тобой однажды говорил об этом, ты рассказывала. Забыла?"):
                    texK = texKaiden[0];
                    break;
                case ("К: Ахахаха, ты превзошла себя."):
                case ("К: А ты думала, он в тебя влюблен? Ради Верховного, откуда такие мысли?"):
                    texK = texKaiden[4];
                    break;
                case ("Р: \"Какой ужас...\""):
                    texR = texRuna[4];
                    break;
                case ("К: Зачем это? Не общались 15 лет, а тут вдруг надо звонить."):
                case ("К: Я удивлена, что Ст вообще захотел с тобой работать."):
                case ("К: 214."):
                    texK = texKaiden[5];
                    break;
                case ("Р: Вы не видели его сегодня? Ну, он..."):
                case ("К: Уважаемое существо. На отношения, особенно с такими, не способен."):
                case ("Р: Правда?"):
                    texR = texRuna[3];
                    break;
                case ("К: Ты злоупотребляешь алкоголем. Водишь непонятно кого в общежитие."):
                    texK = texKaiden[2];
                    break;
                case ("К: И ты клеишься к Ст."):
                    texR = texRuna[5];
                    texK = texKaiden[0];
                    break;
                case ("Р: Как, еще раз, его найти?"):
                    texR = texRuna[3];
                    texK = texKaiden[0];
                    break;
                case ("Р: Оттого уважаем?"):
                    texR = texRuna[6];
                    break;

                default:
                    break;
            }

        }
        if (runa.x < END_OF_SCREEN_LEFT && numberOfHalls > 1) {//игрок никогда не вернется к кайден
            numberOfHalls--;
            runa.x = 1700;
            gg.touch.x = 1700;
            isClassroom = false;
        } else if (numberOfHalls == 4){
            isClassroom = true;
            if(runa.x > END_OF_SCREEN_RIGHT){
                gg.setScreen(gg.roomOfRuna);
                music[2].stop();
            }
        }
        else if (runa.x > END_OF_SCREEN_RIGHT && numberOfHalls < 4) {
            numberOfHalls++;
            runa.x = 400;
            gg.touch.x =600;
            isClassroom = false;
        }
        //основные события игры
        if (Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            isThreeMinutes();
            if (gg.touch.y > SCR_HEIGHT - 100) {
                talkingKai = false;
                numberOfHalls = 1;
            }
            if (talkingKai) {
                outputText(talkWithKaiden);
                if (count == 0) {
                    talkingKai = false;
                    numberOfHalls = 1;
                    end.talkingKaiden = true;
                    end.countKeys++;
                }
            } else {
                System.out.println("hall " + gg.touch.x + " " + gg.touch.y);
                if (!talkWithKaiden.contains(tt.phrase)) tt.phrase = "";
                if (door.hit(gg.touch.x, gg.touch.y)) {
                    if (isClassroom) gg.setScreen(gg.classroom);
                    else outputText("Р: Не лучшая идея вламываться к кому-то посреди урока");
                }
            }
        }
            times();
            //отрисовка
            gg.camera.update();
            gg.batch.setProjectionMatrix(gg.camera.combined);
            gg.batch.begin();
            gg.batch.draw(imgBG[numberOfHalls], 0, 0, SCR_WIDTH, SCR_HEIGHT);
            if (talkingKai) {
                gg.batch.draw(texK, 200, kaiden.getY());
                gg.batch.draw(texR, 800, runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
            } else {
                if (runa.isWalking) {
                    changePose();
                    gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
                } else
                    gg.batch.draw(texRuna[3], runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);//спокойствие
                if(numberOfHalls != 1) gg.batch.draw(forButtons[1], 0, SCR_HEIGHT/2f-350, 500, 500);
                gg.batch.draw(forButtons[2], SCR_WIDTH-400, SCR_HEIGHT/2f-350, 500, 500);
            }
            gg.font.draw(gg.batch, timeCurrent+"", 200, 600);
            gg.font.draw(gg.batch, tt.phrase, tt.getX(), tt.getY());
            gg.batch.end();

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}