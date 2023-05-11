package ru.two.days;

import static ru.two.days.TwoDays.SCR_HEIGHT;
import static ru.two.days.TwoDays.SCR_WIDTH;
import static ru.two.days.TwoDays.timeCurrent;

import androidx.annotation.NonNull;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Basement extends ScreenGame{

    boolean isKeyStage = true, ishavingKey;
    Texture imgBG;
    Objects key;
    Texture[] imgBg = new Texture[2];
    ArrayList<String> baseStage = new ArrayList<>(), aboutKey = new ArrayList<>();
    public Basement(@NonNull TwoDays context) {
        super(context);
        for (int i = 0; i < imgBg.length; i++) {
            imgBg[i] = new Texture("bg/basement"+i+".png");
        }
        imgBG=imgBg[0];
        key=new Objects(2112, 766, 2294-2112, 880-766);
        baseStage.add("Р:...");baseStage.add("Р: Твою ж...");
        baseStage.add("Р: Так, так-так, я смогу это решить, я вспомнила...");baseStage.add("Р: Нужно лишь...");

        baseStage.add("Р: *заклинание, обезвреживающее призрака*");
        baseStage.add("Р: Вот так.");baseStage.add("Р: Как я могла так необдуманно поступить?..");
        baseStage.add("Р: Вызвать духа, чтобы он помог защитить дипломную. Это гениально.");baseStage.add("Р: Я из-за этого лишилась памяти, конечно!");
        baseStage.add("Р: Но теперь он обезврежен.");baseStage.add("Р:...");
        baseStage.add("Р: Так, теперь тут нужно прибраться. Не дай Верховный это кто-нибудь увидит.");baseStage.add("..");

        aboutKey.add("Р: Так, что это?");aboutKey.add("Р: Ключ? От чего это?..");

    }

    @Override
    public void show() {
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
        gg.touch.x = 0;
        runa.vx = 0;
        runa.x = 400;
        texR = texRuna[5];
        music[1].stop();
    }

    @Override
    public void render(float delta) {
        if (isKeyStage) {
            switch (tt.phrase){
                case("Р: Так, так-так, я смогу это решить, я вспомнила..."):
                case("Р: Как я могла так необдуманно поступить?.."):
                case("Р: Но теперь он обезврежен."):
                    texR = texRuna[4];
                    break;
                case("Р: Вот так."):
                case("Р: Вызвать духа, чтобы он помог защитить дипломную. Это гениально."):
                    texR=texRuna[6];
                    break;
                default:
                    break;
            }
        }else{
            if (tt.phrase.equals("") && gg.touch.x != runa.getX() && gg.touch.x != 0 && !aboutKey.contains(tt.phrase)) {
                runa.moveForRuna(gg.touch.x);
            }
            if (soundOn && runa.isWalking) music[2].play();
            else music[2].stop();
        }
        if (runa.x <= END_OF_SCREEN_LEFT) {
            gg.setScreen(gg.roomOfRuna);
            music[2].stop();
        }
        if (Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            rightOutput(aboutKey);
            if(!aboutKey.contains(tt.phrase)) tt.phrase="";
            System.out.println("BASEMENT: "+ gg.touch.x + gg.touch.y);
            if (isKeyStage) {
                outputText(baseStage);
                if (count == 0) {
                    isKeyStage = false;
                    imgBG=imgBg[1];
                }
            }
            if(key.hit(gg.touch.x, gg.touch.y)){
                outputText(aboutKey);
                ishavingKey=true;
            }
        }
        times();
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        if (isKeyStage) {
            gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, false, false);
        }else{
            if (runa.isWalking) {
                changePose();
                gg.batch.draw(texR, runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);
            } else

                gg.batch.draw(texRuna[3], runa.getX(), runa.getY(), texR.getWidth(), texR.getHeight(), 0, 0, 1280, 1280, !runa.isFlip(), false);//спокойствие
            gg.batch.draw(forButtons[1], 0, SCR_HEIGHT/2f-350, 500, 500);
            gg.batch.draw(forButtons[0], 0, SCR_HEIGHT-300, 400, 400);
            gg.fontSimple.draw(gg.batch, "готово", 130, SCR_HEIGHT-50);
        }
        gg.font.draw(gg.batch, tt.phrase, tt.getX(), tt.getY());
        gg.batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        for (Texture texture : imgBg) {
            texture.dispose();
        }
    }
}
