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

import java.util.ArrayList;

public class RoomOfRuna extends ScreenGame {
    Objects feliopter, bed, bottles, clothes, cup, paper, docWithDairy;

    int countpaper = 0;
    boolean isIntro = true, isAfterIntro, isReading,
            isPaper;//havingKeys меняется только после кат-сцены в подвале
    boolean isTextAfterReading;

    Texture imgBG, letter;
    TwoDays gg;
    String dairy1 = " 1.4\n" +
            "Мы вышли на учебу. Я поздоровалась с ним, а он вдруг улыбнулся и спросил,\n " +
            "как я провела каникулы. Я призналась, что вообще не запомнила ни дня из них\n и засмеялась, " +
            "но он стал таким серьезным, как будто его волнует, что со\n мной. " +
            "Я сходила только на математику и ушла в общежитие, потому что\n уже нет сил почему-то." +
            " Кайден Морэм как-то подкольнула меня, что я и начало учебы\n пропускаю, потом почему-то разозлилась, ушла..." +
            "8.6.\n" +
            "Я подарила ему цветы. Он сказал, что это лишнее и даже в руки не стал брать.\n " +
            "Это же просто цветы... пришлось снова отшутиться, сказать что-то глупое\n и мерзкое (я не помню уже что), " +
            "от чего он нахмурился и молча ушел. У меня еще есть время,\n  целыйсеместр впереди.";
    String dairy2 = "15.8.\n" +
            "Все почти готово. Я читала – вроде неплохо. Ему не нравится, но он\n мирится с этим и " +
            "даже приободряет что ли. Но он не отпускает работу. Он все пытается\n в ней что-то изменить. " +
            "Я сегодня видела, как он долго с карандашом в руке сидел и\n пытался придумать, что сделать с каким-то предложением: " +
            "он скрупулезен и придирчив даже к себе. Я говорила,\n что все хорошо, но он на такие реплики даже не реагирует. " +
            "13.10.\n" +
            "Я звонила ему сегодня по поводу темы. Мне не нравится тема. Это удручает.\n " +
            "Ему тоже не нравится, но он говорит, что это самое легкое. Я его разочаровываю,\n  чувствую." +
            "Надо было думать об этом четыре года назад, когда я писала курсовые\n на эту тему." +
            "30.13.\n" +
            "Одолела странная печаль. Мне кажется, я пропускаю настоящую жизнь и трачу ее на\n " +
            "какие-то глупые мелочи. Я пришла в пять утра, меня пустили, потому что,\n наверное, пожалели. " +
            "У меня потекла тушь, футболка была в грязи, растрепались волосы.\n Я так и не заснула, в академию не пошла, " +
            "потому что не могу справиться с этими мыслями, лежу, даже не\n разделась, не умылась: мне очень плохо. ";
    String dairy3 = "Я поняла, что хочу любви. Достойна ли я ее? Мне хочется,\n чтобы кто-нибудь смотрел " +
            "на меня с таким счастьем в глазах, чтобы для кого-то я правда много\n значила, чтобы кто-то думал обо мне и улыбался. " +
            "Меня бы хотели обнять, поцеловать, пригреть у груди, сказать,\n что я хорошая, что им очень со мной повезло. " +
            "Однажды, когда-то давно, на курсе четвертом,\n ведь он повел себя со мной очень хорошо. " +
            "Он стал меня успокаивать, вытер слезы, дал салфетки\n и какую-то конфету, сказал, что все проблемы временны,\n " +
            "какими бы большими они ни казались, а я все тогда плакала,\n плакала... Если бы только сочувствие рождало любовь... \n" +
            "в свете все было бы гораздо проще.\n" +
            "4.14.\n" +
            "Он остался после пары, сел ко мне и спросил, почему я заплакала в середине пары. \n" +
            "Он видел. Мне стало дурно, я отшутилась, что вспомнила видеоролик\n о бездомных собаках, когда он " +
            "рассказывал о итогах революции. Я не сентиментальна. Он ушел,\n не сказав ни слова, а я еще где-то " +
            "минут десять плакала в пустой аудитории,\n пока не пришла другая группа.\n";
    String dairy4 = "29.15.\n" +
            "Я сходила впервые за этот семестр сходила на вордологию. Все смеялись,\n что я \"выделила место " +
            "в своем плотном графике и соизволила прийти\". Димен Стю не смеялся,\n но и не останавливал группу. " +
            "Всех заткнул только ректор, услышавший шум и зашедший к нам. Ему сказали,\n что такая шумиха из-за меня." +
            " А он ответил, что это все еще не повод смеяться. Я посидела еще\n минут пять после его ухода и убежала из аудитории.\n" +
            " Мне опять было очень тяжело и больно.\n" +
            "1.16.\n" +
            "Все летит в тартарары. Я пытаюсь сосредоточиться на строчке,\n но буквы словно расплываются, " +
            "ни слова не могу прочитать. Вало попыталась прочитать мне, но\n так еще хуже: я остановила. " +
            "Я без понятия, как мне это защищать.\n Это уже больше не имеет смысла.\n";
    String dairy5 = "10.18.\n" +
            "Кайден Морэм меня гоняет. Ей кажется, что если я хотя бы\n час посижу на месте, " +
            "позову «пьяжков»(ее слово). Такого не происходило уже месяц, но она\n непреклонна. Поэтому пришлось драить полы.\n " +
            "Я устала до того, что свалилась в обморок прямо посреди коридора.\n Кайден думает, что это от алкоголя.\n" +
            "Я знаю, она не поверит в мои ментальные проблемы.\n" +
            "20.18.\n" +
            "Наконец все готово! Впервые за долгое время чувствую настоящее\n счастье, хотя плачу, пока пишу это.\n " +
            "Мне нужно только дождаться ночи. Осталось совсем немного,\n я верю, в этот раз все получится.\n " +
            "Я не могу оплошать перед ним, это очень важно для меня.\n Поэтому и иду на такие риски. Мама бы прибила меня за это,\n" +
            " но она не рядом: мне никто не помешает.\n Только бы дождаться... только бы...\n";

