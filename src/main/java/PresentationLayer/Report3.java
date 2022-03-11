package PresentationLayer;

import businessLogic.DeliveryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

public class Report3 {

    private static JButton back;
    private static JButton generate;

    private static JLabel nr;
    private static JTextField nrt;

    private static JLabel price;
    private static JTextField pricet;

    public Report3(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(700, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);

        nr = new JLabel("Comanded more than: ");
        nr.setBounds(10, 20, 200, 25);
        panel.add(nr);
        nrt = new JTextField(20);
        nrt.setBounds(200, 20, 80, 25);
        panel.add(nrt);

        price = new JLabel("Price bigger than: ");
        price.setBounds(10, 50, 200, 25);
        panel.add(price);
        pricet = new JTextField(20);
        pricet.setBounds(200, 50, 80, 25);
        panel.add(pricet);

        generate = new JButton("Generate");
        generate.setBounds(255, 180, 150, 25);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num=Integer.parseInt(nrt.getText());
                int amount=Integer.parseInt(pricet.getText());
                System.out.println(DeliveryService.getInstance().report3f(num,amount));
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
