package PresentationLayer;

import businessLogic.DeliveryService;
import businessModel.MenuItem;
import businessModel.OrderedItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User {

    private static JButton back;
    private static JButton order;
    private static JLabel searchlabel;
    private static JTextField searchfield;
    private static JButton apply;
    private static JButton ADD;
    private static JTable Table;


    private static JLabel ratingminlabel;
    private static JTextField ratingminText;
    private static JLabel ratingmaxlabel;
    private static JTextField ratingmaxText;

    private static JLabel caloriesminlabel;
    private static JTextField caloriesminText;
    private static JLabel caloriesmaxlabel;
    private static JTextField caloriesmaxText;

    private static JLabel proteinminlabel;
    private static JTextField proteinminText;
    private static JLabel proteinmaxlabel;
    private static JTextField proteinmaxText;

    private static JLabel fatminlabel;
    private static JTextField fatminText;
    private static JLabel fatmaxlabel;
    private static JTextField fatmaxText;

    private static JLabel sodiumminlabel;
    private static JTextField sodiumminText;
    private static JLabel sodiummaxlabel;
    private static JTextField sodiummaxText;

    private static JLabel priceminlabel;
    private static JTextField priceminText;
    private static JLabel pricemaxlabel;
    private static JTextField pricemaxText;

    DefaultTableModel tableModel;

    public User() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);

        back = new JButton("Back");
        back.setBounds(10, 20, 80, 25);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login log = new Login();
                frame.dispose();
            }
        });
        panel.add(back);


        searchlabel = new JLabel("Search");
        searchlabel.setBounds(10, 50, 80, 25);
        panel.add(searchlabel);

        searchfield = new JTextField(20);
        searchfield.setBounds(100, 50, 550, 25);
        searchfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                JTextField sursa = (JTextField) e.getSource();

                Object[] columnNames = {"Nume", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};


                tableModel = new DefaultTableModel(columnNames, 0);
                DeliveryService.getInstance().getItems().stream().filter(produs -> produs.getName().toLowerCase().contains(sursa.getText().toLowerCase())).forEach(b -> {

                    if (ratingminText.getText().compareTo("") == 0 && ratingmaxText.getText().compareTo("") == 0) {
                        Object[] values = {b.getName(), b.getRating(), b.getCalories(), b.getProtein(), b.getFat(), b.getSodium(), b.getPrice()};
                        tableModel.addRow(values);
                    } else {
                        if (Double.parseDouble(ratingminText.getText()) <= b.getRating() && Double.parseDouble(ratingmaxText.getText()) >= b.getRating()) {

                            if (caloriesminText.getText().compareTo("") == 0 && caloriesmaxText.getText().compareTo("") == 0) {

                                Object[] values = {b.getName(), b.getRating(), b.getCalories(), b.getProtein(), b.getFat(), b.getSodium(), b.getPrice()};
                                tableModel.addRow(values);

                            } else if (Integer.parseInt(caloriesminText.getText()) <= b.getCalories() && Integer.parseInt(caloriesmaxText.getText()) >= b.getCalories()) {
                                if (proteinminText.getText().compareTo("") == 0 && proteinmaxText.getText().compareTo("") == 0) {

                                    Object[] values = {b.getName(), b.getRating(), b.getCalories(), b.getProtein(), b.getFat(), b.getSodium(), b.getPrice()};
                                    tableModel.addRow(values);

                                } else if (Integer.parseInt(proteinminText.getText()) <= b.getProtein() && Integer.parseInt(proteinmaxText.getText()) >= b.getProtein()) {
                                    if (fatminText.getText().compareTo("") == 0 && fatmaxText.getText().compareTo("") == 0) {
                                        Object[] values = {b.getName(), b.getRating(), b.getCalories(), b.getProtein(), b.getFat(), b.getSodium(), b.getPrice()};
                                        tableModel.addRow(values);
                                    } else if (Integer.parseInt(fatminText.getText()) <= b.getFat() && Integer.parseInt(fatmaxText.getText()) >= b.getFat()) {
                                        if (sodiumminText.getText().compareTo("") == 0 && sodiummaxText.getText().compareTo("") == 0) {
                                            Object[] values = {b.getName(), b.getRating(), b.getCalories(), b.getProtein(), b.getFat(), b.getSodium(), b.getPrice()};
                                            tableModel.addRow(values);
                                        } else if (Integer.parseInt(sodiumminText.getText()) <= b.getSodium() && Integer.parseInt(sodiummaxText.getText()) >= b.getSodium()) {

                                            if (priceminText.getText().compareTo("") == 0 && pricemaxText.getText().compareTo("") == 0) {
                                                Object[] values = {b.getName(), b.getRating(), b.getCalories(), b.getProtein(), b.getFat(), b.getSodium(), b.getPrice()};
                                                tableModel.addRow(values);
                                            } else if (Integer.parseInt(priceminText.getText()) <= b.getPrice() && Integer.parseInt(pricemaxText.getText()) >= b.getPrice()) {
                                                Object[] values = {b.getName(), b.getRating(), b.getCalories(), b.getProtein(), b.getFat(), b.getSodium(), b.getPrice()};
                                                tableModel.addRow(values);
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }

                });
                Table.setModel(tableModel);
                Table.getColumnModel().getColumn(0).setPreferredWidth(600);
            }
        });
        panel.add(searchfield);

        ArrayList<OrderedItem> items = new ArrayList<>();
        apply = new JButton("Add");
        apply.setBounds(660, 50, 80, 25);
        apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliveryService.getInstance().getItems().stream().filter(p -> p.getName().compareTo((String) Table.getModel().getValueAt(0, 0)) == 0).limit(1).forEach(p -> items.add(new OrderedItem(p, 1)));
            }
        });
        panel.add(apply);

        order = new JButton("Order");
        order.setBounds(660, 20, 80, 25);
        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliveryService.getInstance().createNewOrder(Login.cont, items);
                //System.out.println(items);
                int total=0;
                try {
                    FileWriter bill=new FileWriter("bill.txt");
                    for (OrderedItem current : items) {
                        bill.write(current.getItem().getName());
                        bill.write("  Calories: ");
                        bill.write(String.valueOf(current.getItem().getCalories()));
                        bill.write("  Protein: ");
                        bill.write(String.valueOf(current.getItem().getProtein()));
                        bill.write("  Fat: ");
                        bill.write(String.valueOf(current.getItem().getFat()));
                        bill.write("  Sodium: ");
                        bill.write(String.valueOf(current.getItem().getSodium()));
                        bill.write("  Price: ");
                        bill.write(String.valueOf(current.getItem().getPrice()));
                        total+=current.getItem().getPrice();
                        bill.write("\r\n");

                    }
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    bill.write(dateFormat.format(date));
                    bill.write("               Total Price: ");
                    bill.write(String.valueOf(total));

                    bill.close();
                } catch (IOException ioException) {
                    System.out.println("An error occurred.");
                    ioException.printStackTrace();
                }

                items.removeAll(items);
                //System.out.println(items);
            }
        });
        panel.add(order);

        ratingminlabel = new JLabel("Rating min:");
        ratingminlabel.setBounds(10, 80, 80, 25);

        panel.add(ratingminlabel);

        ratingminText = new JTextField(20);
        ratingminText.setBounds(100, 80, 165, 25);
        panel.add(ratingminText);

        ratingmaxlabel = new JLabel("Rating max:");
        ratingmaxlabel.setBounds(395, 80, 80, 25);
        panel.add(ratingmaxlabel);

        ratingmaxText = new JTextField(20);
        ratingmaxText.setBounds(485, 80, 165, 25);
        panel.add(ratingmaxText);

        caloriesmaxlabel = new JLabel("Calories max:");
        caloriesmaxlabel.setBounds(395, 110, 80, 25);
        panel.add(caloriesmaxlabel);

        caloriesmaxText = new JTextField(20);
        caloriesmaxText.setBounds(485, 110, 165, 25);
        panel.add(caloriesmaxText);

        caloriesminlabel = new JLabel("Calories min:");
        caloriesminlabel.setBounds(10, 110, 80, 25);
        panel.add(caloriesminlabel);

        caloriesminText = new JTextField(20);
        caloriesminText.setBounds(100, 110, 165, 25);
        panel.add(caloriesminText);

        proteinmaxlabel = new JLabel("Protein max:");
        proteinmaxlabel.setBounds(395, 140, 80, 25);
        panel.add(proteinmaxlabel);

        proteinmaxText = new JTextField(20);
        proteinmaxText.setBounds(485, 140, 165, 25);
        panel.add(proteinmaxText);

        proteinminlabel = new JLabel("Protein min:");
        proteinminlabel.setBounds(10, 140, 80, 25);
        panel.add(proteinminlabel);

        proteinminText = new JTextField(20);
        proteinminText.setBounds(100, 140, 165, 25);
        panel.add(proteinminText);

        fatmaxlabel = new JLabel("Fat max:");
        fatmaxlabel.setBounds(395, 170, 80, 25);
        panel.add(fatmaxlabel);

        fatmaxText = new JTextField(20);
        fatmaxText.setBounds(485, 170, 165, 25);
        panel.add(fatmaxText);

        fatminlabel = new JLabel("Fat min:");
        fatminlabel.setBounds(10, 170, 80, 25);
        panel.add(fatminlabel);

        fatminText = new JTextField(20);
        fatminText.setBounds(100, 170, 165, 25);
        panel.add(fatminText);

        sodiummaxlabel = new JLabel("Sodium max:");
        sodiummaxlabel.setBounds(395, 200, 80, 25);
        panel.add(sodiummaxlabel);

        sodiummaxText = new JTextField(20);
        sodiummaxText.setBounds(485, 200, 165, 25);
        panel.add(sodiummaxText);

        sodiumminlabel = new JLabel("Sodium min:");
        sodiumminlabel.setBounds(10, 200, 80, 25);
        panel.add(sodiumminlabel);

        sodiumminText = new JTextField(20);
        sodiumminText.setBounds(100, 200, 165, 25);
        panel.add(sodiumminText);

        pricemaxlabel = new JLabel("Price max:");
        pricemaxlabel.setBounds(395, 230, 80, 25);
        panel.add(pricemaxlabel);

        pricemaxText = new JTextField(20);
        pricemaxText.setBounds(485, 230, 165, 25);
        panel.add(pricemaxText);

        priceminlabel = new JLabel("Price min:");
        priceminlabel.setBounds(10, 230, 80, 25);
        panel.add(priceminlabel);

        priceminText = new JTextField(20);
        priceminText.setBounds(100, 230, 165, 25);
        panel.add(priceminText);

        Table = new JTable();

        Table.setBounds(0, 60, 1000, 400);
        list();


        JScrollPane sp = new JScrollPane(Table);
        JPanel newPanel = new JPanel();
        newPanel.setBounds(0, 260, 810, 350);
        sp.setBounds(0, 20, 800, 400);
        newPanel.add(sp);
        panel.add(newPanel);

//        ADD = new JButton("ADD");
//        ADD.setBounds(30, 600, 700, 30);
//        ADD.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        panel.add(ADD);

        frame.add(panel);
        frame.setVisible(true);

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

    }

    public static void list() {
        Object[] columnNames = {"Nume", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (MenuItem b : DeliveryService.getInstance().getItems()) {

            Object[] values = {b.getName(), b.getRating(), b.getCalories(), b.getProtein(), b.getFat(), b.getSodium(), b.getPrice()};
            tableModel.addRow(values);

        }

        Table.setModel(tableModel);
        Table.getColumnModel().getColumn(0).setPreferredWidth(600);
    }
}
