package io.github.Outbreakradar;

import javax.swing.*;
import java.awt.*;

public class MainTest {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.blue);
        panel1.setPreferredSize(new Dimension(180, 0));
        panel1.setMaximumSize(new Dimension(180, Integer.MAX_VALUE));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        panel1.add(new JLabel("Hello world"));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.red);
        panel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        panel2.setLayout(new GridBagLayout());

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.yellow);
        panel3.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

        JPanel panel31 = new JPanel();
        panel31.setBackground(Color.BLACK);
        panel31.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        panel3.add(panel31);

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.green);
        panel4.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));


        GridBagConstraints mcGBC = new GridBagConstraints();
        mcGBC.gridx = 0;
        mcGBC.gridy = 0;
        mcGBC.weightx = 0.6;
        mcGBC.weighty = 1;
        mcGBC.fill = GridBagConstraints.BOTH;

        GridBagConstraints rcGBC = new GridBagConstraints();
        rcGBC.gridx = 1;
        rcGBC.gridy = 0;
        rcGBC.weightx = 0.4;
        mcGBC.weighty = 1;
        rcGBC.fill = GridBagConstraints.BOTH;

        panel2.add(panel3, mcGBC);
        panel2.add(panel4, rcGBC);

        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1, BorderLayout.WEST);
        frame.add(panel2, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
