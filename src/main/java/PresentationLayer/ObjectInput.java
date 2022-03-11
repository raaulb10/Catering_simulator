package PresentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import businessLogic.*;
import businessModel.BaseProduct;

public class ObjectInput {

    private static JLabel nume;
    private static JTextField numet;
    private static JLabel rating;
    private static JTextField ratingt;
    private static JLabel calories;
    private static JTextField caloriest;
    private static JLabel protein;
    private static JTextField proteint;
    private static JLabel fat;
    private static JTextField fatt;
    private static JLabel sodium;
    private static JTextField sodiumt;
    private static JLabel price;
    private static JTextField pricet;

    private static JButton add;

    public ObjectInput() {


        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        panel.setLayout(null);

        nume = new JLabel("Product:");
        nume.setBounds(10, 20, 80, 25);
        panel.add(nume);

        numet = new JTextField(20);
        numet.setBounds(100, 20, 300, 25);
        panel.add(numet);

        rating = new JLabel("Rating:");
        rating.setBounds(10, 50, 80, 25);
        panel.add(rating);

        ratingt = new JTextField(20);
        ratingt.setBounds(100, 50, 150, 25);
        panel.add(ratingt);

        calories = new JLabel("Calories:");
        calories.setBounds(10, 80, 80, 25);
        panel.add(calories);

        caloriest = new JTextField(20);
        caloriest.setBounds(100, 80, 150, 25);
        panel.add(caloriest);

        protein = new JLabel("Protein:");
        protein.setBounds(10, 110, 80, 25);
        panel.add(protein);

        proteint = new JTextField(20);
        proteint.setBounds(100, 110, 150, 25);
        panel.add(proteint);

        fat = new JLabel("Fat:");
        fat.setBounds(10, 140, 80, 25);
        panel.add(fat);

        fatt = new JTextField(20);
        fatt.setBounds(100, 140, 150, 25);
        panel.add(fatt);

        sodium = new JLabel("Sodium:");
        sodium.setBounds(10, 170, 80, 25);
        panel.add(sodium);

        sodiumt = new JTextField(20);
        sodiumt.setBounds(100, 170, 150, 25);
        panel.add(sodiumt);

        price = new JLabel("Price:");
        price.setBounds(10, 200, 80, 25);
        panel.add(price);

        pricet = new JTextField(20);
        pricet.setBounds(100, 200, 150, 25);
        panel.add(pricet);

        add = new JButton("Add");
        add.setBounds(100, 230, 150, 25);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliveryService.getInstance().insertMenuItem(new BaseProduct(numet.getText(),Double.parseDouble(ratingt.getText()),Integer.parseInt(caloriest.getText()),Integer.parseInt(proteint.getText()),Integer.parseInt(fatt.getText()),Integer.parseInt(sodiumt.getText()),Integer.parseInt(pricet.getText())));
                Administrator.list();
                frame.dispose();
            }
        });
        panel.add(add);
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
