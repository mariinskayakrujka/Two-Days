package ru.two.days;

import com.badlogic.gdx.utils.TimeUtils;

public class RunaMilekum{

    int vx, nFaz = 3, faza;
    boolean isWalking;
    TwoDays gg = new TwoDays();
    float x, y;
    float width=640, height=640;
    float hitting;
    ScreenGame sg;

    long timeLastPhase, timePhaseInterval = 300;

    void changePhase() {
        if(TimeUtils.millis() > timeLastPhase+timePhaseInterval) {
            if (++faza == nFaz) faza = 0;
            timeLastPhase= TimeUtils.millis();
        }
    }

    public RunaMilekum(float x) {
        sg = new ScreenGame(gg);
        this.x = x;
        timePhaseInterval=150;
    }
    int nfaz = 3;
    void moveForRuna(float hitting) {
        isWalking = true;
            if (!sg.isTalking && !sg.isReading) {
                if (hitting > x+10) {
                    vx = 20;
                    x += vx;
                    changePhase();
                } else if (hitting < x-10) {
                    vx = -20;
                    x += vx;
                    changePhase();
                } else isWalking =false;
        }else isWalking = false;
    }
    float getX(){
        return x-width/2;
    }

    float getY(){
        return 70;
    }
    boolean isFlip() {
        return vx>0;
    }
}
