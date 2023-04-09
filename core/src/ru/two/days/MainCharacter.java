package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class MainCharacter {
    boolean isWalking;
    TwoDays gg = new TwoDays();
    float x, y;
    float width, height;
    float wx, rx;
    float hitting;
    ScreenGame sg;

    int faza, nFaz = 4;

    void changePhase() {
        if (++faza == nFaz) faza = 0;
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
        return y-height/2;
    }


    void move(int x){
        this.x +=x;
        faza += 1;
        changePhase();
    }
}
