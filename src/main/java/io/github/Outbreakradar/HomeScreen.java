package io.github.Outbreakradar;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JPanel {

    public HomeScreen() {
        super();

        setBackground(Color.RED);
        setLayout(new GridLayout());

        setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
//        setAlignmentY(Component.TOP_ALIGNMENT);

        MapComponent mc = new MapComponent();
        RecentComponent rc = new RecentComponent();

//        mc.setAlignmentY(Component.TOP_ALIGNMENT);

//        GridBagConstraints mcGBC = new GridBagConstraints();
//        mcGBC.gridx = 0;
//        mcGBC.gridy = 0;
//        mcGBC.weightx = 0.5;
//        mcGBC.weighty = 1;
//        mcGBC.fill = GridBagConstraints.BOTH;
//
//        GridBagConstraints rcGBC = new GridBagConstraints();
//        rcGBC.gridx = 1;
//        rcGBC.gridy = 0;
//        rcGBC.weightx = 0.5;
//        rcGBC.weighty = 1;
//        rcGBC.fill = GridBagConstraints.BOTH;

        add(mc);
        add(rc);
//        add(new JLabel("Hello world"));

    }
}
