package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;
import static ru.two.days.TwoDays.end;
import static ru.two.days.TwoDays.timeCurrent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class RoomOfValo extends ScreenGame {
    Objects feliopter, bed, radio, trash, fridge, posters, closer;
    InputKeyboard keyboard;
    ArrayList<String> feli = new ArrayList<>(), poste = new ArrayList<>(),
            history = new ArrayList<>(), clos = new ArrayList<>(), afterHistory = new ArrayList<>();

    boolean isEnterWays, isKeyboard;
    String numberOfWays;
    Texture imgBG;
    boolean endOfHistory;

    public RoomOfValo(TwoDays context) {
        super(context);
        keyboard = new InputKeyboard(SCR_WIDTH, SCR_HEIGHT/2f, 4);

        fridge = new Objects(788, 212, 1180 - 788, 934 - 212);
        radio = new Objects(608, 728, 716 - 608, 788 - 728);
        feliopter = new Objects(1026, 1026, 1302 - 1026, 1402 - 1026);
        closer = new Objects(1642, 1048, 2228 - 1642, 1388 - 1048);
        posters = new Objects(1354, 640, 2500 - 1354, 1010 - 640);
        trash = new Objects(2006, 204, 2502 - 2006, 294 - 204);
        bed = new Objects(1522, 312, 2551 - 1522, 600 - 312);

        feli.add("Р: Прикольное устройство.");
        feli.add("Р: Он пишет, что у меня почти все в норме. Никаких повреждений.");
        feli.add("Р: С печенью только... неполадки.");
        feli.add("Р: ...");

        imgBG = new Texture("bg/bg1.jpg");
        poste.add("Р: Точно, соседка большая любительница поп-групп.");
        poste.add("Р: Я вспомнила. Вон тот дуэт – \"Начало\". Раньше я тоже слушала их.");
        poste.add("Р: Их фирменный знак - две четверки.");
        poste.add("...");

        clos.add("Р: Он на замке? ");clos.add("Р: Точно. Иногда я тащила ее вещи. Больше не буду.");
        clos.add("...");

        afterHistory.add("Р:...");
        afterHistory.add("Р: Это помогло мне многое вспомнить.");
        afterHistory.add("Р: Все же я очень удачливая.");
        afterHistory.add("...");


        history.add(":...мы медленно подходим к самому главному.");history.add(":К устройству Вселенной.");
        history.add(":Условно Вселенная поделена на Межмирье и Ничего, это вы знаете.");history.add(":Межмирье – это некое пространство между мирами, так ведь?");
        history.add(":Миров, запомните, пожалуйста, не 252.");history.add(":Столько мы открыли, да. ");history.add(":Но на самом деле их огромное количество. Бесконечное множество.");
        history.add(":Если я услышу от вас, что всего миров 252 штуки, вы мигом вылетите из класса.");
        history.add(":Может, кто-нибудь рассказать о Межмирье то, что он знает?");history.add("Кто-то: Межмирье сглаживает изменение пространственно-временного континуума.");
        history.add("Кто-то: Смешиваются климаты, давления, время и тому подобное.");history.add("Кто-то: Вокруг того, кто попадает Межмирье, как бы возводятся стены,");
        history.add("Кто-то: чтобы это все на него не давило.");history.add("Кто-то: Но они постепенно разрушаются под такой тяжестью.");
        history.add("Кто-то: Межмирье трескается, и существо попадает в Ничего.");history.add("Кто-то: Потому в Межмирье нельзя долго быть.");
        history.add(":А что с Ничего?");history.add("Кто-то:...");
        history.add("Кто-то: Мы ничего о нем не знаем. Предполагается, что там все умирают.");
        history.add(":Верно, Пенни, молодец.");history.add("Запуск второй дорожки...");
        history.add(":Все миры делятся на верхние, поверхностные и подземные.");history.add(":Мы с вами живем в Объединенном III. Это поверхностный мир.");
        history.add(":Поверхностные миры есть целостная открытая территория.");history.add(": Есть небо, но чуть выше – Межмирье. Ниже земли тоже Межмирье.");
        history.add(":Когда как у Верхних еще есть часть пространства. Верхние – воздушные острова.");
        history.add(":У подземных нет ничего ни снизу, ни сверху.");history.add(":Нет и неба, только купол, который при разрушении убивает всякую жизнь.");
        history.add(":Необычен Кэпс. Это мир людей – единственных существ без магии.");
        history.add(":Он считается поверхностным, но он устроен так, что Земля, которая обжита,");history.add(":лишь малая часть всего их огромного мира.");
        history.add(":Это создано для того, чтобы люди не могли проникнуть в наши мира без нашего согласия.");history.add("...");

    }

    @Override
    public void show() {
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
        gg.touch.x = 0;
        runa.vx = 0;
        runa.x = 300;
        texR = texRuna[6];
        music[0].stop();
    }

    @Override
    public void render(float delta) {
        if (tt.phrase.equals("") && gg.touch.x != 0 && gg.touch.x != runa.getX() && !isKeyboard)
            runa.moveForRuna(gg.touch.x);
        if(soundOn && runa.isWalking) music[0].play();
        else music[0].stop();
        if (runa.x <= END_OF_SCREEN_LEFT) {
            gg.setScreen(gg.roomOfRuna);
            music[0].stop();
        }
        if (Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            System.out.println("VALO " + gg.touch.x + " " + gg.touch.y);
            rightOutput(feli);rightOutput(clos);rightOutput(poste);
            if (!feli.contains(tt.phrase) && !poste.contains(tt.phrase) &&
                    !clos.contains(tt.phrase) && !history.contains(tt.phrase) &&
                    !tt.phrase.equals("Р: Приемник? Хм, какую дорожку мне включить?")) tt.phrase = "";
            if(history.contains(tt.phrase) && count!=0) outputText(history);
            if (isKeyboard) {
                runa.vx=0;
                if (keyboard.endOfEdit(gg.touch.x, gg.touch.y)) {
                    numberOfWays = keyboard.getText();
                    isEnterWays = false;
                    if (numberOfWays.equals("4413")) {
                        outputText(history);
                        if(!end.recordOfLesson){
                            end.countKeys++;
                            end.recordOfLesson=true;
                        }
                    } else if (numberOfWays.equals("666")) {
                        outputText("Р: Не работает. Похоже, тут нет записей от Академии Дыма.");
                    } else {
                        outputText("Р: Не работает. Наверное, я не то включаю..");
                    }
                    isKeyboard = false;
                }
            } else if(tt.phrase.equals(history.get(31))) {
                endOfHistory = true;
                runa.isWalking = false;
            }
            else if(endOfHistory){
                outputText(afterHistory);

                if(tt.phrase.equals(afterHistory.get(2))){
                    endOfHistory=false;
                }
            }
            else {
                isThreeMinutes();
                if(tt.phrase.equals("Р: Приемник? Хм, какую дорожку мне включить?")){
                    isKeyboard = true;
                    isEnterWays = true;
                }
                if (radio.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: Приемник? Хм, какую дорожку мне включить?");
                }
                if (feliopter.hit(gg.touch.x, gg.touch.y)) {
                    outputText(feli);
                    if (tt.phrase.equals(feli.get(2))) texR = texRuna[4];
                }
                if (bed.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: Я не имею право спать на чужой кровати.");
                }
                if (trash.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: Мусор. Не существо же.");
                }
                if (fridge.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: Совсем не хочется есть.");
                }
                if (posters.hit(gg.touch.x, gg.touch.y)) {
                    outputText(poste);
                }
                if (closer.hit(gg.touch.x, gg.touch.y)) {
                    outputText(clos);
                }
            }
        }
        times();

            //отрисовка
            gg.camera.update();
            gg.batch.setProjectionMatrix(gg.camera.combined);
            gg.batch.begin();
            gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
            if (runa.isWalking) {
                changePose();
                gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
            } else gg.batch.draw(texRuna[3], runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);//спокойствие
            /*if(isReading){
                gg.batch.draw(texPaper, 0, 20);
                gg.batch.draw(button, SCR_WIDTH*7/8f, 0, 250, 250);
                gg.batch.draw(button1, SCR_WIDTH/8f, 0, 250, 250);
            }*/
        gg.batch.draw(forButtons[1], 0, SCR_HEIGHT/2f-350, 500, 500);
            gg.font.draw(gg.batch, tt.phrase, tt.getX(), tt.getY());
            if(isEnterWays) keyboard.draw(gg.batch);
            gg.font.draw(gg.batch, timeCurrent+"", 200, 600);
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
        super.dispose();
    }
}
