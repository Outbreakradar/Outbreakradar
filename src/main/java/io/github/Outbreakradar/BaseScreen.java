package io.github.Outbreakradar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class BaseScreen extends JFrame {

    int current = 0;

    // BaseScreen manages a navbar JPanel and HomeScreen()
    public BaseScreen() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Outbreakradar");
        setSize(1280,720);

        setLayout(new BorderLayout());

        HomeScreen hs = new HomeScreen();
        FavoritesScreen fs = new FavoritesScreen();

        // Navbar initialization
        JPanel navbar = new JPanel();
        navbar.setBackground(new Color(Constants.NAVBARCOLOR));
        navbar.setPreferredSize(new Dimension(180, Integer.MAX_VALUE));
        navbar.setMaximumSize(new Dimension(180, Integer.MAX_VALUE));
        navbar.setLayout(new BoxLayout(navbar, BoxLayout.Y_AXIS));


        Font sansationRegular, sansationBold, sr20, sr16;
        File srFile = new File("src/main/resources/Sansation-Font/Sansation-Regular.ttf");
//        File srFile = new File(getClass().getResource("/Sansation-Font/Sansation-Regular.ttf").toURI());
        File sbFile = new File("src/main/resources/Sansation-Font/Sansation-Bold.ttf");

        try {
            sansationRegular = Font.createFont(Font.TRUETYPE_FONT, srFile);
            sansationBold = Font.createFont(Font.TRUETYPE_FONT, sbFile);

        } catch (Exception e) {
            sansationRegular = new Font(Font.SERIF, Font.PLAIN, 20);
            sansationBold = new Font(Font.SERIF, Font.BOLD, 20);

        }

        sr20 = sansationRegular.deriveFont(20f);
        sr16 = sansationRegular.deriveFont(16f);

        JLabel appname = new JLabel("Outbreakradar");
        appname.setFont(sr20);
        appname.setForeground(Constants.TEXTCOLORCLR);

//        appname.setHorizontalAlignment(JLabel.CENTER);
        JPanel appnameWrapper = new JPanel(new GridBagLayout());
        appnameWrapper.setOpaque(false);
        appnameWrapper.setPreferredSize(new Dimension(180, 80));
        appnameWrapper.setMaximumSize(
                new Dimension(
                        180, appnameWrapper.getPreferredSize().height)
        );

        appnameWrapper.add(appname);

        JButtonRounded home = new JButtonRounded();
        home.setRadius(18);
        home.setBorderColor(Constants.BTNSTROKECLR);
        home.setBorderSize(15);
//        ImageIcon homeIcon = new ImageIcon(img);
        ImageIcon homeIcon = new ImageIcon(BaseScreen.class.getResource("/home.png"));
        Image resizedImg = homeIcon.getImage().getScaledInstance(32,32, Image.SCALE_SMOOTH);
        homeIcon = new ImageIcon(resizedImg);

        home.setText("Home");
        home.setIcon(homeIcon);
        home.setFont(sr20);
        home.setBackground(Constants.NAVBARITEMSCLR);
        home.setForeground(Constants.TEXTCOLORCLR);
        home.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        home.setFocusPainted(false);
        home.setIconTextGap(25);

        int btnWrapperHeight = 70;

        JPanel homeWrapper = new JPanel(new GridBagLayout());
        homeWrapper.setPreferredSize(new Dimension(Integer.MAX_VALUE, btnWrapperHeight));
        homeWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnWrapperHeight));
        homeWrapper.setOpaque(false);
        homeWrapper.add(home);

        JButtonRounded fav = new JButtonRounded();
        ImageIcon favIcon = new ImageIcon(BaseScreen.class.getResource("/fav.png"));
        Image resizedFavIcon = favIcon.getImage().getScaledInstance(32,32, Image.SCALE_SMOOTH);
        favIcon = new ImageIcon(resizedFavIcon);
        fav.setIcon(favIcon);
        fav.setText("Favorites");
        fav.setFont(sr16);
        fav.setBackground(Constants.NAVBARITEMSCLR);
        fav.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        fav.setForeground(Constants.TEXTCOLORCLR);
        fav.setIconTextGap(15);
        fav.setFocusPainted(false);


        JPanel favWrapper = new JPanel(new GridBagLayout());
        favWrapper.add(fav);
        favWrapper.setOpaque(false);
        favWrapper.setPreferredSize(new Dimension(Integer.MAX_VALUE, btnWrapperHeight));
        favWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnWrapperHeight));

        JButtonRounded credits = new JButtonRounded();
        credits.setText("Credits");
        credits.setFont(sr20);
        credits.setBackground(Constants.NAVBARITEMSCLR);
        credits.setBorder(BorderFactory.createEmptyBorder(12, 38, 12, 38));
        credits.setForeground(Constants.TEXTCOLORCLR);
        credits.setFocusPainted(false);

        JPanel creditsWrapper = new JPanel(new GridBagLayout());
        creditsWrapper.add(credits);
        creditsWrapper.setOpaque(false);
        creditsWrapper.setPreferredSize(new Dimension(Integer.MAX_VALUE, btnWrapperHeight+5));
        creditsWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnWrapperHeight+5));

//        JPanel creditsWrapperWrapper = new JPanel();
//        creditsWrapperWrapper.setLayout(new BoxLayout(creditsWrapperWrapper, BoxLayout.Y_AXIS));
//        creditsWrapperWrapper.add(creditsWrapper);
//        creditsWrapperWrapper.setOpaque(false);

        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fav.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        credits.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        home.setBackgroundOg(Constants.NAVBARITEMSCLR);
        fav.setBackgroundOg(Constants.NAVBARITEMSCLR);
        credits.setBackgroundOg(Constants.NAVBARITEMSCLR);

        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                fav.unpress();
                credits.unpress();

                if (current == 0) return;
                else if (current == 1) {
                    remove(fs);
                    add(hs, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                    current = 0;
                } else if(current == 2) {
                    System.out.println("TODO");
                }
            }
        });

        fav.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {


                home.unpress();
                credits.unpress();

                if (current == 1) return;
                else if (current == 0) {
                    remove(hs);
                    add(fs, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                    current = 1;
                } else if (current == 2) {
                    System.out.println("TODO");
                }

            }
        });

        credits.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                home.unpress();
                fav.unpress();
            }
        });

        home.press();


        navbar.add(appnameWrapper);
        navbar.add(homeWrapper);
        navbar.add(favWrapper);
        navbar.add(Box.createVerticalGlue());
        navbar.add(creditsWrapper);

        add(navbar, BorderLayout.WEST);
        add(hs, BorderLayout.CENTER);
        setVisible(true);
    }
}
