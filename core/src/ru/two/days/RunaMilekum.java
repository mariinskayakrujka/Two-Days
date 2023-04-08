package ru.two.days;

public class RunaMilekum extends MainCharacter{

    public RunaMilekum(float x) {
        super(x);
    }

    void moveForRuna(float hitting) {
        isWalking = true;
        if(!sg.isTalking || !sg.isReading) {
            if (y < 120 && y > 90) {
                if (hitting > x) {
                    x +=1;
                } else if (hitting < x) {
                    x -=1;
                } else {
                    isWalking = false;
                }
            }
        }
    }
}
