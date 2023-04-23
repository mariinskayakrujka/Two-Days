package ru.two.days;

public class Objects {
    float x, y;
    float width, height;

    public Objects(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    float getX(){
        return x-width/2;
    }

    float getY(){
        return y-height/2;
    }


    boolean hit(float tx, float ty){
        return x < tx && tx < x+width && y+height > ty && ty > y;
    }
}
