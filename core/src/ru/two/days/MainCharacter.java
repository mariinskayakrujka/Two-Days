package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class MainCharacter {
    boolean isWalking;
    TwoDays gg;
    float x, y;
    float width, height;
    float wx, rx;
    float hitting;
    ScreenGame sg = new ScreenGame(gg);

    int faza, nFaz = 4;

    void changePhase() {
        if (++faza == nFaz) faza = 0;
    }

    public MainCharacter(float x, float wx) {
        this.x = x;
        this.wx = wx;
        rx = 20;
    }

    float getX(){
        return x-width/2;
    }

    float getY(){
        return y-height/2;
    }


    void move(int wx, float f){
        x += wx;
        faza += f;
    }

    boolean isFlip() {
        return wx>0;
    }
}
