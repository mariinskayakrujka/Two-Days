package ru.two.days;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class RunaMilekum extends MainCharacter{

    public RunaMilekum(float x, float wx) {
        super(x, wx);
    }

    void moveForRuna(float hitting, float f) {
        isWalking = true;
        if(!sg.isTalking || !sg.isReading) {
            if (y < 120 && y > 90) {
                if (hitting > x) {
                    x += wx;
                    faza += f;
                } else if (hitting < x) {
                    wx = -wx;
                    x += wx;
                    faza += f;
                } else {
                    isWalking = false;
                    faza = 6;
                }
            }
        }
    }
}
