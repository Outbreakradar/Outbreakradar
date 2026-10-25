package io.github.Outbreakradar;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

public class RecentComponent extends JPanel {

    public ArrayList<JPanel> outbreakPanels;
    public JPanel outbreakHolder;

    public MapComponent mc;

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

        outbreakPanels = new ArrayList<>();

        outbreakHolder = new JPanel();
        JScrollPane scrollPane = new JScrollPane(outbreakHolder);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
//        scrollPane.setBorder(null);
        outbreakHolder.setBackground(Constants.HOMESCREENCLR);
        outbreakHolder.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        outbreakHolder.setLayout(new BoxLayout(outbreakHolder, BoxLayout.Y_AXIS));

        load("Kerala");
//        fakeLoad();

//        int borderSize = 5;
//        int borderSize2 = 8;
//        int borderSize3 = borderSize2+8;
//
//        Outbreak[] outbreaks = null;
//
//        try {
//            outbreaks = Main.om.fetchOutbreakFromBackend("Kerala");
//        } catch (Exception e) {
//            System.out.println("Exception occured when fetching outbreaks");
//            e.printStackTrace();
//        }
//
//        if (outbreaks != null) {
//            for (Outbreak i : outbreaks) {
//                JPanelRounded panel;
//                JPanel panelWrapper;
//                panel = new JPanelRounded();
//                panel.setPreferredSize(new Dimension(450, 170));
////            panel.setMaximumSize(panel.getPreferredSize());
//                panel.setBackground(Constants.BOXCLR);
//                panel.setCornerRadius(40);
//                panel.setLayout(new BorderLayout());
//
//                JPanelRounded dName = new JPanelRounded();
//                dName.setBackground(Constants.INNERBOXCLR);
//                JLabel dNameLabel = new JLabel(i.disease.name);
//                dNameLabel.setFont(Constants.sb20);
//                dNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//                dNameLabel.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
//                dName.add(dNameLabel);
//                dName.setAlignmentX(Component.LEFT_ALIGNMENT);
//                dName.setCursor(new Cursor(Cursor.HAND_CURSOR));
//                dName.addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mouseEntered(MouseEvent e) {
//
//                        dNameLabel.setForeground(new Color(0x1392ED));
//
//                    }
//
//                    @Override
//                    public void mouseExited(MouseEvent e) {
//
//                        dNameLabel.setForeground(new Color(0x000000));
//                    }
//
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        new DiseaseAlertBox(new Disease("dengue", null, null));
//                    }
//                });
//
//                JPanel dNameWrapper = new JPanel();
//                dNameWrapper.setLayout(new FlowLayout(FlowLayout.LEFT));
//                dNameWrapper.setOpaque(false);
//                dNameWrapper.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize2, borderSize2, borderSize2));
//                dNameWrapper.add(dName);
//
//                panel.add(dNameWrapper, BorderLayout.NORTH);
//                JLabel desc = new JLabel(i.description);
//                desc.setForeground(Constants.TEXTCOLORCLR);
//                desc.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize3, borderSize2, borderSize2));
//                desc.setFont(Constants.sr16);
//                panel.add(desc, BorderLayout.CENTER);
//
//                String locations = "";
//                String placeName = "";
//
//                for (int m = 0; m < i.locations.length; m++) {
//                    placeName = i.locations[m].place;
//                    locations += placeName.substring(0, 1).toUpperCase() + placeName.substring(1).toLowerCase() + ", ";
//                }
//
//                // Strip the last ", "
//                locations = locations.substring(0, locations.length() - 2);
//
//                JLabel locationsLabel = new JLabel(locations);
//                locationsLabel.setFont(Constants.sb16);
//                locationsLabel.setForeground(Constants.TEXTCOLORCLR);
//                locationsLabel.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize3,
//                        borderSize3, borderSize2));
//
//
//                panel.add(locationsLabel, BorderLayout.SOUTH);
//
//                panelWrapper = new JPanel();
//                panelWrapper.setBackground(Constants.HOMESCREENCLR);
//                panelWrapper.add(panel);
//                outbreakPanels.add(panelWrapper);
//                outbreakHolder.add(Box.createRigidArea(new Dimension(5, 40)));
//                outbreakHolder.add(panelWrapper);
//
//            }
//        }




