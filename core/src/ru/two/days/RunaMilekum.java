package ru.two.days;

public class RunaMilekum extends MainCharacter{

    public RunaMilekum(float x) {
        super(x);
    }
    int nfaz = 2;
    void moveForRuna(float hitting) {
        isWalking = true;
            if (!sg.isTalking && !sg.isReading) {
                System.out.println(x);
                if (hitting >= x-10) {
                    x += 30f;
                    faza++;
                    changePhase();
                } else if (hitting <= x+10) {
                    x -= 30f;
                    faza++;
                    changePhase();
                } else isWalking = false;
        }
    }
}
