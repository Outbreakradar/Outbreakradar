package io.github.Outbreakradar;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MapComponent extends JPanel {

    public MapComponent() {
        super();
        setBackground(Color.green);
//        setPreferredSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
//        setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Country, State selector
        JPanel selector = new JPanel();
        selector.setBackground(Constants.HOMESCREENCLR);
        selector.setLayout(new BoxLayout(selector, BoxLayout.X_AXIS));

        String[] countriesOptions = {"India"};
        ArrayList<String> statesOptions = new ArrayList<>();
        String[] statesOptionsArr = {};

        try {
            File statesFile = new File(MapComponent.class.getResource("/states.txt").toURI());
            Scanner scanner = new Scanner(statesFile);

            while (scanner.hasNextLine()) {
                statesOptions.add(scanner.nextLine());
            }

            statesOptionsArr = statesOptions.toArray(statesOptionsArr);

        } catch (Exception e) {
            statesOptions.add("Kerala");
            statesOptionsArr = statesOptions.toArray(statesOptionsArr);
        }

        // Create the JComboBox with the array
        JComboBox<String> countries = new JComboBox<>(countriesOptions);
        countries.setBackground(Constants.NAVBARCLR);
        countries.setForeground(Constants.TEXTCOLORCLR);
        countries.setFont(Constants.sr16);
        countries.setPreferredSize(new Dimension(100, 40));
        countries.setMaximumSize(countries.getPreferredSize());
        countries.setAlignmentY(Component.CENTER_ALIGNMENT);

        JComboBox<String> states = new JComboBox<>(statesOptionsArr);
        states.setSelectedItem("Kerala");
        states.setBackground(Constants.NAVBARCLR);
        states.setForeground(Constants.TEXTCOLORCLR);
        states.setFont(Constants.sr16);
        states.setPreferredSize(new Dimension(160, 40));
        states.setMaximumSize(states.getPreferredSize());
        states.setAlignmentY(Component.CENTER_ALIGNMENT);

        selector.add(Box.createRigidArea(new Dimension(20, 60)));
        selector.add(countries);
        selector.add(Box.createRigidArea(new Dimension(20, 5)));
        selector.add(states);

//        selector.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        selector.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        add(selector);

        // Actual Map

        JPanel mapPanel = new JPanel();
        mapPanel.setBackground(Color.yellow);
        add(mapPanel);
    }
}
