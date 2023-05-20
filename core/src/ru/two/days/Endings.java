package ru.two.days;

import java.util.ArrayList;
import java.util.List;


public class Endings {
    boolean recordOfLesson,//+
            talkingPoliam1,//+
            docAbenrollment,
            dairy,//+
            talkingKaiden,//+
            talkingPoliam2,//+
            sleeping;//+
    int countKeys;
    Text tt;
    public ArrayList<String> endfOfGame = new ArrayList<>();

    public Endings() {

    }

    public void whatIsEnd() {
        endfOfGame.add("Собрано " + countKeys + " из 7 ключевых моментов.");
        endfOfGame.add("День защиты.");
        if ((countKeys == 7) || (countKeys == 6 && !dairy)) goodEnding();
        else if (countKeys == 6 && !sleeping) sleepWithPoliam();

        else if ((countKeys == 0) ||
                (countKeys == 1 && (sleeping || dairy)) ||
                (countKeys == 2 && sleeping && dairy)) badEnding();

        else if (recordOfLesson && !talkingKaiden) {
            if (sleeping) faintingAfterTravel();
            else faintingInTravel();
        } else if (talkingKaiden && !talkingPoliam1) {
            if (sleeping) {
                if (dairy)
                    welcomeHomeThink();
                else welcomeHomeWithoutThink();
            } else faintingToParents();
        } else if (talkingPoliam1 && !talkingPoliam2 && sleeping) memoriesWithoutPoliam();
        else if (talkingPoliam1 && !sleeping && !talkingPoliam2) faintingInProtection();

        else if (!docAbenrollment && talkingPoliam2 && !sleeping &&
                (countKeys == 5 || countKeys == 4 && !dairy)) memories();
        else if (!docAbenrollment && (countKeys == 6 || countKeys == 5 && !dairy)) maybeHappiness();
    }

    void faintingInTravel() {
        endfOfGame.add("Руна даже не пришла в академию.");
        endfOfGame.add("Всю ночь она не спала, сидела\n как на иголках.");
        endfOfGame.add("Только солнце вышло из-за горизонта,\n она распахнула двери и\n выбежала прочь из общежития.");
        endfOfGame.add("Но упала, только вышла за ворота\n академии.");
        endfOfGame.add("Без сознания.");
        endfOfGame.add("Ее быстро нашла Кайден, как раз\n приходящая на работу.");
        endfOfGame.add("Цокнув, сказав что-то про образ\n жизни Руны, вызвала скорую.");
        endfOfGame.add(" ");
        endfOfGame.add("Дух остался в академии.");endfOfGame.add(".");
    }

    void memoriesWithoutPoliam() {
        endfOfGame.add("Руна отлично защитила дипломную,\n хоть было страшно.");
        endfOfGame.add("Она смотрела на Ст, сидевшего\n на первых рядах и внимательно \nглядя прямо ей в глаза.");
        endfOfGame.add("Он был напряжен,");
        endfOfGame.add("Потому что боялся провала своей\n нерадивой студентки.");
        endfOfGame.add("Только луч солнца упал на ее дрожащие руки,\n держащие бумаги,");
        endfOfGame.add("И словно весь мир заглох.");
        endfOfGame.add("Она прижала руку ко рту,\n бросилась прочь из аудитории.");
        endfOfGame.add("");
        endfOfGame.add("Она вспоминает.");
        endfOfGame.add("Она вспоминает.");
        endfOfGame.add("Она вспоминает.");
        endfOfGame.add("Перед глазами мельтешит,\n пульсирует в такт сердцебиению.");
        endfOfGame.add("Наверное, это и помешало увидеть\n косяк и вовремя повернуть.");
        endfOfGame.add(" ");
        endfOfGame.add("Дух остается в академии.");endfOfGame.add(".");
    }


    void goodEnding() {
        endfOfGame.add("Руна отлично защитила дипломную,\n хоть было страшно.");
        endfOfGame.add("Она смотрела на Ст,\n сидевшего на первых рядах и \nвнимательно глядевшего прямо ей в глаза. ");
        endfOfGame.add("Он был напряжен,");
        endfOfGame.add("это готовность помочь студентке, \n лишь вчера вспомнила абсолютно все.");
        endfOfGame.add("После защиты она тепло\n поговорила с Полиамом,\n похвалившего ее за отличную работу.");
        endfOfGame.add("Извинилась за все, что делала прежде.");
        endfOfGame.add("Нашла Кайден, извинилась\n и перед ней за свое поведение.");
        endfOfGame.add("Та того не ожидала, но\n словам Руны улыбнулась.");
        endfOfGame.add("В конце этого тяжелого,\n но хорошего дня она с волнением,\n но решительностью набрала их номер.");
        endfOfGame.add(" ");
        endfOfGame.add("Академия спасена от духа.");endfOfGame.add(".");

    }

