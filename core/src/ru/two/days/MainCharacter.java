package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class MainCharacter {
    boolean isWalking;
    TwoDays gg = new TwoDays();
    float x, y;
    float width=640, height=640;
    float wx, rx;
    float hitting;
    ScreenGame sg;

    int faza, nFaz = 4;

    long timeLastPhase, timePhaseInterval = 300;

    void changePhase() {
        if(TimeUtils.millis() > timeLastPhase+timePhaseInterval) {
            if (++faza == nFaz) faza = 0;
            timeLastPhase= TimeUtils.millis();
        }
    }

    public MainCharacter(float x) {
        sg = new ScreenGame(gg);
        this.x = x;
        rx = 20;
    }

    float getX(){
        return x-width/2;
    }

    float getY(){
        return 70;
    }


    void move(int vx){
        x +=vx;
        changePhase();
    }
    boolean interaction(float tx, float ty){
        return x < tx && tx < x+width && y+height > ty && ty > y;
    }
}
