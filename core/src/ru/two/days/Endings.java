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
    public Endings(){
        endfOfGame.add("Собрано"+ countKeys + "из 7 ключевых моментов.");
        endfOfGame.add("День защиты.");

    }
    public void whatIsEnd(){
        if((countKeys == 7) || (countKeys == 6 && !dairy)) goodEnding();
        else if(countKeys == 6 && !sleeping) sleepWithPoliam();

        else if((countKeys == 0) ||
                (countKeys == 1 && (sleeping || dairy)) ||
                (countKeys == 2 && sleeping && dairy)) badEnding();

        else if(recordOfLesson && !talkingKaiden) {
            if (sleeping) faintingAfterTravel();
            else faintingInTravel();
        }

        else if(talkingKaiden && !talkingPoliam1){
            if(sleeping) {
                if (dairy)
                    welcomeHomeThink();
                else welcomeHomeWithoutThink();
            }else faintingToParents();
        }

        else if(talkingPoliam1 && !talkingPoliam2 && sleeping) memoriesWithoutPoliam();
        else if(talkingPoliam1 && !sleeping && !talkingPoliam2) faintingInProtection();

        else if (!docAbenrollment && talkingPoliam2 && !sleeping &&
                (countKeys == 5 || countKeys == 4 && !dairy)) memories();
        else if(!docAbenrollment &&(countKeys == 6 || countKeys == 5 && !dairy)) maybeHappiness();
    }
    void faintingInTravel(){
        endfOfGame.add("Руна даже не пришла в академию.");endfOfGame.add("Всю ночь она не спала, сидела как на иголках.");
        endfOfGame.add("Только солнце вышло из-за горизонта, она распахнула двери и выбежала прочь из общежития.");
        endfOfGame.add("Но упала, только вышла за ворота академии.");endfOfGame.add("Без сознания.");
        endfOfGame.add("Ее быстро нашла Кайден, как раз приходящая на работу.");
        endfOfGame.add("Цокнув, сказав что-то про образ жизни Руны, вызвала скорую.");
        endfOfGame.add(" ");endfOfGame.add("Дух остался в академии.");
    }

    void memoriesWithoutPoliam(){
        endfOfGame.add("Руна отлично защитила дипломную, хоть было страшно.");
        endfOfGame.add("Она смотрела на Ст, сидевшего на первых рядах и внимательно глядя прямо ей в глаза.");
        endfOfGame.add("Он был напряжен,");endfOfGame.add("Потому что боялся провала своей нерадивой студентки.");
        endfOfGame.add("Только луч солнца упал на ее дрожащие руки, держащие бумаги,");endfOfGame.add("И словно весь мир заглох.");
        endfOfGame.add("Она прижала руку ко рту, бросилась прочь из аудитории.");endfOfGame.add("");
        endfOfGame.add("Она вспоминает.");endfOfGame.add("Она вспоминает.");
        endfOfGame.add("Она вспоминает.");endfOfGame.add("Перед глазами мельтешит, пульсирует в такт сердцебиению.");
        endfOfGame.add("Наверное, это и помешало увидеть косяк и вовремя повернуть.");endfOfGame.add("Дух остается в академии.");
    }




    void goodEnding(){
        endfOfGame.add("Руна отлично защитила дипломную, хоть было страшно.");
        endfOfGame.add("Она смотрела на ректора на Ст, сидевшего на первых рядах и внимательно глядевшего прямо ей в глаза. ");
        endfOfGame.add("Он был напряжен,");endfOfGame.add("это готовность помочь студентке, которая лишь вчера вспомнила абсолютно все.");
        endfOfGame.add("После защиты она тепло поговорила с Полиамом, похвалившего ее за отличную работу.");
        endfOfGame.add("Извинилась за все, что делала прежде.");endfOfGame.add("Нашла Кайден, извинилась и перед ней за свое поведение.");
        endfOfGame.add("Та того не ожидала, но словам Руны улыбнулась.");
        endfOfGame.add("В конце этого тяжелого, но хорошего дня она с волнением, но решительностью набрала их номер.");
        endfOfGame.add(" ");endfOfGame.add("Академия спасена от духа.");

    }
    void badEnding(){
        endfOfGame.add("Руна ничего не помнит.");endfOfGame.add("Руна ничего не знает.");
        endfOfGame.add("Руна осталась без прошлого.");endfOfGame.add("Без дома.");
        endfOfGame.add("Без семьи.");endfOfGame.add("Без любви.");
        endfOfGame.add("Одна в этом кишащем жизнью мире, где для нее просто нет места.");endfOfGame.add("И никогда не найдется.");
        endfOfGame.add("Это клетка, из которой существу, лишенному памяти, знаний, чувств, есть лишь один выход.");
    }
    void faintingAfterTravel(){
        endfOfGame.add("Руна даже не пришла в академию.");endfOfGame.add("Всю ночь она не спала, сидела как на иголках.");
        endfOfGame.add("Только солнце вышло из-за горизонта, она распахнула двери и выбежала прочь из общежития.");
        endfOfGame.add("Полиам не мог ее нигде найти. Даже Вало не знала, где она.");
        endfOfGame.add("Пришлось сказать ректору, что она выступит завтра.");endfOfGame.add("Однако ее принесли в академию уже в час.");
        endfOfGame.add("Без сознания.");endfOfGame.add("Был большой переполох, скорую вызвали сразу.");
        endfOfGame.add(" ");endfOfGame.add("Дух остался в академии.");
    }
    void faintingToParents(){
        endfOfGame.add("Окончательное решение не заставило долго себя ждать.");
        endfOfGame.add("Только солнце вышло из-за горизонта, она распахнула двери и вышла на улицу.");
        endfOfGame.add("С ключом от Межмирья в одной руке и чемоданом в другой.");
        endfOfGame.add("Ей был безразличен и какой-то Ст, про которого говорила Кайден, и она сама.");
        endfOfGame.add("...Но не успела она выйти за ворота академии, как свалилась в обморок.");
        endfOfGame.add("Похоже, домой она сегодня не попадет.");endfOfGame.add("Да и то ли она зовет домом?..");
        endfOfGame.add(" ");endfOfGame.add("Дух остается в академии.");
    }
    void faintingInProtection(){
        endfOfGame.add("Руна пришла на защиту во всеоружии.");
        endfOfGame.add("Она была готова дипломную, правда.");endfOfGame.add("Назвали ее имя.");
        endfOfGame.add("Она посмотрела на Ст,  необычайно напряженного,");endfOfGame.add("и упала без сознания.");
        endfOfGame.add("Тот кинулся к ней, рявкнул о том, чтобы срочно вызвали скорую.");
        endfOfGame.add("Может быть, в больнице ей помогут. Ни в чем нельзя быть уверенным.");
        endfOfGame.add(" ");endfOfGame.add("Дух остается в академии.");

    }
    void sleepWithPoliam(){
        endfOfGame.add("Руна пришла на защиту во всеоружии.");endfOfGame.add("Она была готова защитить дипломную, правда.");
        endfOfGame.add("Но все же чувствовалась некоторая усталость. Наверное, это от недосыпа.");
        endfOfGame.add("Она посмотрела на Ст,  печально вздохнула,");endfOfGame.add("Призналась, что боится упасть в обморок во время выступления.");
        endfOfGame.add("Он не стал сердиться или раздражаться, лишь кивнул и вышел с ней из аудитории.");
        endfOfGame.add("\"Защитишься завтра. Время есть\"");
        endfOfGame.add("Они вышли на улицу, присели на лавочку.");endfOfGame.add("Руна зевнула и бессильно уронила голову на плечо Полиама.");
        endfOfGame.add("Это нормально. Она так устала…");endfOfGame.add("Эта девочка заслужила отдохнуть.");
        endfOfGame.add(" ");endfOfGame.add("Академия спасена от духа.");


    }
    void welcomeHomeThink(){
        endfOfGame.add("Окончательное решение не заставило долго себя ждать.");
        endfOfGame.add("Только солнце вышло из-за горизонта, она распахнула двери и вышла на улицу.");
        endfOfGame.add("С ключом от Межмирья в одной руке и чемоданом в другой.");
        endfOfGame.add("Ей был безразличен и какой-то Ст, про которого говорила Кайден, и она сама.");
        endfOfGame.add("Та бумажка про какое-то дело смущала ее, но она боялась вспоминать, что это было.");
        endfOfGame.add("Она возвращается домой. Его-то она помнит.");endfOfGame.add("Помнит ведь?..");
        endfOfGame.add(" ");endfOfGame.add("Дух остается в академии.");
    }
    void welcomeHomeWithoutThink(){
        endfOfGame.add("Окончательное решение не заставило долго себя ждать.");
        endfOfGame.add("Только солнце вышло из-за горизонта, она распахнула двери и вышла на улицу.");
        endfOfGame.add("С ключом от Межмирья в одной руке и чемоданом в другой.");
        endfOfGame.add("Ей был безразличен и какой-то Ст, про которого говорила Кайден, и она сама.");
        endfOfGame.add("Она возвращается домой. Его-то она помнит.");endfOfGame.add("Помнит ведь?..");
        endfOfGame.add(" ");endfOfGame.add("Дух остается в академии.");

    }
    void memories(){
        endfOfGame.add("Последние несколько часов Руна судорожно перечитывала дипломную,");
        endfOfGame.add("Но буквы плыли перед ее глазами.");endfOfGame.add("Она пришла в академию, с папкой в руках, бледная, холодная.");
        endfOfGame.add("Полиам спрашивал, как она, но из нее и слова нельзя было вытянуть.");
        endfOfGame.add("Только жюри назвали ее имя, чтобы она выступила со своим проектом,");
        endfOfGame.add("ее глаза наполнились слезами.");endfOfGame.add("Она выбежала из аудитории, не помня себя, то крича, то что-то шепча.");
        endfOfGame.add("Все прохожие испуганно отшатывались, когда она пробегала мимо.");endfOfGame.add("\"Бедная. Наверное, у нее что-то случилось\"");
        endfOfGame.add("Она пробежала несколько остановок, прежде чем ее схватили за руку и притянули к себе.");
        endfOfGame.add("Полиам.");endfOfGame.add("Не успел он и слова произнести, она упала ему в руки без сознания.");
        endfOfGame.add("Он не закатит глаза, не свалит ее кому-то другому.");
        endfOfGame.add("Он готов сам помочь ей, впервые за 20 лет учебы здесь ставшей искренней.");
        endfOfGame.add(" ");endfOfGame.add("Академия спасена от духа.");
    }
    void maybeHappiness(){
        endfOfGame.add("Последние несколько часов Руна судорожно перечитывала дипломную,");
        endfOfGame.add("Но буквы плыли перед ее глазами.");endfOfGame.add("Она пришла в академию, с папкой в руках, бледная, холодная.");
        endfOfGame.add("Полиам спрашивал, как она, но из нее и слова нельзя было вытянуть.");
        endfOfGame.add("Только жюри назвали ее имя, чтобы она выступила со своим проектом,");
        endfOfGame.add("ее глаза наполнились слезами.");endfOfGame.add("Она выбежала из аудитории, не помня себя, то крича, то что-то шепча.");
        endfOfGame.add("Все прохожие испуганно отшатывались, когда она пробегала мимо.");
        endfOfGame.add("\"Бедная. Наверное, у нее что-то случилось\"");
        endfOfGame.add("Она пробежала несколько остановок, прежде чем ее схватили за руку и притянули к себе.");
        endfOfGame.add("Полиам.");endfOfGame.add("Она не знает, кто она. Она не помнит ничего выходящего за рамки ее 20 лет обучения.");
        endfOfGame.add("Существо без прошлого.");endfOfGame.add("Ничего. Ведь ей помогут вспомнить, кто она есть на самом деле.");
        endfOfGame.add("А может быть, это рождение нового существа.");endfOfGame.add(" ");
        endfOfGame.add("Академия спасена от духа.");
    }


}
