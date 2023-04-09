package ru.two.days;

import static ru.two.days.TwoDays.SCR_WIDTH;

import androidx.annotation.NonNull;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import java.util.ArrayList;

public class Text {
    BitmapFont font;
    String phrase;
    float x, y;
    float width, height;

    float getX(){
        return x-width/2;
    }

    float getY(){
        return y-height/2;
    }

    public Text(BitmapFont font, String text, float x, float y) {
        this.font = font;
        this.phrase = text;
        this.x = x;
        this.y = y;
        @NonNull GlyphLayout gl = new GlyphLayout(font, text);
        width = gl.width;
        height = gl.height;
    }

    public Text(BitmapFont font, String text, float y) {
        this.font = font;
        this.phrase = text;
        this.y = y;
        GlyphLayout gl = new GlyphLayout(font, text);
        width = gl.width;
        height = gl.height;
        this.x = SCR_WIDTH/2f - width/2;
    }

    public void setText(String text) {
        this.phrase = text;
        GlyphLayout gl = new GlyphLayout(font, text);
        width = gl.width;
        this.x = SCR_WIDTH/2f - width/2;
    }

    boolean hit(float tx, float ty){

        return x < tx && tx < x+width && y-height < ty && ty < y;
    }

}
