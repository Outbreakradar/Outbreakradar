package io.github.Outbreakradar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.cache.FileBasedLocalCache;

public class MapComponent extends JPanel {

    String currentState;
    RecentComponent recentComponent;
    JXMapViewer mapViewer;

    public static HashMap<String, double[]> latLong = new HashMap<>();

    static {
        latLong.put("Kerala", new double[] {10.850516, 76.271080});
        latLong.put("Karnataka", new double[] {15.317277, 75.713890});
        latLong.put("Tamil Nadu", new double[] {11.059821, 78.387451});
        latLong.put("Telangana", new double[] {17.123184, 79.208824});
        latLong.put("Madhya Pradesh", new double[] {23.473324, 77.947998});
        // States
        latLong.put("Andhra Pradesh", new double[] {16.5139, 80.6942}); // Amaravati
        latLong.put("Arunachal Pradesh", new double[] {27.0910, 93.6063}); // Itanagar
        latLong.put("Assam", new double[] {26.1445, 91.7362}); // Dispur
        latLong.put("Bihar", new double[] {25.5941, 85.1376}); // Patna
        latLong.put("Chhattisgarh", new double[] {21.2514, 81.6296}); // Raipur
        latLong.put("Goa", new double[] {15.4909, 73.8278}); // Panaji
        latLong.put("Gujarat", new double[] {23.2156, 72.6369}); // Gandhinagar
        latLong.put("Haryana", new double[] {30.7333, 76.7794}); // Chandigarh
        latLong.put("Himachal Pradesh", new double[] {31.1048, 77.1734}); // Shimla
        latLong.put("Jharkhand", new double[] {23.3441, 85.3096}); // Ranchi
        latLong.put("Maharashtra", new double[] {19.0760, 72.8777}); // Mumbai
        latLong.put("Manipur", new double[] {24.8170, 93.9368}); // Imphal
        latLong.put("Meghalaya", new double[] {25.5788, 91.8933}); // Shillong
        latLong.put("Mizoram", new double[] {23.7271, 92.7176}); // Aizawl
        latLong.put("Nagaland", new double[] {25.6747, 94.1100}); // Kohima
        latLong.put("Odisha", new double[] {20.2961, 85.8245}); // Bhubaneswar
        latLong.put("Punjab", new double[] {30.7333, 76.7794}); // Chandigarh
        latLong.put("Rajasthan", new double[] {26.9124, 75.7873}); // Jaipur
        latLong.put("Sikkim", new double[] {27.3314, 88.6138}); // Gangtok
        latLong.put("Tripura", new double[] {23.8315, 91.2868}); // Agartala
        latLong.put("Uttar Pradesh", new double[] {26.8467, 80.9462}); // Lucknow
        latLong.put("Uttarakhand", new double[] {30.3165, 78.0322}); // Dehradun
        latLong.put("West Bengal", new double[] {22.5726, 88.3639}); // Kolkata

// Union Territories
        latLong.put("Andaman and Nicobar Islands", new double[] {11.6234, 92.7265}); // Port Blair
        latLong.put("Chandigarh", new double[] {30.7333, 76.7794}); // Chandigarh
        latLong.put("Dadra and Nagar Haveli and Daman and Diu", new double[] {20.4283, 72.8397}); // Daman
        latLong.put("Delhi", new double[] {28.6139, 77.2090}); // New Delhi
        latLong.put("Jammu and Kashmir", new double[] {34.0837, 74.7973}); // Srinagar (Summer)
        latLong.put("Ladakh", new double[] {34.1526, 77.5770}); // Leh
        latLong.put("Lakshadweep", new double[] {10.5667, 72.6417}); // Kavaratti
        latLong.put("Puducherry", new double[] {11.9416, 79.8083}); // Puducherry
    }

    public MapComponent(RecentComponent recentComponent) {
        super();
        this.recentComponent = recentComponent;

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
        currentState = "Kerala";
        states.setBackground(Constants.NAVBARCLR);
        states.setForeground(Constants.TEXTCOLORCLR);
        states.setFont(Constants.sr16);
        states.setPreferredSize(new Dimension(160, 40));
        states.setMaximumSize(states.getPreferredSize());
        states.setAlignmentY(Component.CENTER_ALIGNMENT);
        states.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedState = (String) states.getSelectedItem();

                if (!currentState.equals(selectedState)) {
                    currentState = selectedState;
                    recentComponent.load(selectedState);
                    double[] cords = latLong.get(selectedState);
                    GeoPosition pos = new GeoPosition(cords[0],cords[1]);
                    mapViewer.setAddressLocation(pos);
                }

            }
        });

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


        mapViewer = new JXMapViewer();

        // Create a TileFactoryInfo for OpenStreetMap
//        TileFactoryInfo info = new OSMTileFactoryInfo();
        TileFactoryInfo info = new OSMTileFactoryInfo("OpenStreetMap", "https://tile.openstreetmap.org");

        DefaultTileFactory tileFactory = new DefaultTileFactory(info);

        mapViewer.setTileFactory(tileFactory);

        // Use 8 threads in parallel to load the tiles
        tileFactory.setThreadPoolSize(8);

        // Set the focus
//        GeoPosition frankfurt = new GeoPosition(50.11, 8.68);
        double[] keralaCords = latLong.get("Kerala");
        GeoPosition kerala = new GeoPosition(keralaCords[0],keralaCords[1]);
        mapViewer.setZoom(12);
        mapViewer.setAddressLocation(kerala);
//        mapViewer.setPreferredSize(mapPanel.getPreferredSize());

        // 1️⃣ Pan with mouse drag
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);

        // 2️⃣ Zoom with mouse wheel
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer));



        mapPanel.setLayout(new BorderLayout());
        mapPanel.add(mapViewer, BorderLayout.CENTER);

        File mapCacheFile = null;

//        try {
//            mapCacheFile = new File(MapComponent.class.getResource("/mapcache").toURI());
//            FileBasedLocalCache mapCache = new FileBasedLocalCache(mapCacheFile, true);
//            tileFactory.setLocalCache(mapCache);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        add(mapPanel);
    }
}
