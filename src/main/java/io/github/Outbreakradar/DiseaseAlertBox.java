package io.github.Outbreakradar;

import javax.swing.*;
import java.awt.*;

public class DiseaseAlertBox extends JPanelRounded {

    DiseaseAlertBox(Disease d) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        try {
            d.fetchDetails();
        } catch (Exception e) {
            d.symptoms = new String[] {"Error occured when finding details"};
            d.treatments = new String[] {"Error occured when finding details"};
        }

        putClientProperty("Panel.arc", 20);
//        setMaximumSize(new Dimension(300,100));

        Window window = SwingUtilities.getWindowAncestor(this);

        JDialog dialog = new JDialog(window, "Disease Details", Dialog.ModalityType.APPLICATION_MODAL);

//        add(Box.createRigidArea(new Dimension(300,100)));

        setBackground(Constants.BOXCLR);

        JPanel name = new JPanel();
        JPanel symptoms = new JPanel();
        JPanel treatments = new JPanel();

        name.setBackground(Constants.BOXCLR);
        symptoms.setBackground(Constants.BOXCLR);
        treatments.setBackground(Constants.BOXCLR);

        Dimension size = new Dimension(600, 100);

        name.setMinimumSize(size);
        symptoms.setMinimumSize(size);
        treatments.setMinimumSize(size);

        name.add(new JLabel("Hello"));
        symptoms.add(new JLabel("World"));

        add(name);
        add(symptoms);
        add(treatments);



        dialog.add(this, BorderLayout.CENTER);
        dialog.setLocationRelativeTo(window);
        dialog.setUndecorated(true);
        dialog.pack();
        dialog.setVisible(true);


    }
}
