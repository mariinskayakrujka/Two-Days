package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;
import static ru.two.days.TwoDays.timeCurrent;

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
        dialogfirst.add("Р: Здравствуйте, Ст.");dialogfirst.add("П: Я занят, Милекум. Позже.");
        dialogfirst.add("Р: \"Ага, занят\"");dialogfirst.add("Р: \"Ему точно не стоит говорить, что я все забыла\"");
        dialogfirst.add("Р: \"Но это... странное чувство...\"");dialogfirst.add("Р: Морэм сказала, что удивлена, как вы со мной решили работать.");
        dialogfirst.add("П: Я уверен, она это часто говорит.");dialogfirst.add("Р: \"Ни грамма такта\"");
        dialogfirst.add("Р: \"Судя по словам Морэм, я это заслужила\"");dialogfirst.add("Р: \"Видимо, я правда в него влюблена...\"");
        dialogfirst.add("Р: \"Со мной даже сейчас что-то происходит, когда я все забыла\"");dialogfirst.add("Р:...");
        dialogfirst.add("П: Вашу дипломную по истории Объединенного III ведь я тяну.");
        dialogfirst.add("П: *вздох* Просто защитите ее, ладно? Не так ведь сложно запомнить текст.");
        dialogfirst.add("Р: Можете показать мою дипломную? Она же у вас?");dialogfirst.add("П: Естественно. Вам нельзя подобное доверять.");
        dialogfirst.add("Р:...");dialogfirst.add("Р: Биография Грейс Энджер? Как-то...");
        dialogfirst.add("П: Посредственно.");dialogfirst.add("Р: Просто.");
        dialogfirst.add("П: Ваш уровень.");dialogfirst.add("Р: ...");
        dialogfirst.add("П:...");dialogfirst.add("П: Я груб, да?");
        dialogfirst.add("Р: Весьма.");dialogfirst.add("Р: \"Обидно. Очень\"");
        dialogfirst.add("П: Простите. Вы должны понимать, что у меня есть причины.");dialogfirst.add("Р:...");
        dialogfirst.add("П: Я понимаю, что у нас разница всего в 500 лет, но грань должна быть.");dialogfirst.add("П: Мне надо вас учить, а вы...");
        dialogfirst.add("П: Вы, извините, лезете с объятьями и поцелуями.");dialogfirst.add("П: Но это полбеды.");
        dialogfirst.add("П: Ваше отношение к учебе и к жизни ужасно.");dialogfirst.add("П: Для вас не существует никто и ничто, кроме меня и каких-то развлечений.");
        dialogfirst.add("П: Так ведь нельзя...");dialogfirst.add("Р: Я признавалась вам в любви?");
        dialogfirst.add("П: ...");dialogfirst.add("П: Не раз. Странно, что вы забыли.");
        dialogfirst.add("Р: Я уточнила.");dialogfirst.add("Р: \"Какой стыд. Я перед ним очень виновата\"");
        dialogfirst.add("П: Вы сегодня странны. Что вы хотели?");dialogfirst.add("Р: Я могу забрать дипломную?");
        dialogfirst.add("П: Только аккуратнее, пожалуйста. У меня нет копий.");dialogfirst.add("Р: Не волнуйтесь, я буду осторожна.");
        dialogfirst.add("П:...");dialogfirst.add("end");


        dialogKeys.add("П: Что-то случилось?");dialogKeys.add("Р: Не знаю...");
        dialogKeys.add("Р: Да. Случилось.");dialogKeys.add("Р: Вы мне не поверите, но я все забыла.");
        dialogKeys.add("Р: Я помню только то, что узнала за последние " + timeCurrent/1000/60%60/10 + timeCurrent/1000/60%60%10 + "часов.");
        dialogKeys.add("Р: Я вспомнила многое, что связано с вами... и не только с вами, конечно...");
        dialogKeys.add("Р: Я вела себя непозволительно во многих ситуациях, вы имеете право меня ненавидеть...");
        dialogKeys.add("П: Однако я этого не делаю.");
        dialogKeys.add("Р: Не перебивайте... пожалуйста. Я не поверхностна и не глупа, правда.");
        dialogKeys.add("Р: Я поняла, что... мне просто нужна была помощь. Оттого и вела себя так.");dialogKeys.add("Р: Мне очень жаль.");
        dialogKeys.add("П:...");dialogKeys.add("Р: Я не знаю, почему я потеряла память.");
        dialogKeys.add("Р: Я вспомнила устройство света только благодаря старой записи с урока вордологии.");
        dialogKeys.add("Р: Вы в праве не поверить мне. Да и я не знаю, зачем вам говорю об этом.");
        dialogKeys.add("Р: Я впервые чувствую свободу в высказывании своих переживаний.");dialogKeys.add("Р: Мне плохо, но мне хорошо, понимаете?");
        dialogKeys.add("П:...");dialogKeys.add("Р: Я смогу защитить дипломную, насчет этого не волнуйтесь.");
        dialogKeys.add("П:...");dialogKeys.add("Р: Я ее понимаю. Наверное, впервые. Я ее вспомнила. У меня все получится.");
        dialogKeys.add("Р: Только... верьте в меня...");dialogKeys.add("Р:... пожалуйста...");
        dialogKeys.add("П:...");dialogKeys.add("П: Я верю.");
        dialogKeys.add("П: Но у меня в голове не укладывается... Как вы все забыли?");
        dialogKeys.add("Р: Я не знаю. Фелиоптер в моей комнате показывает, что я абсолютно здорова.");
        dialogKeys.add("П: Вы уверены, что вам не надо в больницу? Амнезия – это серьезно.");
        dialogKeys.add("Р: Я легко все вспоминаю. Как будто память... просто запылилась.");
        dialogKeys.add("Р: Все, что вы ни припомните, я тут же вспомню.");dialogKeys.add("Р: Если вы пожелаете, после сдачи я поеду в больницу, проверюсь.");
        dialogKeys.add("Р: Но вы верите мне...");dialogKeys.add("П: Если бы врали, у вас была на то причина.");
        dialogKeys.add("П: Но врать о потери памяти и заявлять, что все равно защитишь дипломную...");dialogKeys.add("П: Это не имеет смысла.");
        dialogKeys.add("П: А еще вы себя странно ведете.");dialogKeys.add("Р: Правда?");
        dialogKeys.add("П: Естественно. Не пытаетесь шутить, как обычно, довольно спокойны.");dialogKeys.add("П: Как много вы не помните, как вы думаете?");
        dialogKeys.add("Р: Ну, я думаю, я все вспомнила о свете и Объединенном III.");dialogKeys.add("П: Понятно...");
        dialogKeys.add("П: Если вы завтра почувствуете что-то не то, немедленно сообщите мне.");dialogKeys.add("П: Вы сможете выступить и позже.");
        dialogKeys.add("Р: Это забота?");dialogKeys.add("Р: ...извините.");
        dialogKeys.add("П: Ничего страшного.");dialogKeys.add("П: Если есть сомнения, что вы не до конца вспомнили дипломную, тоже повремените.");
        dialogKeys.add("Р: Сомнений нет.");dialogKeys.add("Р: Спасибо вам. За все.");
        dialogKeys.add("П:...");dialogKeys.add("end");

     /*
        В: Ой, прости, пожалуйста!
                Р: Все в порядке, Вало!
                Р: «Точно. Она моя соседка»
        В: Я тебя целый день не могу поймать! Что ты устроила ночью?
                Р: Прости, я тебя разбудила? Я просто...
        В: Это ничего! Ты что в подвале забыла?
        Р:...
        Р: Что?
                В: Что? Ты выкрала у вахтерши ключи от подвала, я знаю.
                В: Потом ночью там что-то делала, вернулась тихая.
                В: Я взяла ключи и быстро вернула на вахту.
        В: Но тебя видели, пришлось Морэм соврать, что ты с пьянки пришла.
        В: Я пыталась тебя уложить, но ты сопротивлялась почему-то, кусалась.
                В: Так всю оставшуюся ночь и просидела на полу, не смыкая глаз.
        Р: Серьезно? А ты смотрела, что там, в подвале?
                В: Нет, я только проверила, закрыт ли он.
        В: Ты что ли не помнишь?
                Р:...
        Р: Мне надо бежать.
                В: Что? Руна!
                В:...
*/
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
        gg.batch.draw();//poliam
        if(isDialog){

        }else {
            if (runa.isWalking) {
                changePose();
                gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
            } else
                gg.batch.draw(texRuna[3], runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);//спокойствие
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

    }
}

