package io.github.Outbreakradar;

import javax.swing.*;
import java.awt.*;

public class JPanelRounded extends JPanel {

    public int cornerRadius = 20;

    public JPanelRounded() {
        super();
        setOpaque(false); // Make the panel transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Use Graphics2D for anti-aliasing
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded background
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        g2d.dispose();
    }

    public void setCornerRadius(int radius) {
        this.cornerRadius = radius;
    }
}
