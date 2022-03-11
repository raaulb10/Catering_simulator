package PresentationLayer;

import businessLogic.DeliveryService;
import businessModel.MenuItem;
import businessModel.CompositeProduct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class Administrator {

    private static JButton importbutton;
    private static JButton back;
    private static JButton add;
    private static JButton edit;
    private static JButton delete;
    private static JButton Reports;
    private static JButton Reports2;
    private static JButton Reports3;
    private static JButton Reports4;
    private static JLabel searchlabel;
    private static JTextField searchfield;
    private static JButton apply;
    private static JButton create;
    private static JLabel Name;
    private static JTextField Namet;

    private static JLabel newname;
    private static JTextField newnamet;
    private static JLabel newrating;
    private static JTextField newratingt;
    private static JLabel newprotein;
    private static JTextField newproteint;
    private static JLabel newcalories;
    private static JTextField newcaloriest;
    private static JLabel newfat;
    private static JTextField newfatt;
    private static JLabel newsodium;
    private static JTextField newsodiumt;
    private static JLabel newprice;
    private static JTextField newpricet;


    public static JTable Table;
    String header[] = new String[]{"Nume", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};

    DefaultTableModel tableModel;

    public Administrator() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        panel.setLayout(null);


        newname = new JLabel("New name:");
        newname.setBounds(10, 470, 80, 25);
        panel.add(newname);
        newnamet = new JTextField(20);
        newnamet.setBounds(100, 470, 165, 25);
        panel.add(newnamet);

        newrating = new JLabel("New rating:");
        newrating.setBounds(10, 500, 80, 25);
        panel.add(newrating);
        newratingt = new JTextField(20);
        newratingt.setBounds(100, 500, 165, 25);
        panel.add(newratingt);

        newcalories = new JLabel("New calories:");
        newcalories.setBounds(10, 530, 80, 25);
        panel.add(newcalories);
        newcaloriest = new JTextField(20);
        newcaloriest.setBounds(100, 530, 165, 25);
        panel.add(newcaloriest);

        newprotein = new JLabel("New protein:");
        newprotein.setBounds(300, 470, 80, 25);
        panel.add(newprotein);
        newproteint = new JTextField(20);
        newproteint.setBounds(400, 470, 165, 25);
        panel.add(newproteint);

        newfat = new JLabel("New fat:");
        newfat.setBounds(300, 500, 80, 25);
        panel.add(newfat);
        newfatt = new JTextField(20);
        newfatt.setBounds(400, 500, 165, 25);
        panel.add(newfatt);

        newsodium = new JLabel("New sodium:");
        newsodium.setBounds(300, 530, 80, 25);
        panel.add(newsodium);
        newsodiumt = new JTextField(20);
        newsodiumt.setBounds(400, 530, 165, 25);
        panel.add(newsodiumt);

        newprice = new JLabel("New price:");
        newprice.setBounds(600, 485, 80, 25);
        panel.add(newprice);
        newpricet = new JTextField(20);
        newpricet.setBounds(700, 485, 165, 25);
        panel.add(newpricet);


        searchlabel = new JLabel("Search");
        searchlabel.setBounds(10, 20, 80, 25);
        panel.add(searchlabel);

        searchfield = new JTextField(20);
        searchfield.setBounds(100, 20, 550, 25);
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
                    Object[] values = {b.getName(), b.getRating(), b.getCalories(), b.getProtein(), b.getFat(), b.getSodium(), b.getPrice()};
                    tableModel.addRow(values);
                });
                Table.setModel(tableModel);
                Table.getColumnModel().getColumn(0).setPreferredWidth(600);
            }
        });
        panel.add(searchfield);
        importbutton = new JButton("Import products");
        importbutton.setBounds(250, 600, 150, 25);
        importbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliveryService.getInstance().Importfunction("C:\\Raul\\An 2\\Sem2\\TP\\products.csv");
                list();
            }
        });
        panel.add(importbutton);

        back = new JButton("Back");
        back.setBounds(650, 20, 80, 25);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login log = new Login();
                frame.dispose();
            }
        });
        panel.add(back);


        add = new JButton("Add");
        add.setBounds(450, 600, 80, 25);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ObjectInput obj = new ObjectInput();

            }
        });
        panel.add(add);

        edit = new JButton("Edit");
        edit.setBounds(700, 515, 80, 25);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliveryService.getInstance().getItems().stream().filter(p -> p.getName().compareTo((String) Table.getModel().getValueAt(0, 0)) == 0).limit(1).forEach(p -> {
                    if (newnamet.getText().compareTo("") != 0)
                        p.setName(newnamet.getText());
                    if (newcaloriest.getText().compareTo("") != 0)
                        p.setCalories(Integer.parseInt(newcaloriest.getText()));
                    if (newproteint.getText().compareTo("") != 0)
                        p.setProtein(Integer.parseInt(newproteint.getText()));
                    if (newfatt.getText().compareTo("") != 0)
                        p.setFat(Integer.parseInt(newfatt.getText()));
                    if (newratingt.getText().compareTo("") != 0)
                        p.setRating(Double.parseDouble(newratingt.getText()));
                    if (newsodiumt.getText().compareTo("") != 0)
                        p.setSodium(Integer.parseInt(newsodiumt.getText()));
                    if (newpricet.getText().compareTo("") != 0)
                        p.setPrice(Integer.parseInt(newpricet.getText()));

                    list();
                });

            }
        });
        panel.add(edit);


        delete = new JButton("Delete");
        delete.setBounds(650, 600, 80, 25);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliveryService.getInstance().getItems().stream().filter(p -> p.getName().compareTo((String) Table.getModel().getValueAt(0, 0)) == 0).limit(1).forEach(p -> {
                    DeliveryService.getInstance().getItems().remove(p);

                    list();
                });

            }
        });
        panel.add(delete);

        Reports = new JButton("Report1");
        Reports.setBounds(10, 600, 80, 25);
        Reports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Report1 rep = new Report1();
                frame.dispose();
            }
        });
        panel.add(Reports);

        Reports2 = new JButton("Report2");
        Reports2.setBounds(100, 600, 80, 25);
        Reports2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Report2 rep = new Report2();
                frame.dispose();
            }
        });
        panel.add(Reports2);

        Reports3 = new JButton("Report3");
        Reports3.setBounds(10, 630, 80, 25);
        Reports3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Report3 rep = new Report3();
                frame.dispose();
            }
        });
        panel.add(Reports3);

        Reports4 = new JButton("Report4");
        Reports4.setBounds(100, 630, 80, 25);
        Reports4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Report4 rep = new Report4();
                frame.dispose();
            }
        });
        panel.add(Reports4);

        //DeliveryService.getInstance().getItems()


        String[] columnNames = {"Nume", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        Table = new JTable();

        Table.setBounds(40, 60, 600, 400);
        //Table.setModel(new DefaultTableModel(new Object[15000][8],columnNames));
        list();
//        frame.add(Table);

        JScrollPane sp = new JScrollPane(Table);
        JPanel newPanel = new JPanel();
        newPanel.setBounds(40, 60, 700, 400);
        sp.setBounds(0, 0, 700, 400);
        newPanel.add(sp);
        panel.add(newPanel);


        ArrayList<MenuItem> items = new ArrayList<>();
        apply = new JButton("Add");
        apply.setBounds(750, 60, 100, 25);
        apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliveryService.getInstance().getItems().stream().filter(p -> p.getName().compareTo((String) Table.getModel().getValueAt(0, 0)) == 0).limit(1).forEach(p -> items.add(p));
            }
        });
        panel.add(apply);

        Name = new JLabel("Name");
        Name.setBounds(750, 90, 100, 25);
        panel.add(Name);
        Namet = new JTextField();
        Namet.setBounds(750, 120, 100, 25);
        panel.add(Namet);

        create = new JButton("Create");
        create.setBounds(750, 150, 100, 25);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliveryService.getInstance().getItems().add(new CompositeProduct(Namet.getText(),items));
                //System.out.println(new CompositeProduct(Namet.getText(),items));

                items.removeAll(items);
            }
        });
        panel.add(create);


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
