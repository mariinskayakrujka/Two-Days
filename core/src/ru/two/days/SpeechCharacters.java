package ru.two.days;

import java.util.ArrayList;
import java.util.Iterator;

public class SpeechCharacters {
    String object;
    String nothing = object + ", ничего интересного.";
    ArrayList<String> speech = new ArrayList<>();

    ArrayList<String> talk = new ArrayList<>();
    void talkWithPoliam(){
        talk.add("");
    }
    Iterator it = speech.iterator();
}
