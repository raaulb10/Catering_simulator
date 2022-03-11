package PresentationLayer;

import businessLogic.DeliveryService;
import businessModel.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Login{

    private static JLabel userlabel;
    private static JTextField userText;



    private static JLabel passlabel;
    private static JPasswordField passText;
    private static JButton login;
    private static JLabel succes;

    private static JButton back;


    public static  Account cont;


    public Login(){
        JFrame frame=new JFrame();
        JPanel panel =new JPanel();


        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);




        userlabel=new JLabel("User");
        userlabel.setBounds(10,20,80,25);
        panel.add(userlabel);

        userText=new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);


        passlabel=new JLabel("Password");
        passlabel.setBounds(10,50,80,25);
        panel.add(passlabel);

        passText=new JPasswordField(20);
        passText.setBounds(100,50,165,25);
        panel.add(passText);

        login=new JButton("Login");
        login.setBounds(10,80,80,25);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user=userText.getText();
                String password=passText.getText();
                //System.out.println(user+ ", "+password);
                if(user.equals("Raul")&&password.equals("ceva")) {
                    succes.setText("Login succesful");
                    Administrator adm = new Administrator();
                    frame.dispose();

                }

                for (Account current : DeliveryService.getInstance().getAccounts()) {
                    if(user.compareTo(current.getUsername())==0&&password.compareTo(current.getPassword())==0){
                        cont=current;
                        User log=new User();
                        frame.dispose();
                    }
                }

                succes.setText("Login failed");

            }
        });
        panel.add(login);

        back=new JButton("Register");
        back.setBounds(130,80,130,25);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register log=new Register();
                frame.dispose();
            }
        });
        panel.add(back);

//        back=new JButton("Admin");
//        back.setBounds(200,200,130,25);
//        back.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Administrator log=new Administrator();
//                frame.dispose();
//            }
//        });
//        panel.add(back);

        succes=new JLabel("");
        succes.setBounds(10,110,300,25);
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
