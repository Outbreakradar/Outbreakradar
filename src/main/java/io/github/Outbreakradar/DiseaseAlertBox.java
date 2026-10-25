package io.github.Outbreakradar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

// Kinda messy code here since it creates it's parent JDialog inside it
public class DiseaseAlertBox extends JPanelRounded {

    Container parent;

    DiseaseAlertBox(Disease d, Container parent) {
        super();

        this.parent = parent;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        int padding = 10;

        try {
            d.fetchDetails();
        } catch (Exception e) {
            e.printStackTrace();
            d.symptoms = new String[] {"Error occured when finding details"};
            d.treatments = new String[] {"Error occured when finding details"};
        }

        String symptomsString = "";
        String treatmentsString = "";

        for (String symptom : d.symptoms) {
            symptomsString += symptom + ", ";
        }

        symptomsString = symptomsString.substring(0, symptomsString.length() - 2);

        for (String treatment : d.treatments) {
            treatmentsString += treatment + ", ";
        }

        treatmentsString = treatmentsString.substring(0, treatmentsString.length() - 2);

        putClientProperty("Panel.arc", 20);
//        setMaximumSize(new Dimension(300,100));

        Window window = SwingUtilities.getWindowAncestor(parent);

        JDialog dialog = new JDialog(window, "Disease Details", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setBackground(Constants.BOXCLR);

//        add(Box.createRigidArea(new Dimension(300,100)));

        setBackground(Constants.BOXCLR);

        JPanel name = new JPanel();
        JPanel symptoms = new JPanel();
        JPanel treatments = new JPanel();

        JButton star = new JButton();
        JButton close = new JButton();

        ImageIcon starIcon = new ImageIcon(DiseaseAlertBox.class.getResource("/emptystar.png"));
        Image resizedStarIcon = starIcon.getImage().getScaledInstance(32,32, Image.SCALE_SMOOTH);
        starIcon = new ImageIcon(resizedStarIcon);
        star.setIcon(starIcon);
        star.setOpaque(false);
        star.setBorderPainted(false);
        star.setBackground(Constants.BOXCLR);

        ImageIcon closeIcon = new ImageIcon(DiseaseAlertBox.class.getResource("/close.png"));
        Image resizedCloseIcon = closeIcon.getImage().getScaledInstance(32,32, Image.SCALE_SMOOTH);
        closeIcon = new ImageIcon(resizedCloseIcon);
        close.setIcon(closeIcon);
        close.setOpaque(false);
        close.setBorderPainted(false);
        close.setBackground(Constants.BOXCLR);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        name.setBackground(Constants.BOXCLR);
        symptoms.setBackground(Constants.BOXCLR);
        treatments.setBackground(Constants.BOXCLR);

        Dimension size = new Dimension(600, 100);

        setPreferredSize(new Dimension(600, 300));

//        name.setMinimumSize(size);
//        symptoms.setMinimumSize(size);
//        treatments.setMinimumSize(size);

//        name.setPreferredSize(new Dimension(100, 50));

//        name.add(new JLabel("Hello"));
        symptoms.add(new JLabel("World"));

        JPanel firstRow = new JPanel();
//        BoxLayout firstRowLayout = new BoxLayout(firstRow, BoxLayout.X_AXIS);
//        firstRow.setLayout(firstRowLayout);
        firstRow.setLayout(new BorderLayout());
//        firstRow.setPreferredSize(new Dimension(Integer.MAX_VALUE, 50));

        firstRow.add(name, BorderLayout.WEST);

        JPanel middle = new JPanel();
        middle.setBackground(Constants.BOXCLR);
        middle.add(new JLabel(""));

        firstRow.add(middle, BorderLayout.CENTER);

        JPanel iconBtnWrapper = new JPanel();
        BoxLayout iconBtnWrapperLayout = new BoxLayout(iconBtnWrapper, BoxLayout.X_AXIS);
        iconBtnWrapper.setLayout(iconBtnWrapperLayout);
        iconBtnWrapper.setPreferredSize(new Dimension(100, 1));

        iconBtnWrapper.add(star);
        iconBtnWrapper.add(Box.createHorizontalGlue());
        iconBtnWrapper.add(close);
        iconBtnWrapper.add(Box.createRigidArea(new Dimension(10,1)));

        iconBtnWrapper.setBackground(Constants.BOXCLR);
        iconBtnWrapper.setAlignmentY(Component.CENTER_ALIGNMENT);


//        firstRow.add(Box.createHorizontalGlue());

        firstRow.add(iconBtnWrapper, BorderLayout.EAST);

        int borderSize = 5;

        JPanelRounded dName = new JPanelRounded();
        dName.setBackground(Constants.INNERBOXCLR);
        JLabel dNameLabel = new JLabel(d.name);
        dNameLabel.setFont(Constants.sb20);
        dNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dNameLabel.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
        dName.add(dNameLabel);
        dName.setAlignmentX(Component.LEFT_ALIGNMENT);

        name.add(Box.createRigidArea(new Dimension(padding, 1)));
        name.add(dName);

//        add(name);
//        add(symptoms);
//        add(treatments);

        add(Box.createRigidArea(new Dimension(1,padding)));
        add(firstRow);
        add(Box.createVerticalGlue());
        add(Box.createRigidArea(new Dimension(1, padding)));

        JPanel secondRow = new JPanel();

        JPanelRounded dName2 = new JPanelRounded();
        BoxLayout dName2Layout = new BoxLayout(dName2, BoxLayout.Y_AXIS);
        dName2.setLayout(dName2Layout);
        dName2.setBackground(Constants.INNERBOXCLR);
        dName2.setPreferredSize(new Dimension(550, 90));
        JLabel dNameLabel2 = new JLabel("Symptoms");
        dNameLabel2.setFont(Constants.sb20);
        dNameLabel2.setAlignmentX(Component.LEFT_ALIGNMENT);
        dNameLabel2.setBorder(BorderFactory.createEmptyBorder(padding, padding, 0, 0));
        dNameLabel2.setHorizontalAlignment(SwingConstants.LEFT);

        // Actually this is symptomsLabel
        JLabel treatmentsLabel = new JLabel(symptomsString);
        treatmentsLabel.setToolTipText(symptomsString);
        treatmentsLabel.setFont(Constants.sr20);
        treatmentsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        treatmentsLabel.setBorder(BorderFactory.createEmptyBorder(padding, padding, 0, 0));
        treatmentsLabel.setHorizontalAlignment(SwingConstants.LEFT);

        dName2.add(dNameLabel2);
        dName2.add(treatmentsLabel);
        dName2.setAlignmentX(Component.LEFT_ALIGNMENT);

        secondRow.setBackground(Constants.BOXCLR);
        secondRow.add(Box.createRigidArea(new Dimension(padding, 1)));
        secondRow.add(dName2);
        secondRow.add(Box.createRigidArea(new Dimension(padding, 1)));
        add(secondRow);

        add(Box.createRigidArea(new Dimension(1, padding)));

        JPanel thirdRow = new JPanel();

        JPanelRounded dName3 = new JPanelRounded();
        BoxLayout dName3Layout = new BoxLayout(dName3, BoxLayout.Y_AXIS);
        dName3.setLayout(dName3Layout);
        dName3.setBackground(Constants.INNERBOXCLR);
        dName3.setPreferredSize(new Dimension(550, 90));
//        dName3.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        JLabel dNameLabel3 = new JLabel("Treatments");
        dNameLabel3.setFont(Constants.sb20);
        dNameLabel3.setAlignmentX(Component.LEFT_ALIGNMENT);
        dNameLabel3.setBorder(BorderFactory.createEmptyBorder(padding, padding, 0, 0));

        // Actually this is treatmentsLabel
        JLabel symptopmsLabel = new JLabel(treatmentsString);
        symptopmsLabel.setToolTipText(treatmentsString);
        symptopmsLabel.setFont(Constants.sr20);
        symptopmsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        symptopmsLabel.setBorder(BorderFactory.createEmptyBorder(padding, padding, 0, 0));
        symptopmsLabel.setHorizontalAlignment(SwingConstants.LEFT);

        dName3.add(dNameLabel3);
        dName3.add(symptopmsLabel);
        dName3.setAlignmentX(Component.LEFT_ALIGNMENT);

        thirdRow.setBackground(Constants.BOXCLR);
        thirdRow.add(Box.createRigidArea(new Dimension(padding, 1)));
        thirdRow.add(dName3);
        thirdRow.add(Box.createRigidArea(new Dimension(padding, 1)));
        add(thirdRow);

        add(Box.createRigidArea(new Dimension(1, padding)));

        dialog.add(this, BorderLayout.CENTER);
        dialog.setUndecorated(true);
        dialog.pack();
        dialog.setLocationRelativeTo(parent.getParent());
//        dialog.setShape(new RoundRectangle2D.Double(
//                0, 0, dialog.getWidth(), dialog.getHeight(), 20, 20
//        ));
        setBorder(BorderFactory.createLineBorder(Constants.BTNSTROKECLR, 5));
        dialog.setVisible(true);



    }
}
