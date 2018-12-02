package com.example.controller;

import java.awt.*;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/11/30 22:23
 */
public class BufferCircle extends Circle {
    Graphics doubleBuffer = null;

    @Override
    public void init() {
        super.init();
        doubleBuffer = screenImage.getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        doubleBuffer.setColor(Color.white);
        doubleBuffer.fillRect(0,0,200,100);
        drawCircle(doubleBuffer);
        g.drawImage(screenImage,0,0,this);
    }
}
