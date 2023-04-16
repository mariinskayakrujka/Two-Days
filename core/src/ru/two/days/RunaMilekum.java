package ru.two.days;

public class RunaMilekum extends MainCharacter{

    int vx;

    public RunaMilekum(float x) {
        super(x);
        timePhaseInterval=90;
    }
    int nfaz = 2;
    void moveForRuna(float hitting) {
        isWalking = true;
            if (!sg.isTalking && !sg.isReading) {
                System.out.println(x);
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
    boolean isFlip() {
        return vx>0;
    }

}
