package PresentationLayer;

import businessLogic.DeliveryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

public class Report2 {

    private static JButton back;
    private static JLabel year;
    private static JTextField yeart;
    private static JLabel month;
    private static JTextField montht;
    private static JLabel day;
    private static JTextField dayt;
    private static JLabel hour;
    private static JTextField hourt;
    private static JLabel min;
    private static JTextField mint;

    private static JButton generate;

    private static JLabel nr;
    private static JTextField nrt;

    private static Date d1;
    public Report2() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(700, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);




        nr = new JLabel("Used more than:");
        nr.setBounds(300, 85, 150, 25);
        panel.add(nr);
        nrt = new JTextField(20);
        nrt.setBounds(450, 85, 80, 25);
        panel.add(nrt);


        generate = new JButton("Generate");
        generate.setBounds(255, 180, 150, 25);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //d1=new Date(Integer.parseInt(yeart.getText()),Integer.parseInt(montht.getText()),Integer.parseInt(dayt.getText()),Integer.parseInt(hourt.getText()),Integer.parseInt(mint.getText()));
                int num=Integer.parseInt(nrt.getText());
                //System.out.println(DeliveryService.getInstance().report2f(num,-1));
                //System.out.println(d1);
                //System.out.println(DeliveryService.getInstance().report1f(d1,d2));
            }
        });
        panel.add(generate);

        back = new JButton("Back");
        back.setBounds(600, 20, 80, 25);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrator log = new Administrator();
                frame.dispose();
            }
        });
        panel.add(back);

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
