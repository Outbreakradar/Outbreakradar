package io.github.Outbreakradar;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RecentComponent extends JPanel {

    public RecentComponent() {
        super();

        setBackground(Constants.HOMESCREENCLR);

        MatteBorder leftBorder = new MatteBorder(0, 1, 0, 0, new Color(0x98A7B4));
        setBorder(leftBorder);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel rout = new JLabel("Recent Outbreaks");
        rout.setForeground(Constants.BIGTEXTCLR);
        rout.setFont(Constants.sr32);
        int routBorder = 30;
        rout.setBorder(BorderFactory.createEmptyBorder(routBorder, routBorder, routBorder, routBorder));

        add(rout);

        ArrayList<JPanel> outbreakPanels = new ArrayList<>();

        JPanel outbreakHolder = new JPanel();
        JScrollPane scrollPane = new JScrollPane(outbreakHolder);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
//        scrollPane.setBorder(null);
        outbreakHolder.setBackground(Constants.HOMESCREENCLR);
        outbreakHolder.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        outbreakHolder.setLayout(new BoxLayout(outbreakHolder, BoxLayout.Y_AXIS));

        JPanelRounded panel;
        JPanel panelWrapper;

        int borderSize = 5;
        int borderSize2 = 8;
        int borderSize3 = borderSize2+8;


//        for (int j = 0; j<2; j++) {
//        for (Outbreak i : Main.om.testFetchOutbreaksFromBackend()) {
//            panel = new JPanelRounded();
//            panel.setPreferredSize(new Dimension(450, 170));
////            panel.setMaximumSize(panel.getPreferredSize());
//            panel.setBackground(Constants.BOXCLR);
//            panel.setCornerRadius(40);
//            panel.setLayout(new BorderLayout());
//
//            JPanelRounded dName = new JPanelRounded();
//            dName.setBackground(Constants.INNERBOXCLR);
//            JLabel dNameLabel = new JLabel(i.disease.name);
//            dNameLabel.setFont(Constants.sb20);
//            dNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//            dNameLabel.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
//            dName.add(dNameLabel);
//            dName.setAlignmentX(Component.LEFT_ALIGNMENT);
//            dName.setCursor(new Cursor(Cursor.HAND_CURSOR));
//            dName.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseEntered(MouseEvent e) {
//
//                    dNameLabel.setForeground(new Color(0x1392ED));
//
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//
//                    dNameLabel.setForeground(new Color(0x000000));
//                }
//
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    new DiseaseAlertBox(new Disease("dengue", null, null));
//                }
//            });
//
//            JPanel dNameWrapper = new JPanel();
//            dNameWrapper.setLayout(new FlowLayout(FlowLayout.LEFT));
//            dNameWrapper.setOpaque(false);
//            dNameWrapper.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize2, borderSize2, borderSize2));
//            dNameWrapper.add(dName);
//
//            panel.add(dNameWrapper, BorderLayout.NORTH);
//            JLabel desc = new JLabel(i.description);
//            desc.setForeground(Constants.TEXTCOLORCLR);
//            desc.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize3, borderSize2, borderSize2));
//            desc.setFont(Constants.sr16);
//            panel.add(desc, BorderLayout.CENTER);
//
//            String locations = "";
//            String placeName = "";
//
//            for (int m = 0; m < i.locations.length; m++) {
//                placeName = i.locations[m].place;
//                locations += placeName.substring(0, 1).toUpperCase() + placeName.substring(1).toLowerCase()+ ", ";
//            }
//
//            // Strip the last ", "
//            locations = locations.substring(0, locations.length()-2);
//
//            JLabel locationsLabel = new JLabel(locations);
//            locationsLabel.setFont(Constants.sb16);
//            locationsLabel.setForeground(Constants.TEXTCOLORCLR);
//            locationsLabel.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize3,
//                    borderSize3, borderSize2));
//
//
//
//            panel.add(locationsLabel, BorderLayout.SOUTH);
//
//            panelWrapper = new JPanel();
//            panelWrapper.setBackground(Constants.HOMESCREENCLR);
//            panelWrapper.add(panel);
//            outbreakPanels.add(panelWrapper);
//            outbreakHolder.add(Box.createRigidArea(new Dimension(5, 40)));
//            outbreakHolder.add(panelWrapper);
//
//        }
//        }





        add(scrollPane);

    }
}