    void badEnding() {
        endfOfGame.add("Руна ничего не помнит.");
        endfOfGame.add("Руна ничего не знает.");
        endfOfGame.add("Руна осталась без прошлого.");
        endfOfGame.add("Без дома.");
        endfOfGame.add("Без семьи.");
        endfOfGame.add("Без любви.");
        endfOfGame.add("Одна в этом кишащем жизнью мире,\n где для нее просто нет места.");
        endfOfGame.add("И никогда не найдется.");
        endfOfGame.add("Это клетка, из которой\n существу, лишенному памяти,\n знаний, чувств, есть лишь один выход.");endfOfGame.add(".");
    }

    void faintingAfterTravel() {
        endfOfGame.add("Руна даже не пришла в академию.");
        endfOfGame.add("Всю ночь она не спала, сидела\n как на иголках.");
        endfOfGame.add("Только солнце вышло из-за\n горизонта, она распахнула двери\n и выбежала прочь из общежития.");
        endfOfGame.add("Полиам не мог ее нигде найти.\n Даже Вало не знала, где она.");
        endfOfGame.add("Пришлось сказать ректору,\n что она выступит завтра.");
        endfOfGame.add("Однако ее принесли в академию\n уже в час.");
        endfOfGame.add("Без сознания.");
        endfOfGame.add("Был большой переполох,\n скорую вызвали сразу.");
        endfOfGame.add(" ");
        endfOfGame.add("Дух остался в академии.");endfOfGame.add(".");
    }

    void faintingToParents() {
        endfOfGame.add("Окончательное решение\n не заставило долго себя ждать.");
        endfOfGame.add("Только солнце вышло из-за\nгоризонта, она распахнула двери\n и вышла на улицу.");
        endfOfGame.add("С ключом от Межмирья в\n одной руке и чемоданом в другой.");
        endfOfGame.add("Ей был безразличен и\n какой-то Ст, про которого\n говорила Кайден, и она сама.");
        endfOfGame.add("...Но не успела она выйти за\n ворота академии, как свалилась\n в обморок.");
        endfOfGame.add("Похоже, домой она сегодня\n не попадет.");
        endfOfGame.add("Да и то ли она зовет домом?..");
        endfOfGame.add(" ");
        endfOfGame.add("Дух остается в академии.");endfOfGame.add(".");
    }

    void faintingInProtection() {
        endfOfGame.add("Руна пришла на защиту во всеоружии.");
        endfOfGame.add("Она была готова дипломную, правда.");
        endfOfGame.add("Назвали ее имя.");
        endfOfGame.add("Она посмотрела на Ст,\n необычайно напряженного,");
        endfOfGame.add("и упала без сознания.");
        endfOfGame.add("Тот кинулся к ней, рявкнул\n о том, чтобы срочно вызвали\n скорую.");
        endfOfGame.add("Может быть, в больнице ей помогут.\n Ни в чем нельзя быть уверенным.");
        endfOfGame.add(" ");
        endfOfGame.add("Дух остается в академии.");endfOfGame.add(".");

    }

    void sleepWithPoliam() {
        endfOfGame.add("Руна пришла на защиту во всеоружии.");
        endfOfGame.add("Она была готова защитить\n дипломную, правда.");
        endfOfGame.add("Но все же чувствовалась некоторая\n усталость. Наверное,\n это от недосыпа.");
        endfOfGame.add("Она посмотрела на Ст, печально вздохнула,");
        endfOfGame.add("Призналась, что боится упасть\n в обморок во время выступления.");
        endfOfGame.add("Он не стал сердиться или раздражаться,\n лишь кивнул и вышел с ней из аудитории.");
        endfOfGame.add("\"Защитишься завтра. Время есть\"");
        endfOfGame.add("Они вышли на улицу, присели на лавочку.");
        endfOfGame.add("Руна зевнула и бессильно\n уронила голову на плечо Полиама.");
        endfOfGame.add("Это нормально. Она так устала…");
        endfOfGame.add("Эта девочка заслужила отдохнуть.");
        endfOfGame.add(" ");
        endfOfGame.add("Академия спасена от духа.");endfOfGame.add(".");


    }