        add(scrollPane);

    }

    public void fakeLoad() {
        String state = "Kerala";

        outbreakHolder.removeAll();

        int borderSize = 5;
        int borderSize2 = 8;
        int borderSize3 = borderSize2+8;

        Outbreak[] outbreaks = null;

//        try {
//            outbreaks = Main.om.fetchOutbreakFromBackend(state);
//        } catch (Exception e) {
//            System.out.println("Exception occured when fetching outbreaks");
//            e.printStackTrace();
//        }

        outbreaks = new Outbreak[1];
        Disease d = new Disease("Dengue Fever", null, null);
        Location[] ls = new Location[1];
        ls[0] = new Location("India", "Kerala", "Kochi");
        Outbreak o = new Outbreak(ls, d, "Empty Description");
        outbreaks[0] = o;

        if (outbreaks != null) {
            for (Outbreak i : outbreaks) {
                JPanelRounded panel;
                JPanel panelWrapper;
                panel = new JPanelRounded();
                panel.setPreferredSize(new Dimension(450, 170));
//            panel.setMaximumSize(panel.getPreferredSize());
                panel.setBackground(Constants.BOXCLR);
                panel.setCornerRadius(40);
                panel.setLayout(new BorderLayout());

                JPanelRounded dName = new JPanelRounded();
                dName.setBackground(Constants.INNERBOXCLR);
                JLabel dNameLabel = new JLabel(i.disease.name);
                dNameLabel.setFont(Constants.sb20);
                dNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                dNameLabel.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
                dName.add(dNameLabel);
                dName.setAlignmentX(Component.LEFT_ALIGNMENT);
                dName.setCursor(new Cursor(Cursor.HAND_CURSOR));

                Container parentOfDialog = this;

                dName.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {

                        dNameLabel.setForeground(new Color(0x1392ED));

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                        dNameLabel.setForeground(new Color(0x000000));
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new DiseaseAlertBox(new Disease(i.disease.name, null, null), parentOfDialog);
                    }
                });

                JPanel dNameWrapper = new JPanel();
                dNameWrapper.setLayout(new FlowLayout(FlowLayout.LEFT));
                dNameWrapper.setOpaque(false);
                dNameWrapper.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize2, borderSize2, borderSize2));
                dNameWrapper.add(dName);

                panel.add(dNameWrapper, BorderLayout.NORTH);
                JLabel desc = new JLabel(i.description);
                desc.setToolTipText(i.description);
                desc.setForeground(Constants.TEXTCOLORCLR);
                desc.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize3, borderSize2, borderSize2));
                desc.setFont(Constants.sr16);
                panel.add(desc, BorderLayout.CENTER);

                String locations = "";
                String placeName = "";

                for (int m = 0; m < i.locations.length; m++) {
                    placeName = i.locations[m].place;
//                    locations += placeName.substring(0, 1).toUpperCase() + placeName.substring(1).toLowerCase() + ", ";
                    locations += placeName + ", ";
                }

                // Strip the last ", "
                locations = locations.substring(0, locations.length() - 2);

                System.out.println(locations);


                JLabel locationsLabel = new JLabel(locations);
                locationsLabel.setFont(Constants.sb16);
                locationsLabel.setForeground(Constants.TEXTCOLORCLR);
                locationsLabel.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize3,
                        borderSize3, borderSize2));
                locationsLabel.setToolTipText(locations);


                panel.add(locationsLabel, BorderLayout.SOUTH);

                panelWrapper = new JPanel();
                panelWrapper.setBackground(Constants.HOMESCREENCLR);
                panelWrapper.add(panel);
                outbreakPanels.add(panelWrapper);
                outbreakHolder.add(Box.createRigidArea(new Dimension(5, 40)));
                outbreakHolder.add(panelWrapper);

            }
        }

        outbreakHolder.repaint();
        outbreakHolder.revalidate();


    }


    public void load(String state) {
        outbreakHolder.removeAll();

        int borderSize = 5;
        int borderSize2 = 8;
        int borderSize3 = borderSize2+8;

        Outbreak[] outbreaks = null;

//        SwingWorker<Outbreak[], Void> worker = new SwingWorker<>() {
//            @Override
//            protected Outbreak[] doInBackground() throws Exception {
//                try {
//                    return Main.om.fetchOutbreakFromBackend(state);
//                } catch (Exception e) {
//                    System.out.println("Exception occured when fetching outbreaks");
//                    return null;
//                }
//            }
//
//            protected void done() {
//                try {
//                    Outbreak outbreaks[] = get();
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        };

        try {
            outbreaks = Main.om.fetchOutbreakFromBackend(state);
        } catch (Exception e) {
            System.out.println("Exception occured when fetching outbreaks");
            e.printStackTrace();
        }

        if (outbreaks != null) {
            for (Outbreak i : outbreaks) {
                JPanelRounded panel;
                JPanel panelWrapper;
                panel = new JPanelRounded();
                panel.setPreferredSize(new Dimension(450, 170));
//            panel.setMaximumSize(panel.getPreferredSize());
                panel.setBackground(Constants.BOXCLR);
                panel.setCornerRadius(40);
                panel.setLayout(new BorderLayout());

                JPanelRounded dName = new JPanelRounded();
                dName.setBackground(Constants.INNERBOXCLR);
                JLabel dNameLabel = new JLabel(i.disease.name);
                dNameLabel.setFont(Constants.sb20);
                dNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                dNameLabel.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
                dName.add(dNameLabel);
                dName.setAlignmentX(Component.LEFT_ALIGNMENT);
                dName.setCursor(new Cursor(Cursor.HAND_CURSOR));

                Container parentOfDialog = this;

                dName.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {

                        dNameLabel.setForeground(new Color(0x1392ED));

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                        dNameLabel.setForeground(new Color(0x000000));
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new DiseaseAlertBox(new Disease(i.disease.name, null, null), parentOfDialog);
                    }
                });

                JPanel dNameWrapper = new JPanel();
                dNameWrapper.setLayout(new FlowLayout(FlowLayout.LEFT));
                dNameWrapper.setOpaque(false);
                dNameWrapper.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize2, borderSize2, borderSize2));
                dNameWrapper.add(dName);

                panel.add(dNameWrapper, BorderLayout.NORTH);
                JLabel desc = new JLabel(i.description);
                desc.setToolTipText(i.description);
                desc.setForeground(Constants.TEXTCOLORCLR);
                desc.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize3, borderSize2, borderSize2));
                desc.setFont(Constants.sr16);
                panel.add(desc, BorderLayout.CENTER);

                String locations = "";
                String placeName = "";

                for (int m = 0; m < i.locations.length; m++) {
                    placeName = i.locations[m].place;

//                    locations += placeName.substring(0, 1).toUpperCase() + placeName.substring(1).toLowerCase() + ", ";
                    locations += placeName + ", ";
                }

                // Strip the last ", "
                locations = locations.substring(0, locations.length() - 2);

                System.out.println(locations);


                JLabel locationsLabel = new JLabel(locations);
                locationsLabel.setFont(Constants.sb16);
                locationsLabel.setForeground(Constants.TEXTCOLORCLR);
                locationsLabel.setBorder(BorderFactory.createEmptyBorder(borderSize2, borderSize3,
                        borderSize3, borderSize2));
                locationsLabel.setToolTipText(locations);


                panel.add(locationsLabel, BorderLayout.SOUTH);

                panelWrapper = new JPanel();
                panelWrapper.setBackground(Constants.HOMESCREENCLR);
                panelWrapper.add(panel);
                outbreakPanels.add(panelWrapper);
                outbreakHolder.add(Box.createRigidArea(new Dimension(5, 40)));
                outbreakHolder.add(panelWrapper);

            }
        }

        outbreakHolder.repaint();
        outbreakHolder.revalidate();


    }

    public void setMc(MapComponent mc) {
        this.mc = mc;
    }
}
