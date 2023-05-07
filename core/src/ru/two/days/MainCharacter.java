package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class MainCharacter {
    TwoDays gg = new TwoDays();
    float x, y;
    float width=1280, height=1280;
    float vx;
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
    }

    float getX(){
        return x-width/2;
    }

    float getY(){
        return 70;
    }


    void move(boolean isRight, int vx){
        //this.vx = vx;
        if(isRight) x +=vx;
        else x-=vx;
        changePhase();
    }
    boolean interaction(float tx){
        return x+400 < tx && tx < x+width-400;
    }
    boolean isFlip() {
        return vx>0;
    }
}