    void welcomeHomeThink() {
        endfOfGame.add("Окончательное решение\n не заставило долго себя ждать.");
        endfOfGame.add("Только солнце вышло из-за горизонта,\n она распахнула двери и вышла на улицу.");
        endfOfGame.add("С ключом от Межмирья в одной\n руке и чемоданом в другой.");
        endfOfGame.add("Ей был безразличен и какой-то Ст,\n про которого говорила Кайден, и она сама.");
        endfOfGame.add("Та бумажка про какое-то дело смущала ее,\n но она боялась вспоминать, что это было.");
        endfOfGame.add("Она возвращается домой.\n Его-то она помнит.");
        endfOfGame.add("Помнит ведь?..");
        endfOfGame.add(" ");
        endfOfGame.add("Дух остается в академии.");endfOfGame.add(".");
    }

    void welcomeHomeWithoutThink() {
        endfOfGame.add("Окончательное решение\n не заставило долго себя ждать.");
        endfOfGame.add("Только солнце вышло из-за горизонта, она\n распахнула двери и вышла на улицу.");
        endfOfGame.add("С ключом от Межмирья в одной\n руке и чемоданом в другой.");
        endfOfGame.add("Ей был безразличен и какой-то Ст,\n про которого говорила Кайден, и она сама.");
        endfOfGame.add("Она возвращается домой.\n Его-то она помнит.");
        endfOfGame.add("Помнит ведь?..");
        endfOfGame.add(" ");
        endfOfGame.add("Дух остается в академии.");endfOfGame.add(".");

    }

    void memories() {
        endfOfGame.add("Последние несколько часов\n Руна судорожно перечитывала дипломную,");
        endfOfGame.add("Но буквы плыли перед ее глазами.");
        endfOfGame.add("Она пришла в академию, с\n папкой в руках, бледная, холодная.");
        endfOfGame.add("Полиам спрашивал, как она, но из нее\n и слова нельзя было вытянуть.");
        endfOfGame.add("Только жюри назвали ее имя, чтобы она\n выступила со своим проектом,");
        endfOfGame.add("ее глаза наполнились слезами.");
        endfOfGame.add("Она выбежала из аудитории, не\n помня себя, то крича, то что-то шепча.");
        endfOfGame.add("Все прохожие испуганно отшатывались,\n когда она пробегала мимо.");
        endfOfGame.add("\"Бедная. Наверное, у нее что-то случилось\"");
        endfOfGame.add("Она пробежала несколько остановок, прежде\n чем ее схватили за руку и притянули к себе.");
        endfOfGame.add("Полиам.");
        endfOfGame.add("Не успел он и слова произнести,\n она упала ему в руки без сознания.");
        endfOfGame.add("Он не закатит глаза, не\n свалит ее кому-то другому.");
        endfOfGame.add("Он готов сам помочь ей,\n впервые за 20 лет\n учебы здесь ставшей искренней.");
        endfOfGame.add(" ");
        endfOfGame.add("Академия спасена от духа.");endfOfGame.add(".");
    }

    void maybeHappiness() {
        endfOfGame.add("Последние несколько часов Руна\n судорожно перечитывала дипломную,");
        endfOfGame.add("Но буквы плыли перед ее глазами.");
        endfOfGame.add("Она пришла в академию, с \nпапкой в руках, бледная, холодная.");
        endfOfGame.add("Полиам спрашивал, как она,\n но из нее и слова нельзя\n было вытянуть.");
        endfOfGame.add("Только жюри назвали ее имя,\n чтобы она выступила со своим проектом,");
        endfOfGame.add("ее глаза наполнились слезами.");
        endfOfGame.add("Она выбежала из аудитории, не\n помня себя, то крича, то что-то шепча.");
        endfOfGame.add("Все прохожие испуганно отшатывались,\n когда она пробегала мимо.");
        endfOfGame.add("\"Бедная. Наверное, у нее что-то случилось\"");
        endfOfGame.add("Она пробежала несколько остановок,\n прежде чем ее схватили за\n руку и притянули к себе.");
        endfOfGame.add("Полиам.");
        endfOfGame.add("Она не знает, кто она.\n Она не помнит ничего выходящего\n за рамки ее 20 лет обучения.");
        endfOfGame.add("Существо без прошлого.");
        endfOfGame.add("Ничего. Ведь ей помогут вспомнить,\n кто она есть на самом деле.");
        endfOfGame.add("А может быть,\n это рождение нового существа.");
        endfOfGame.add(" ");
        endfOfGame.add("Академия спасена от духа.");endfOfGame.add(".");
    }

    void clearing() {
        recordOfLesson = false;
        talkingPoliam1 = false;
        docAbenrollment = false;
        dairy = false;
        talkingKaiden = false;
        talkingPoliam2 = false;
        sleeping = false;
        countKeys = 0;
        endfOfGame.clear();
    }


}
