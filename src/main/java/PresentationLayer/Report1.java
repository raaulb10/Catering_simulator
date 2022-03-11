package PresentationLayer;

import businessLogic.DeliveryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

public class Report1 {

    private static JButton back;
    private static JLabel year;
    private static JTextField yeart;
    private static JTextField yeart2;
    private static JLabel month;
    private static JTextField montht;
    private static JTextField montht2;
    private static JLabel day;
    private static JTextField dayt;
    private static JTextField dayt2;
    private static JLabel hour;
    private static JTextField hourt;
    private static JTextField hourt2;
    private static JLabel min;
    private static JTextField mint;
    private static JTextField mint2;

    private static JButton generate;

    private static JLabel too;

    private static Date d1;
    private static Date d2;
    public Report1() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(700, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);


        year = new JLabel("Year:");
        year.setBounds(10, 20, 80, 25);
        panel.add(year);
        too = new JLabel("------- >");
        too.setBounds(300, 80, 110, 25);
        panel.add(too);
        yeart = new JTextField(20);
        yeart.setBounds(100, 20, 165, 25);
        panel.add(yeart);
        yeart2 = new JTextField(20);
        yeart2.setBounds(400, 20, 165, 25);
        panel.add(yeart2);

        month = new JLabel("Month:");
        month.setBounds(10, 50, 80, 25);
        panel.add(month);
        montht = new JTextField(20);
        montht.setBounds(100, 50, 165, 25);
        panel.add(montht);
        montht2 = new JTextField(20);
        montht2.setBounds(400, 50, 165, 25);
        panel.add(montht2);

        day = new JLabel("Day:");
        day.setBounds(10, 80, 80, 25);
        panel.add(day);
        dayt = new JTextField(20);
        dayt.setBounds(100, 80, 165, 25);
        panel.add(dayt);
        dayt2 = new JTextField(20);
        dayt2.setBounds(400, 80, 165, 25);
        panel.add(dayt2);

        hour = new JLabel("Hour:");
        hour.setBounds(10, 110, 80, 25);
        panel.add(hour);
        hourt = new JTextField(20);
        hourt.setBounds(100, 110, 165, 25);
        panel.add(hourt);
        hourt2 = new JTextField(20);
        hourt2.setBounds(400, 110, 165, 25);
        panel.add(hourt2);

        min = new JLabel("Minute:");
        min.setBounds(10, 140, 80, 25);
        panel.add(min);
        mint = new JTextField(20);
        mint.setBounds(100, 140, 165, 25);
        panel.add(mint);
        mint2 = new JTextField(20);
        mint2.setBounds(400, 140, 165, 25);
        panel.add(mint2);


        generate = new JButton("Generate");
        generate.setBounds(255, 180, 150, 25);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1=new Date(Integer.parseInt(yeart.getText()),Integer.parseInt(montht.getText()),Integer.parseInt(dayt.getText()),Integer.parseInt(hourt.getText()),Integer.parseInt(mint.getText()));
                d2=new Date(Integer.parseInt(yeart2.getText()),Integer.parseInt(montht2.getText()),Integer.parseInt(dayt2.getText()),Integer.parseInt(hourt2.getText()),Integer.parseInt(mint2.getText()));

                //System.out.println(d1);
            System.out.println(DeliveryService.getInstance().report1f(d1,d2));
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
