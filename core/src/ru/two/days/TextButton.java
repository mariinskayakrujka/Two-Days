package ru.two.days;

import static ru.two.days.TwoDays.SCR_WIDTH;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class TextButton {
    BitmapFont font;
    String text;
    float x, y;
    float width, height;

    public TextButton(BitmapFont font, String text, float x, float y) {
        this.font = font;
        this.text = text;
        this.x = x;
        this.y = y;
        GlyphLayout gl = new GlyphLayout(font, text);
        width = gl.width;
        height = gl.height;
    }

    public TextButton(BitmapFont font, String text, float y) {
        this.font = font;
        this.text = text;
        this.y = y;
        GlyphLayout gl = new GlyphLayout(font, text);
        width = gl.width;
        height = gl.height;
        this.x = SCR_WIDTH/2f - width/2;
    }
    public TextButton(BitmapFont font, float x, float y) {
        this.font = font;
        this.x = x;
        this.y = y;
        GlyphLayout gl = new GlyphLayout(font, text);
        width = gl.width;
        height = gl.height;
    }

    public void setText(String text) {
        this.text = text;
        GlyphLayout gl = new GlyphLayout(font, text);
        width = gl.width;
        this.x = SCR_WIDTH/2f - width/2;
    }

    boolean hit(float tx, float ty){
        return x < tx && tx < x+width && y-height < ty && ty < y;
    }
}
