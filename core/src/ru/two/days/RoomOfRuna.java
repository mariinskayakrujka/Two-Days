package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;
import static ru.two.days.TwoDays.end;
import static ru.two.days.TwoDays.timeCurrent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class RoomOfRuna extends ScreenGame {
    Objects feliopter, bed, bottles, clothes, cup, paper, docWithDairy;

    boolean isIntro = true, isAfterIntro, havingKeys;//havingKeys меняется только после кат-сцены в подвале

    Texture imgBG;
    TwoDays gg;

    String dairy = " 1.4\n" +
            "Мы вышли на учебу. Я поздоровалась с ним, а он вдруг улыбнулся и спросил,\n " +
            "как я провела каникулы. Я призналась, что вообще не запомнила ни дня из них и засмеялась,\n " +
            "но он стал таким серьезным, как будто его волнует, что со мной. \n" +
            "Я сходила только на математику и ушла в общежитие, потому что уже нет сил почему-то.\n" +
            " Кайден Морэм как-то подкольнула меня, что я и начало учебы пропускаю, потом почему-то разозлилась, ушла...\n" +
            "8.6.\n" +
            "Я подарила ему цветы. Он сказал, что это лишнее и даже в руки не стал брать.\n " +
            "Это же просто цветы... пришлось снова отшутиться, сказать что-то глупое и мерзкое (я не помню уже что),\n " +
            "от чего он нахмурился и молча ушел. У меня еще есть время, целый семестр впереди.\n" +
            "15.8.\n" +
            "Все почти готово. Я читала – вроде неплохо. Ему не нравится, но он мирится с этим и \n" +
            "даже приободряет что ли. Но он не отпускает работу. Он все пытается в ней что-то изменить.\n " +
            "Я сегодня видела, как он долго с карандашом в руке сидел и пытался придумать, что сделать с каким-то предложением:\n " +
            "он скрупулезен и придирчив даже к себе. Я говорила, что все хорошо, но он на такие реплики даже не реагирует. \n" +
            "13.10.\n" +
            "Я звонила ему сегодня по поводу темы. Мне не нравится тема. Это удручает.\n " +
            "Ему тоже не нравится, но он говорит, что это самое легкое. Я его разочаровываю, чувствую.\n " +
            "Надо было думать об этом шесть четыре года назад, когда я писала курсовые на эту тему.\n" +
            "30.13.\n" +
            "Одолела странная печаль. Мне кажется, я пропускаю настоящую жизнь и трачу ее на\n " +
            "какие-то глупые мелочи. Я пришла в пять утра, меня пустили, потому что, наверное, пожалели.\n " +
            "У меня потекла тушь, футболка была в грязи, растрепались волосы. Я так и не заснула, в академию не пошла,\n " +
            "потому что не могу справиться с этими мыслями, лежу, даже не разделась, не умылась: мне очень плохо. \n" +
            "Я поняла, что хочу любви. Достойна ли я ее? Мне хочется, чтобы кто-нибудь смотрел \n" +
            "на меня с таким счастьем в глазах, чтобы для кого-то я правда много значила, чтобы кто-то думал обо мне и улыбался.\n " +
            "Меня бы хотели обнять, поцеловать, пригреть у груди, сказать, что я хорошая, что им очень со мной повезло. \n" +
            "Однажды, когда-то давно, на курсе четвертом, ведь он повел себя со мной очень хорошо.\n " +
            "Он стал меня успокаивать, вытер слезы, дал салфетки и какую-то конфету, сказал, что все проблемы временны, \n" +
            "какими бы большими они ни казались, а я все тогда плакала, плакала... Если бы только сочувствие рождало любовь... \n" +
            "в свете все было бы гораздо проще.\n" +
            "4.14.\n" +
            "Он остался после пары, сел ко мне и спросил, почему я заплакала в середине пары. \n" +
            "Он видел. Мне стало дурно, я отшутилась, что вспомнила видеоролик о бездомных собаках, когда он \n" +
            "рассказывал о итогах революции. Я не сентиментальна. Он ушел, не сказав ни слова, а я еще где-то \n" +
            "минут десять плакала в пустой аудитории, пока не пришла другая группа.\n" +
            "29.15.\n" +
            "Я сходила впервые за этот семестр сходила на вордологию. Все смеялись, что я \"выделила место \n" +
            "в своем плотном графике и соизволила прийти\". Димен Стю не смеялся, но и не останавливал группу. \n" +
            "Всех заткнул только ректор, услышавший шум и зашедший к нам. Ему сказали, что такая шумиха из-за меня.\n" +
            " А он ответил, что это все еще не повод смеяться. Я посидела еще минут пять после его ухода и убежала из аудитории.\n" +
            " Мне опять было очень тяжело и больно.\n" +
            "1.16.\n" +
            "Все летит в тартарары. Я пытаюсь сосредоточиться на строчке, но буквы словно расплываются,\n " +
            "ни слова не могу прочитать. Вало попыталась прочитать мне, но так еще хуже: я остановила.\n " +
            "Я без понятия, как мне это защищать. Это уже больше не имеет смысла.\n" +
            "10.18.\n" +
            "Кайден Морэм меня гоняет. Ей кажется, что если я хотя бы час посижу на месте,\n " +
            "позову «пьяжков»(ее слово). Такого не происходило уже месяц, но она непреклонна. Поэтому пришлось драить полы.\n " +
            "Я устала до того, что свалилась в обморок прямо посреди коридора. Кайден думает, что это от алкоголя.\n" +
            "Я знаю, она не поверит в мои ментальные проблемы.\n" +
            "20.18.\n" +
            "Наконец все готово! Впервые за долгое время чувствую настоящее счастье, хотя плачу, пока пишу это.\n " +
            "Мне нужно только дождаться ночи. Осталось совсем немного, я верю, в этот раз все получится.\n " +
            "Я не могу оплошать перед ним, это очень важно для меня. Может, он наконец полюбит меня. Я очень хочу этого.\n " +
            "Он – единственное, что у меня осталось... Поэтому и иду на такие риски. Мама бы прибила меня за это,\n" +
            " но она не рядом: мне никто не помешает. Только бы дождаться... только бы...\n";

    String pape = "Я собрала все необходимое: четыре свечи, красный мелок(пришлось стащить у Ст), немного черной соли.\n " +
            "На этот раз все должно получится. \n" +
            "Если не получится, то я не знаю, что мне еще сделать.\n";

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
        music[0].stop();
        if(isIntro) runa.x = 400;
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
        if(isIntro) kaiden.vx = -1;
        if (isAfterIntro){
            kaiden.move(true, 10);
            if(soundOn && kaiden.x < SCR_WIDTH) music[0].play();
            else music[0].stop();
        }
        if (!isIntro && !isAfterIntro) {
            if (tt.phrase.equals("") && gg.touch.x != runa.getX() && gg.touch.x != 0
                    && !feli.contains(tt.phrase)) {
                runa.moveForRuna(gg.touch.x);
            }
            if (soundOn && runa.isWalking) music[0].play();
            else music[0].stop();
        }
        if (runa.x >= END_OF_SCREEN_RIGHT) {
            gg.setScreen(gg.roomOfValo);
            music[0].stop();
        }
        if (runa.x <= END_OF_SCREEN_LEFT) {
            if (end.recordOfLesson) {
                gg.setScreen(gg.hall);
                music[0].stop();
            } else outputText("Р: Я не выйду. Я совсем ничего не помню и не понимаю.");
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
                }changeTexture();
            }
            if (isAfterIntro) {
                outputText(afterintro);
                if (count == 0) {
                    isAfterIntro = false;
                }changeTexture();
            }

            if (!isIntro && !isAfterIntro) {
                isThreeMinutes();
                rightOutput(feli);
                System.out.println("RUNA" + gg.touch.x + " " + gg.touch.y);
                if (!feli.contains(tt.phrase)) tt.phrase = "";
                if (feliopter.hit(gg.touch.x, gg.touch.y)) {
                    outputText(feli);
                    if (tt.phrase.equals(feli.get(2)))
                        texR = texRuna[4];//серьезность
                }
                if (clothes.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: Мне сейчас не до того, чтобы разбирать эту кучу.");
                }
                if (bed.hit(gg.touch.x, gg.touch.y)) {
                    if (timeCurrent < 1000 * 60 * 3) outputText("Р: Пока я не хочу спать.");
                    else {
                        outputText("Р: Мне правда стоит передохнуть.");
                        texR = texRuna[5];
                        outputText("Р: Я поспала.");
                        if(!end.sleeping) {
                            end.sleeping = true;
                            end.countKeys++;
                        }
                        // ключевой момент
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
        }times();

        //отрисовка
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        //отрисовка интро
        if (isIntro) {
            texR = texRuna[0];
            changeTexture();
            gg.batch.draw(texK, kaiden.getX(), kaiden.getY(), texK.getWidth(), texK.getHeight(), 0, 0, 1280, 1280, !kaiden.isFlip(), false);
            gg.batch.draw(texR, runa.getX(), -20);
        } else if (isAfterIntro) {
            changeTexture();
            gg.batch.draw(texKaiden[kaiden.faza + 7], kaiden.getX(), kaiden.getY());
            gg.batch.draw(texR, runa.getX(), -20);
        }
        if (!isIntro && !isAfterIntro) {
            if (runa.isWalking) {
                changePose();
                gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
            } else gg.batch.draw(texRuna[3], runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);//спокойствие
            gg.batch.draw(forButtons[1], 0, SCR_HEIGHT/2f-350, 500, 500);
            gg.batch.draw(forButtons[2], SCR_WIDTH-400, SCR_HEIGHT/2f-350, 500, 500);
        }
        /*if(isReading){
            gg.batch.draw(texPaper, 0, 20);
            gg.batch.draw(button, SCR_WIDTH*7/8f, 0, 250, 250);
            gg.batch.draw(button1, SCR_WIDTH/8f, 0, 250, 250);
        }*/
        gg.font.draw(gg.batch, timeCurrent+"", 200, 600);
        gg.font.draw(gg.batch, tt.phrase, tt.getX(), tt.getY());
        gg.batch.end();

    }


    public void changeTexture() {
        if (tt.phrase.equals(intro.get(12)) || tt.phrase.equals(intro.get(13)) ||
                tt.phrase.equals(intro.get(14))) texK = texKaiden[0];//calm
        else texK = texKaiden[2];//angry


        if (tt.phrase.equals(afterintro.get(2)) || tt.phrase.equals(afterintro.get(3)) ||
                tt.phrase.equals(afterintro.get(7)) || tt.phrase.equals(afterintro.get(8)))
            texR = texRuna[1];
        else texR = texRuna[2];
    }


    @Override
    public void dispose() {
        super.dispose();
    }
}
