package io.github.Outbreakradar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JButtonRounded extends JButton {

    int radius = 15;
    Color borderColor;
    int borderSize;
    Color pressedColor = Constants.BTNHOVERCLR;

    // Store original bg so it doesnt get lost when new background gets set on mousePressed
    Color originalBg;
    boolean pressed = false;

    public JButtonRounded() {
        super();

        this.setContentAreaFilled(false);
        this.setBackgroundOg(getBackground());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (!pressed) {
                    setBackground(pressedColor);
                    pressed = true;
                }

            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {

        Color bg = getBackground();

        if (getModel().isRollover()) {
            bg = Constants.BTNHOVERCLR;
        } else {
            bg = getBackground();
        }

        drawRoundRectangle(g, bg, getWidth(), getHeight(), this.radius);
        // Call the superclass method to paint the text and icon
        super.paintComponent(g);
    }

    private void drawRoundRectangle(Graphics g, Color color, int width, int height, int radius) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.fillRoundRect(0, 0, width, height, radius, radius);
        g2.dispose();
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    public void setBorderSize(int size) {
        this.borderSize = size;
    }

    public void setPressedColor(Color color) {
        this.pressedColor = color;
    }


    public void setBackgroundOg(Color color) {
        this.originalBg = color;
    }

    public void unpress() {
        if (!pressed) return;
        else {
            setBackground(originalBg);
            pressed = false;
        }
    }

    public void press() {
        if (pressed) return;
        else {
            setBackground(pressedColor);
            pressed = true;
        }
    }
}
