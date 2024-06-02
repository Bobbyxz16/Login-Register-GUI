import db.MyJDBC;
import guis.LoginFormGUI;
import guis.RegisterFormGUI;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                // Instantiate a LoginFormGUI
                new LoginFormGUI().setVisible(true);
//                System.out.println(MyJDBC.validateLogin("bobbyxz15", "futbol"));
            }
        }));
        }

}