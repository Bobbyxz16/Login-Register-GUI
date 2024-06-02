package guis;

import constants.CommonConstans;
import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterFormGUI extends Form {
    public RegisterFormGUI() {
        super("Register");
        addGuiComponents();
    }

    private void addGuiComponents(){
        // Create login label
        JLabel registerLabel = new JLabel("Register");

        // Configure component's x,y positions and weight/height values relatives to the GUI
        registerLabel.setBounds(0,25,520,100);

        // Change font color
        registerLabel.setForeground(CommonConstans.TEXT_COLOR);

        // Change the font size
        registerLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        // Center text
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add component to GUI
        add(registerLabel);

        // Create username label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30,150,400,25);
        usernameLabel.setForeground(CommonConstans.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN,18));

        // Create username text field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(30,185,450,55);
        usernameField.setBackground(CommonConstans.SECONDARY_COLOR);
        usernameField.setForeground(CommonConstans.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(usernameField);
        add(usernameLabel);

        // Create password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30,255,400,25);
        passwordLabel.setForeground(CommonConstans.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN,18));

        // Create username text field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30,285,450,55);
        passwordField.setBackground(CommonConstans.SECONDARY_COLOR);
        passwordField.setForeground(CommonConstans.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordField);
        add(passwordLabel);

        // Create re-enter password label
        JLabel rePasswordLabel = new JLabel("Re-enter Password:");
        rePasswordLabel.setBounds(30,365,400,25);
        rePasswordLabel.setForeground(CommonConstans.TEXT_COLOR);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN,18));

        // Create username text field
        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(30,395,450,55);
        rePasswordField.setBackground(CommonConstans.SECONDARY_COLOR);
        rePasswordField.setForeground(CommonConstans.TEXT_COLOR);
        rePasswordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(rePasswordLabel);
        add(rePasswordField);

        // Create register button
        JButton registernButton = new JButton("Register");
        registernButton.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Change the cursor to a hand when hover over the button
        registernButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registernButton.setBackground(CommonConstans.TEXT_COLOR);
        registernButton.setBounds(125,520, 250,50);
        registernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get username
                String username = usernameField.getText();

                // Get password
                String password = new String(passwordField.getPassword());

                // Get re-password
                String rePassword = new String(rePasswordField.getPassword());

                // Validate user input
                if(validateUserInput(username, password,rePassword)) {
                    // Register user to the database
                    if(MyJDBC.register(username, password)){
                      // Dispose of this Gui
                        RegisterFormGUI.this.dispose();

                      // Take user back to the login gui
                        LoginFormGUI loginFormGUI = new LoginFormGUI();
                        loginFormGUI.setVisible(true);

                       // Create a result dialog
                        JOptionPane.showMessageDialog(loginFormGUI, "Registered Account Successfully");
                    } else {
                        // Register failed (likely due to the user is already in the database)
                        JOptionPane.showMessageDialog(RegisterFormGUI.this, "Error: Username already taken");

                        // Launch Register gui
                        new LoginFormGUI().setVisible(true);
                    }
                } else  {
                    // Invalid user Input
                    JOptionPane.showMessageDialog(RegisterFormGUI.this, "Error: Username must be at least 6 characters \n" +
                            "and/or Passwords must match ");


                }
            }
        });
        add(registernButton);

        // Create login label
        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.setForeground(CommonConstans.TEXT_COLOR);

        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Dispose of this GUI
                RegisterFormGUI.this.dispose();

                // Launch Register gui
                new LoginFormGUI().setVisible(true);
            }
        });
        loginLabel.setBounds(125,600,250,30);
        add(loginLabel);


    }
    private boolean validateUserInput(String username, String password, String rePassword) {
        // All fields must have a value
        if(username.length() == 0 || password.length() == 0 || rePassword.length() == 0) return false;

        //  Username has to be at least 6 characters long
        if (username.length() < 6) return false;

        // Password and repassword must be the same
        if(!password.equals(rePassword)) return false;

        // Passes the validation
        return true;
    }
}
