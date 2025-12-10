/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import java.awt.Container;

/**
 *
 * @author Phuwan
 */

/* FINAL */

public class FloatingText extends JLabel {
    private Timer timer;
    private int yOffset = 0;
    private int alpha = 255;
    private Container parent;

    public FloatingText(Container parent, String text, int x, int y, Color color, int fontSize) {
        super(text);
        this.parent = parent;

        this.setFont(new Font("Impact", Font.BOLD, fontSize)); 
        this.setForeground(color);

        this.setBounds(x, y, 150, 40);

        parent.add(this, 0);
        parent.setComponentZOrder(this, 0);
        parent.repaint();

        timer = new Timer(30, new ActionListener() {
            int lifeTime = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                lifeTime++;

                yOffset += 2; 
                setLocation(x, y - yOffset);

                if (lifeTime > 30) {
                    stopAndRemove();
                }
            }
        });
        timer.start();
    }

    private void stopAndRemove() {
        timer.stop();
        parent.remove(this);
        parent.repaint();
    }
}