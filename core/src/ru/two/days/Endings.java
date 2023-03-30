package ru.two.days;
/*без 1 нет 2,5 и 7
без 5 нет 2 и 7
без 2 нет 7
 */
public class Endings {
    boolean recordOfLesson,talkingPoliam1, docAbenrollment, dairy,
            talkingKaiden, talkingPoliam2, sleeping;
    int countKeys;
    public Endings(ScreenGame scn){
        scn.isGameStart = false;
        if((countKeys == 7) || (countKeys == 6 && !dairy)) goodEnding();
        else if((countKeys == 0) ||
                (countKeys == 1 && (sleeping || dairy)) ||
                (countKeys == 2 && sleeping && dairy)) badEnding();
        else if((!recordOfLesson && sleeping && docAbenrollment) ||
                (!recordOfLesson && !talkingPoliam1 && !docAbenrollment)) faintingAfterEscape();
        else if(!recordOfLesson && docAbenrollment && !sleeping) faintingSoonAfterEscape();
        else if(recordOfLesson && !talkingPoliam1 && !docAbenrollment  && !sleeping) faintingAfterTravel();
        else if(recordOfLesson && !talkingPoliam1 && docAbenrollment && !sleeping) faintingToParents();
        else if(talkingPoliam1 && !sleeping && !talkingPoliam2) faintingInProtection();
        else if(countKeys == 6 && !sleeping) sleepWithPoliam();
        else if(countKeys == 5 && !talkingPoliam1 && !talkingPoliam2){
            if(dairy)
                welcomeHomeThink();
            else welcomeHomeWithoutThink();
        }
        else if (!talkingPoliam2 && (countKeys == 5 && !dairy || countKeys == 6)) areYouSure();
        else if (talkingPoliam1 && !talkingPoliam2 && !docAbenrollment &&
                (countKeys == 5 || countKeys == 4 && !dairy)) memories();
        else if(!docAbenrollment &&(countKeys == 6 || countKeys == 5 && !dairy)) maybeHappiness();
    }
    void goodEnding(){

    }
    void badEnding(){

    }

    void faintingAfterEscape(){

    }
    void faintingSoonAfterEscape(){

    }
    void faintingAfterTravel(){

    }
    void faintingToParents(){

    }
    void faintingInProtection(){

    }
    void sleepWithPoliam(){

    }
    void welcomeHomeThink(){

    }
    void welcomeHomeWithoutThink(){

    }
    void areYouSure(){

    }
    void memories(){

    }
    void maybeHappiness(){

    }


}