    String print = dairy1;
    String pape = "Я собрала все необходимое: четыре свечи, красный мелок(пришлось стащить у Ст),\n " +
            "немного черной соли. На этот раз все должно получится. \n" +
            "Если не получится, то я не знаю, что мне еще сделать.\n";

    ArrayList<String> intro = new ArrayList<>(), afterintro = new ArrayList<>(), feli = new ArrayList<>();

    public RoomOfRuna(TwoDays myGG) {
        super(myGG);
        gg = myGG;
        feliopter = new Objects(1380, 1042, 1636 - 1380, 31406 - 1042);
        bed = new Objects(0, 310, 1038, 602 - 310);
        bottles = new Objects(0, 256, 1016, 310 - 256);
        clothes = new Objects(1040, 208, 1374 - 1040, 454 - 208);
        cup = new Objects(1648, 768, 1730 - 1648, 852 - 768);
        imgBG = new Texture("bg/bg0.png");
        paper = new Objects(622, 198, 744 - 622, 256 - 198);
        docWithDairy = new Objects(1508, 246, 1714 - 1508, 384 - 246);
        letter = new Texture("letter.png");
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


    }

    @Override
    public void show() {
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
        music[0].stop();
        kaiden.x = SCR_WIDTH*3/4f;
        if (isIntro) runa.x = 400;
        else {
            if (gg.touch.x > 1600) runa.x = 400;
            else runa.x = 1600;
        }
        gg.touch.x = 0;
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
        if (isIntro) kaiden.vx = -1;
        if (isAfterIntro) {
            kaiden.move(true, 10);
            if (soundOn && kaiden.x < SCR_WIDTH) music[0].play();
            else music[0].stop();
        }

        if (!isIntro && !isAfterIntro & !isEnd & !isStop) {
            if (tt.phrase.equals("") && gg.touch.x != runa.getX() && gg.touch.x != 0
                    && !feli.contains(tt.phrase) && !isReading) {
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
            /**КОНЦОВКА**/
            if (yes.hit(gg.touch.x, gg.touch.y) && isStop) {
                isEnd = true;
            }
            if (no.hit(gg.touch.x, gg.touch.y) && isStop) {
                isStop = false;
            }
            if (isStop) {
                nowIsStop();
            }
            if (isEnd) {
                nowIsEnd();
                if (endPhrase.equals(end.endfOfGame.get(end.endfOfGame.size() - 1))) {
                    restart();
                }
            }
            /**КОНЦОВКА**/
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
            if (isTextAfterReading) {
                isTextAfterReading = false;
            }

            if (!isIntro && !isAfterIntro) {
                if (isReading) {
                    if (isPaper || countpaper == 5 || countpaper==-1) {
                        isReading = false;
                        isTextAfterReading = true;
                    } else {
                        if (gg.touch.x >= END_OF_SCREEN_RIGHT - 200) countpaper++;
                        if (gg.touch.x <= END_OF_SCREEN_LEFT) countpaper--;
                        switch (countpaper) {
                            case 0:
                                print = dairy1;
                                break;
                            case 1:
                                print = dairy2;
                                break;
                            case 2:
                                print = dairy3;
                                break;
                            case 3:
                                print = dairy4;
                                break;
                            case 4:
                                print = dairy5;
                                break;
                            case 5:
                                print = "";
                                break;
                            default:
                                break;
                        }
                    }

                }
                rightOutput(feli);
                if ((0 < gg.touch.x && gg.touch.x < 399 && SCR_HEIGHT - 300 < gg.touch.y && gg.touch.y < SCR_HEIGHT) || timeCurrent == 1000 * 60 * 36)
                    isStop = true;
                isThreeMinutes();
                if (!isReading && !feli.contains(tt.phrase)) tt.phrase = "";
                if (feliopter.hit(gg.touch.x, gg.touch.y)) {
                    outputText(feli);
                    if (tt.phrase.equals(feli.get(2)))
                        texR = texRuna[4];//серьезность
                }
                if (paper.hit(gg.touch.x, gg.touch.y)) {
                    isReading = true;
                    isPaper = true;
                    if (!end.dairy) {
                        end.dairy = true;
                        end.countKeys++;
                    }
                }
                if (docWithDairy.hit(gg.touch.x, gg.touch.y)) {
                    if (Basement.ishavingKey) {
                        countpaper=0;
                        isReading = true;
                        isPaper = false;
                        if (!end.docAbenrollment) {
                            end.docAbenrollment = true;
                            end.countKeys++;
                        }
                    } else outputText("Р: Здесь книжка, но... она закрыта на замочек.");

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
                        if (!end.sleeping) {
                            end.sleeping = true;
                            end.countKeys++;
                        }
                    }
                }
                if (bottles.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: ...Мне правда стыдно.");
                }
                if (cup.hit(gg.touch.x, gg.touch.y)) {
                    outputText("Р: Пахнет алкоголем и чабрецом одновременно.");
                }
            }
            times();
        }
        //отрисовка
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        if (!isEnd && !isReading) gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
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
        if (!isIntro && !isAfterIntro && !isEnd && !isReading) {
            if (runa.isWalking) {
                changePose();
                gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
            } else
                gg.batch.draw(texRuna[3], runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);//спокойствие
            gg.batch.draw(forButtons[0], 0, SCR_HEIGHT - 300, 400, 400);
            gg.fontSimple.draw(gg.batch, "готово", 130, SCR_HEIGHT - 50);
            gg.batch.draw(forButtons[1], 0, SCR_HEIGHT / 2f - 350, 500, 500);
            gg.batch.draw(forButtons[2], SCR_WIDTH - 400, SCR_HEIGHT / 2f - 350, 500, 500);
        }

        if (isReading) {
            if (isPaper) {
                ScreenUtils.clear(1, 1, 1, 1);
                gg.fontMassovka.draw(gg.batch, pape, 100, 1000);
            } else {
                ScreenUtils.clear(1, 1, 1, 1);
                if (countpaper != 5) {
                    gg.fontMassovka.draw(gg.batch, print, 100, 1400);
                } else
                    gg.batch.draw(letter, SCR_WIDTH / 2f - letter.getWidth() / 2f, SCR_HEIGHT / 2f - letter.getHeight() / 2f);
                gg.batch.draw(forButtons[3], SCR_WIDTH - 400, SCR_HEIGHT / 2f - 350, 500, 500);
                gg.batch.draw(forButtons[4], 0, SCR_HEIGHT / 2f - 350, 500, 500);
            }
        } else if (isTextAfterReading) {
            if (isPaper) outputText("Р: Что бы это могло быть?..");
            else outputText("Р: Это стоило выкинуть из памяти...");
        }
        if (isStop && !isEnd) {
            gg.fontLarge.draw(gg.batch, "Вы уверенны?", SCR_WIDTH / 2f - 200, SCR_HEIGHT / 2f);
            yes.font.draw(gg.batch, yes.text, yes.x, yes.y);
            no.font.draw(gg.batch, no.text, no.x, no.y);
        }
        if (isEnd) {
            ScreenUtils.clear(Color.BLACK);
            gg.font.draw(gg.batch, endPhrase, 50, SCR_HEIGHT / 2f);
        }
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
        imgBG.dispose();
        super.dispose();
    }
}
