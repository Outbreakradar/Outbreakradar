package io.github.Outbreakradar;

import java.awt.*;
import java.io.File;
import java.io.IOException;

// All constants like color hex codes are stored here
public class Constants {

    public static int NAVBARCOLOR = 0x088ED5;
    public static int HOMESCREENCOLOR = 0xD4E9FB;
    public static int RECENTPANELCOLOR = 0xCAE9FF;
    public static int BIGTEXTCOLOR = 0x4E4E4E;
    public static int BOXCOLOR = 0x0A5780;
    public static int INNERBOXCOLOR = 0xDCDAD4;
    public static int STARCOLOR = 0xF2F532;
    public static int TEXTCOLOR = 0xFFFFFF;

    public static Color INNERBOXCLR = new Color(INNERBOXCOLOR);
    public static Color BOXCLR = new Color(BOXCOLOR);
    public static Color TEXTCOLORCLR = new Color(TEXTCOLOR);
    public static Color NAVBARITEMSCLR = new Color(0x43ACE0);
    public static Color BTNSTROKECLR = new Color(0xD9DADA);
    public static Color BTNHOVERCLR = new Color(0x4DB5E9);
    public static Color HOMESCREENCLR = new Color(HOMESCREENCOLOR);
    public static Color NAVBARCLR = new Color(NAVBARCOLOR);
    public static Color BIGTEXTCLR = new Color(BIGTEXTCOLOR);

    public static Font sansationRegular, sansationBold, sr20, sr16, sr32, sb20, sb16;
    public static File srFile = new File("src/main/resources/Sansation-Font/Sansation-Regular.ttf");
    //        File srFile = new File(getClass().getResource("/Sansation-Font/Sansation-Regular.ttf").toURI());
    public static File sbFile = new File("src/main/resources/Sansation-Font/Sansation-Bold.ttf");

    static {
        try {
            sansationRegular = Font.createFont(Font.TRUETYPE_FONT, srFile);
            sansationBold = Font.createFont(Font.TRUETYPE_FONT, sbFile);

        } catch (Exception e) {
            sansationRegular = new Font(Font.SERIF, Font.PLAIN, 20);
            sansationBold = new Font(Font.SERIF, Font.BOLD, 20);

        }


        sr20 = sansationRegular.deriveFont(20f);
        sr16 = sansationRegular.deriveFont(16f);
        sr32 = sansationRegular.deriveFont(32f);
        sb20 = sansationBold.deriveFont(20f);
        sb16 = sansationBold.deriveFont(16f);

    }

}
