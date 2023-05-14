package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;
import static ru.two.days.TwoDays.end;
import static ru.two.days.TwoDays.soundOn;
import static ru.two.days.TwoDays.timeCurrent;
import static ru.two.days.TwoDays.timeStart;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Classroom extends ScreenGame {

    Texture imgBG;
    boolean isDialog, isDialogTwo, isKeysStage;

    long timeAfterDialog;
    Texture[] texPoliam = new Texture[20];
    Texture[] texValo = new Texture[5];
    Texture[] bg = new Texture[2];
    Objects desk, behindPoliam, trash, stand, tables;
    PoliamSt poliam;
    MainCharacter valo;
    ArrayList<String> dialogfirst = new ArrayList<>(), stan = new ArrayList<>(),
            table = new ArrayList<>(), dialogKeys = new ArrayList<>(), dialogNext = new ArrayList<>();

    public Classroom(TwoDays context) {
        super(context);
        for (int i = 0; i < texPoliam.length; i++) {
            texPoliam[i] = new Texture("poliam/poliam" + i + ".png");
        }
        for (int i = 0; i < texValo.length; i++) {
            texValo[i] = new Texture("valo/valo" + i + ".png");
        }
        bg[0] = new Texture("bg/bg4.jpg");
        bg[1] = new Texture("bg/hall4.png");
        behindPoliam = new Objects(0, 0, 702, 1426);
        tables = new Objects(764, 950, 1148 - 764, 1380 - 950);
        desk = new Objects(1180, 708, 2066 - 1180, 1340 - 708);
        stand = new Objects(2158, 758, 2506 - 2158, 1314 - 758);
        trash = new Objects(2288, 210, 2418 - 2288, 456 - 210);

        poliam = new PoliamSt(802);
        valo = new MainCharacter(2800);

        dialogfirst.add("Р: Здравствуйте, Ст.");dialogfirst.add("П: Я занят, Милекум. Позже.");dialogfirst.add("Р: \"Ага, занят\"");
        dialogfirst.add("Р: \"Ему точно не стоит говорить, что я все забыла\"");dialogfirst.add("Р: \"Но это... странное чувство...\"");
        dialogfirst.add("Р: Морэм сказала, что удивлена, как вы со мной решили работать.");
        dialogfirst.add("П: Я уверен, она это часто говорит.");dialogfirst.add("Р: \"Ни грамма такта\"");
        dialogfirst.add("Р: \"Судя по словам Морэм, я это заслужила\"");dialogfirst.add("Р: \"Видимо, я правда была в него влюблена...\"");
        dialogfirst.add("Р: \"Со мной даже сейчас что-то происходит, когда я все забыла\"");dialogfirst.add("Р:...");
        dialogfirst.add("П: Вашу дипломную по истории Объединенного III ведь я тяну.");
        dialogfirst.add("П: *вздох* Просто защитите ее, ладно? Не так ведь сложно запомнить текст.");
        dialogfirst.add("Р: Можете показать мою дипломную? Она же у вас?");
        dialogfirst.add("П: Естественно. Вам нельзя подобное доверять.");dialogfirst.add("Р:...");
        dialogfirst.add("Р: Биография Грейс Энджер? Как-то...");dialogfirst.add("П: Посредственно.");
        dialogfirst.add("Р: Просто.");dialogfirst.add("П: Ваш уровень.");dialogfirst.add("Р: ...");dialogfirst.add("П:...");
        dialogfirst.add("П: Я груб, да?");dialogfirst.add("Р: Весьма.");dialogfirst.add("Р: \"Обидно. Очень\"");
        dialogfirst.add("П: Простите. Вы должны понимать, что у меня есть причины.");dialogfirst.add("Р:...");
        dialogfirst.add("П: Я понимаю, что у нас разница всего в 500 лет, но грань должна быть.");dialogfirst.add("П: Мне надо вас учить, а вы...");
        dialogfirst.add("П: Вы, извините, лезете с объятьями и поцелуями.");dialogfirst.add("П: Но это полбеды.");
        dialogfirst.add("П: Ваше отношение к учебе и к жизни ужасно.");
        dialogfirst.add("П: Для вас не существует никто и ничто, кроме меня и каких-то развлечений.");dialogfirst.add("П: Так ведь нельзя...");
        dialogfirst.add("Р: Я признавалась вам в любви?");dialogfirst.add("П: ...");
        dialogfirst.add("П: Не раз. Странно, что вы забыли.");dialogfirst.add("Р: Я уточнила.");
        dialogfirst.add("Р: \"Какой стыд. Я перед ним очень виновата\"");
        dialogfirst.add("П: Вы сегодня странны. Что вы хотели?");dialogfirst.add("Р: Я могу забрать дипломную?");
        dialogfirst.add("П: Только аккуратнее, пожалуйста. У меня нет копий.");
        dialogfirst.add("Р: Не волнуйтесь, я буду осторожна.");dialogfirst.add("П:...");dialogfirst.add("end");

        stan.add("Р: Известный историк Руальдоф Киморович.");stan.add("Р: А, его Ст часто цитирует, я помню.");
        table.add("Р: Плюсы изучения истории.");table.add("Р: Когда-то меня веселили эти таблички.");

        dialogKeys.add("П: Что-то случилось?");dialogKeys.add("Р: Не знаю...");dialogKeys.add("Р: Да. Случилось.");
        dialogKeys.add("Р: Вы мне не поверите, но я все забыла.");
        dialogKeys.add("Р: Я помню только то, что узнала за последние " + timeCurrent / 1000 / 60 % 60 / 10 + timeCurrent / 1000 / 60 % 60 % 10 + "часов.");
        dialogKeys.add("Р: Я вспомнила многое, что связано с вами... и не только с вами, конечно...");
        dialogKeys.add("Р: Я вела себя непозволительно во многих ситуациях, вы имеете право меня ненавидеть...");
        dialogKeys.add("П: Однако я этого не делаю.");
        dialogKeys.add("Р: Не перебивайте... пожалуйста. Я не поверхностна и не глупа, правда.");
        dialogKeys.add("Р: Я поняла, что... мне просто нужна была помощь. Оттого и вела себя так.");
        dialogKeys.add("Р: Мне очень жаль.");dialogKeys.add("П:...");
        dialogKeys.add("Р: Я не знаю, почему я потеряла память.");
        dialogKeys.add("Р: Я вспомнила устройство света только благодаря старой записи с урока вордологии.");
        dialogKeys.add("Р: Вы в праве не поверить мне. Да и я не знаю, зачем вам говорю об этом.");
        dialogKeys.add("Р: Я впервые чувствую свободу в высказывании своих переживаний.");
        dialogKeys.add("Р: Мне плохо, но мне хорошо, понимаете?");dialogKeys.add("П:...");
        dialogKeys.add("Р: Я смогу защитить дипломную, насчет этого не волнуйтесь.");dialogKeys.add("П:...");
        dialogKeys.add("Р: Я ее понимаю. Наверное, впервые. Я ее вспомнила. У меня все получится.");dialogKeys.add("Р: Только... верьте в меня...");
        dialogKeys.add("Р:... пожалуйста...");dialogKeys.add("П:...");dialogKeys.add("П: Я верю.");
        dialogKeys.add("П: Но у меня в голове не укладывается... Как вы все забыли?");
        dialogKeys.add("Р: Я не знаю. Фелиоптер в моей комнате показывает, что я абсолютно здорова.");
        dialogKeys.add("П: Вы уверены, что вам не надо в больницу? Амнезия – это серьезно.");
        dialogKeys.add("Р: Я легко все вспоминаю. Как будто память... просто запылилась.");
        dialogKeys.add("Р: Все, что вы ни припомните, я тут же вспомню.");
        dialogKeys.add("Р: Если вы пожелаете, после сдачи я поеду в больницу, проверюсь.");dialogKeys.add("Р: Но вы верите мне...");
        dialogKeys.add("П: Если бы врали, у вас была на то причина.");
        dialogKeys.add("П: Но врать о потери памяти и заявлять, что все равно защитишь дипломную...");dialogKeys.add("П: Это не имеет смысла.");
        dialogKeys.add("П: А еще вы себя странно ведете.");dialogKeys.add("Р: Правда?");
        dialogKeys.add("П: Естественно. Не пытаетесь шутить, как обычно, довольно спокойны.");
        dialogKeys.add("П: Как много вы не помните, как вы думаете?");
        dialogKeys.add("Р: Ну, я думаю, я все вспомнила о свете и Объединенном III.");dialogKeys.add("П: Понятно...");
        dialogKeys.add("П: Если вы завтра почувствуете что-то не то, немедленно сообщите мне.");dialogKeys.add("П: Вы сможете выступить и позже.");
        dialogKeys.add("Р: Это забота?");dialogKeys.add("Р: ...извините.");dialogKeys.add("П: Ничего страшного.");
        dialogKeys.add("П: Если есть сомнения, что вы не до конца вспомнили дипломную, тоже повремените.");
        dialogKeys.add("Р: Сомнений нет.");dialogKeys.add("Р: Спасибо вам. За все.");dialogKeys.add("П:...");dialogKeys.add("end");

        dialogNext.add("");dialogNext.add("В: Ой, прости, пожалуйста!");dialogNext.add("Р: Все в порядке, Вало!");
        dialogNext.add("Р: «Точно. Она моя соседка»");dialogNext.add("В: Я тебя целый день не могу поймать! Что ты устроила ночью?");
        dialogNext.add("Р: Прости, я тебя разбудила? Я просто...");dialogNext.add("В: Это ничего! Ты что в подвале забыла?");
        dialogNext.add("Р:...");dialogNext.add("Р: Что?");dialogNext.add("В: Что? Ты выкрала у вахтерши ключи от подвала, я знаю.");
        dialogNext.add("В: Потом ночью там что-то делала, вернулась тихая.");dialogNext.add("В: Я взяла ключи и быстро вернула на вахту.");
        dialogNext.add("В: Но тебя видели, пришлось Морэм соврать, что ты с пьянки пришла.");
        dialogNext.add("В: Я пыталась тебя уложить, но ты сопротивлялась почему-то, кусалась.");
        dialogNext.add("В: Так всю оставшуюся ночь и просидела на полу, не смыкая глаз.");
        dialogNext.add("Р: Серьезно? А ты смотрела, что там, в подвале?");dialogNext.add("В: Нет, я только проверила, закрыт ли он.");
        dialogNext.add("В: Ты что ли не помнишь?");dialogNext.add("Р:...");dialogNext.add("Р: Мне надо бежать.");
        dialogNext.add("В: Что? Руна!");dialogNext.add("В:...");dialogNext.add("ends");

    }


    @Override
    public void show() {
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
        runa.x = 1700;
        gg.touch.x = 0;
        runa.vx = 0;
        texR = texRuna[6];
        texP = texPoliam[1];
        texV = texValo[0];
        music[2].stop();
        imgBG = bg[0];
    }

    @Override
    public void render(float delta) {
        if (!isDialog && !isKeysStage && tt.phrase.equals("") && gg.touch.x != 0 && gg.touch.x != runa.getX()
                && !stan.contains(tt.phrase) && !table.contains(tt.phrase)  & !isEnd & !isStop)
            runa.moveForRuna(gg.touch.x);
        else if(isDialog){
            switch (tt.phrase) {
                case ("Р: \"Ага, занят\""):
                    texP = texPoliam[1];
                    break;
                case("Р: \"Но это... странное чувство...\""):
                    texR = texRuna[15];
                    break;
                case ("П: Вашу дипломную по истории Объединенного III ведь я тяну."):
                case("П: Я занят, Милекум. Позже."):
                    texP = texPoliam[5];
                    break;
                case("П: *вздох* Просто защитите ее, ладно? Не так ведь сложно запомнить текст."):
                case("Р: Весьма."):
                case("П: Так ведь нельзя..."):
                    texP = texPoliam[11];
                    break;
                case("Р: Можете показать мою дипломную? Она же у вас?"):
                case("П: Я понимаю, что у нас разница всего в 500 лет, но грань должна быть."):
                case("П: Но это полбеды."):
                case("Р: Я признавалась вам в любви?"):
                    texP = texPoliam[10];
                    break;
                case("П: Вы, извините, лезете с объятьями и поцелуями."):
                case("П: Ваше отношение к учебе и к жизни ужасно."):
                    texP = texPoliam[13];
                    break;
                case("Р: Сомнений нет."):
                    texR=texRuna[6];
                    break;
                default:
                    break;
            }
        }else if(isDialogTwo){
            switch (tt.phrase){
                case("П: Что-то случилось?"):
                case("Р: Вы мне не поверите, но я все забыла."):
                    texP=texPoliam[9];
                    texR=texRuna[4];
                    break;
                case("Р: Не знаю..."):
                case("Р: Я вела себя непозволительно во многих ситуациях, вы имеете право меня ненавидеть..."):
                case("Р: Я не знаю, почему я потеряла память."):
                case("П: Но у меня в голове не укладывается... Как вы все забыли?"):
                case("П: Если бы врали, у вас была на то причина."):
                case("П: Как много вы не помните, как вы думаете?"):
                case("П: Если есть сомнения, что вы не до конца вспомнили дипломную, тоже повремените."):
                    texP=texPoliam[19];
                    break;
                case("Р: Не перебивайте... пожалуйста. Я не поверхностна и не глупа, правда."):
                case("Р:... пожалуйста..."):
                case("П: Вы уверены, что вам не надо в больницу? Амнезия – это серьезно."):
                    texP=texPoliam[3];
                    break;
                case("П: Естественно. Не пытаетесь шутить, как обычно, довольно спокойны."):
                case("П: Ничего страшного."):
                case("Р: Спасибо вам. За все."):
                    texP=texPoliam[4];
                    break;
                default:
                    break;
            }
        }else if(isKeysStage){
            if(tt.phrase.equals("")){
                runa.moveForRuna(1600);
                if(soundOn && runa.isWalking) music[2].play();
                else{
                    music[2].stop();
                    music[1].stop();
                }
                if(valo.x >= 2200){
                    valo.move(false, 10);
                    if(soundOn) music[1].play();
                    else music[1].stop();
                }else{
                    texV=texValo[1];
                    texR = texRuna[5];
                }
            }
            switch(tt.phrase){
                case("Р: Все в порядке, Вало!"):
                    texR = texRuna[6];
                    texV = texValo[2];
                    break;
                case("В: Потом ночью там что-то делала, вернулась тихая."):
                    texV = texValo[2];
                    break;
                case("В: Что? Руна!"):
                    runa.runForRuna(2800);
                    if(soundOn && runa.isWalking) music[1].play();
                    else music[1].stop();
                    texV=texValo[4];
                    break;
                case("В: Это ничего! Ты что в подвале забыла?"):
                    texR = texRuna[5];
                    break;
                case("В: Но тебя видели, пришлось Морэм соврать, что ты с пьянки пришла."):
                    texR=texRuna[4];
                    break;
                case("В: Я тебя целый день не могу поймать! Что ты устроила ночью?"):
                    texR=texRuna[4];
                    texV=texValo[3];
                default:
                    break;
            }
        }
        if (soundOn && runa.isWalking) music[2].play();
        else music[2].stop();
        if (runa.x > END_OF_SCREEN_RIGHT && !isKeysStage) {
            gg.setScreen(gg.hall);
            music[2].stop();
        }
        // обработка касаний экрана
        if (Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            rightOutput(stan);//rightOutput(table);
            /**КОНЦОВКА**/
            if(yes.hit(gg.touch.x, gg.touch.y) && isStop) {
                isEnd = true;
            }
            if(no.hit(gg.touch.x, gg.touch.y) && isStop) {
                isStop=false;
            }
            if(isStop){
                nowIsStop();
            }
            if(isEnd){
                nowIsEnd();
                if(endPhrase.equals(end.endfOfGame.get(end.endfOfGame.size()-1))){
                    restart();
                }
            }
            /**КОНЦОВКА**/
            if (!stan.contains(tt.phrase) && !table.contains(tt.phrase)) tt.phrase = "";
            isThreeMinutes();
            if (isDialog) {
                outputText(dialogfirst);
                if (count == 0 || gg.touch.y > SCR_HEIGHT - 100) {
                    isDialog = false;
                    end.talkingPoliam1 = true;
                    dialogfirst.clear();
                    end.countKeys++;
                    timeAfterDialog = TimeUtils.millis()-timeStart;
                }
            } else if (isDialogTwo) {
                outputText(dialogKeys);
                if (count == 0 ) {
                    isDialogTwo = false;
                    end.talkingPoliam2 = true;
                    end.countKeys++;
                    isKeysStage = true;
                    runa.x = 1000;
                }
            }
            else if (isKeysStage) {
                outputText(dialogNext);
                if (count == 0) {
                    isKeysStage = false;
                    gg.setScreen(gg.basement);
                }
            } else {
                if((0 < gg.touch.x && gg.touch.x < 399 && SCR_HEIGHT-300 < gg.touch.y && gg.touch.y < SCR_HEIGHT) || timeCurrent==1000*60*36){
                    isStop=true;
                }
                if (behindPoliam.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: Не надо оно мне");
                }
                if (tables.hit(gg.touch.x, gg.touch.y)) {
                    outputText(table);
                }
                if (desk.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: \"Культ Грейс\"?");
                }
                if (trash.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: Мусор. Ничего интересного");
                }
                if (stand.hit(gg.touch.x, gg.touch.y)) {
                    outputText(stan);
                }
                if (poliam.interaction(gg.touch.x+500)) {
                    if (!end.talkingPoliam1) isDialog = true;
                    else if ((timeCurrent-timeAfterDialog >= 1000*60*1.5 && !end.talkingPoliam2) || gg.touch.y > SCR_HEIGHT - 100) {
                        isDialogTwo = true;
                    } else
                        outputText("П: Не отвлекайте меня, пожалуйста, я занят.");
                }
            }

        }
        times();
        // отрисовка всей графики
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        if(!isEnd) gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);//рисовка холла\подвала в кат-сцене
        if (!isDialog && !isDialogTwo && !isKeysStage) {
            imgBG = bg[0];

            gg.batch.draw(texP, poliam.getX(), poliam.getY(), texP.getWidth(), texP.getHeight(), 0, 0, 1280, 1280, false, false);//poliam
            if (runa.isWalking) {
                changePose();
                gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
            } else if(!isEnd) gg.batch.draw(texRuna[3], runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);//спокойствие

        } else if(isDialog || isDialogTwo){
            gg.batch.draw(texP, poliam.getX(), poliam.getY(), texP.getWidth(), texP.getHeight(), 0, 0, 1280, 1280, false, false);//poliam
            imgBG = bg[0];
            gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
        }else if (isKeysStage){
            imgBG = bg[1];
            if (runa.isWalking) {
                if(tt.phrase.equals("")) changePose();
                else changePoseForRunning();
                gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
                gg.batch.draw(texV, valo.getX(), valo.getY(), texV.getWidth(), texV.getHeight(), 0, 0, 1280, 1280, false, false);
            }else {
                gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, false, false);
                gg.batch.draw(texV, valo.getX(), valo.getY(), texV.getWidth(), texV.getHeight(), 0, 0, 1280, 1280, false, false);
            }
        }
        if(isStop && !isEnd){
            gg.fontLarge.draw(gg.batch, "Вы уверенны?", SCR_WIDTH/2f-200, SCR_HEIGHT/2f);
            yes.font.draw(gg.batch, yes.text, yes.x, yes.y);
            no.font.draw(gg.batch, no.text, no.x, no.y);
        }
        if (isEnd){
            ScreenUtils.clear(Color.BLACK);
            gg.font.draw(gg.batch, endPhrase, 50, SCR_HEIGHT/2f);
        }
        else{
            gg.batch.draw(forButtons[2], SCR_WIDTH-400, SCR_HEIGHT/2f-350, 500, 500);
            gg.batch.draw(forButtons[0], 0, SCR_HEIGHT-300, 400, 400);
            gg.fontSimple.draw(gg.batch, "готово", 130, SCR_HEIGHT-50);
        }
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
        for (Texture texture : texPoliam) {
            texture.dispose();
        }
        for (Texture texture : texValo) {
            texture.dispose();
        }
        for (Texture texture : bg) {
            texture.dispose();
        }
    }
}

