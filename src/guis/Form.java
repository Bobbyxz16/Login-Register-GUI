package guis;

import constants.CommonConstans;

import javax.swing.*;

public class Form extends JFrame {
    // Create constructor
    public Form(String title){
        // Set the title of the title bar
        super(title);

        // Set the size of the Gui
        setSize(520,720);

        // Configure GUI to end process after closing
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set layout to null to disable layout management so we can use absolute positioning
        // to place the components wherever we want
        setLayout(null);

        // Load Gui in the center of the screen
        setLocationRelativeTo(null);

        // Prevent Gui from changing size
        setResizable(false);

        // Change the background color of the GUI
        getContentPane().setBackground(CommonConstans.PRIMARY_COLOR);
    }
}
