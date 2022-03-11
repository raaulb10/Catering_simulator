package PresentationLayer;

import businessLogic.DeliveryService;
import businessModel.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Register {
    private static JLabel userlabel;
    private static JTextField userText;
    private static JLabel passlabel;
    private static JLabel passlabel2;
    private static JPasswordField passText;
    private static JPasswordField passText2;
    private static JButton register;
    private static JLabel succes;
    private static JLabel numberlabel;
    private static JTextField numbertext;
    private static JButton back;

    public Register() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();


        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);


        userlabel = new JLabel("Username");
        userlabel.setBounds(10, 20, 80, 25);
        panel.add(userlabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);


        passlabel = new JLabel("Password");
        passlabel.setBounds(10, 50, 80, 25);
        panel.add(passlabel);

        passText = new JPasswordField(20);
        passText.setBounds(100, 50, 165, 25);
        panel.add(passText);

        passlabel2 = new JLabel("Confirm_pass");
        passlabel2.setBounds(10, 80, 110, 25);
        panel.add(passlabel2);

        passText2 = new JPasswordField(20);
        passText2.setBounds(100, 80, 165, 25);
        panel.add(passText2);

        numberlabel = new JLabel("Telephone");
        numberlabel.setBounds(10, 110, 80, 25);
        panel.add(numberlabel);

        numbertext = new JTextField(20);
        numbertext.setBounds(100, 110, 165, 25);
        panel.add(numbertext);

        register = new JButton("Register");
        register.setBounds(10, 140, 110, 25);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //succes.setText("Registration succesful");
                if (userText.getText().equals("")) {
                    succes.setBackground(Color.red);
                    succes.setText("Empty username!");

                } else if (passText.getText().equals(passText2.getText())) {
                    DeliveryService.getInstance().getAccounts().add(new Account(userText.getText(), passText.getText(), numbertext.getText(), false));
                    succes.setText("Account created");
                    //DeliveryService.getInstance().writeState();
                } else
                    succes.setText("Passwords don't match!");

                //Login log=new Login();
                //frame.dispose();

            }
        });
        panel.add(register);

        back = new JButton("Back");
        back.setBounds(130, 140, 130, 25);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login log = new Login();
                frame.dispose();
            }
        });
        panel.add(back);


        succes = new JLabel("");
        succes.setBounds(10, 170, 300, 25);
        panel.add(succes);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }
            @Override
            public void windowClosing(WindowEvent e) {
                DeliveryService.getInstance().writeState();
            }
            @Override
            public void windowClosed(WindowEvent e) {
            }
            @Override
            public void windowIconified(WindowEvent e) {
            }
            @Override
            public void windowDeiconified(WindowEvent e) {
            }
            @Override
            public void windowActivated(WindowEvent e) {
            }
            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });

        frame.add(panel);
        frame.setVisible(true);

    }
}
