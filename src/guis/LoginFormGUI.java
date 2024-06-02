package guis;

import constants.CommonConstans;
import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFormGUI extends Form {
    public LoginFormGUI() {
        super("Login");
        addGuiComponents();
    }

    private void addGuiComponents(){
         // Create login label
        JLabel loginLabel = new JLabel("Login");

        // Configure component's x,y positions and weight/height values relatives to the GUI
        loginLabel.setBounds(0,25,520,100);

        // Change font color
        loginLabel.setForeground(CommonConstans.TEXT_COLOR);

        // Change the font size
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        // Center text
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add component to GUI
        add(loginLabel);

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
        passwordLabel.setBounds(30,335,400,25);
        passwordLabel.setForeground(CommonConstans.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN,18));

        // Create username text field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30,365,450,55);
        passwordField.setBackground(CommonConstans.SECONDARY_COLOR);
        passwordField.setForeground(CommonConstans.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordField);
        add(passwordLabel);


        // Create login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Change the cursor to a hand when hover over the button
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBackground(CommonConstans.TEXT_COLOR);
        loginButton.setBounds(125,520, 250,50);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get username
                String username = usernameField.getText();

                // Get password
                String password = new String(passwordField.getPassword());

                // Check database if the username and password is valid
                if (MyJDBC.validateLogin(username, password)) {
                    // Login successful
                    JOptionPane.showMessageDialog(LoginFormGUI.this,
                            "Login Successfully");
                } else {
                    // Login failed
                    JOptionPane.showMessageDialog(LoginFormGUI.this,
                            "Login Failed...");
                }
            }
        });
        add(loginButton);

        // Create register label (used to load the register GUI)
        JLabel registerLabel = new JLabel("No a user? Register Here");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setForeground(CommonConstans.TEXT_COLOR);

        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // Dispose of this GUI
                LoginFormGUI.this.dispose();

                // Launch Register gui
                new RegisterFormGUI().setVisible(true);
            }
        });
        registerLabel.setBounds(125,600,250,30);
        add(registerLabel);





    }
}
