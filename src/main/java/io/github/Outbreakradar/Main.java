package io.github.Outbreakradar;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class Main {

    public static OutbreakManager om = new OutbreakManager();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::run);

    }

    public static void run() {
        // UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Constants.BTNHOVERCLR));

        FlatLightLaf.setup();
        BaseScreen base = new BaseScreen();
//        try {
//            om.fetchOutbreakFromBackend();
//        }
//        catch(Exception e)
//        {
//            System.out.println("An error occured!");
//
//        }
    }
}
