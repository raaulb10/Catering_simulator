package businessLogic;


import businessModel.*;
import dataAccessClass.Serializator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeliveryService implements IDeliveryServiceProcessing {

    private static final DeliveryService instance = new DeliveryService();

    private static final String Items_name = "_ITEMS.ser";
    private static final String Account_name = "_ACCOUNTS.ser";
    private static final String Orders_name = "_ORDERS.ser";
    private static final String Ordersinf_name = "_ORDERSInfo.ser";

    private ArrayList<MenuItem> items;
    private ArrayList<Account> accounts;
    private ArrayList<Order> orders;
    private OrderMap ordersInfo;

    public DeliveryService() {
        items = new Serializator<ArrayList<MenuItem>>().readFile(Items_name);
        ordersInfo = new Serializator<OrderMap>().readFile(Ordersinf_name);
        accounts = new Serializator<ArrayList<Account>>().readFile(Account_name);
        orders = new Serializator<ArrayList<Order>>().readFile(Orders_name);
        if (orders == null) orders = new ArrayList<>();
        if (items == null) items = new ArrayList<>();
        if (ordersInfo == null) ordersInfo = new OrderMap();
        if (accounts == null) accounts = new ArrayList<>();
    }

    public static DeliveryService getInstance() {
        return instance;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public OrderMap getordersInfo() {
        return ordersInfo;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }


    public void writeState() {
        new Serializator<ArrayList<Order>>().writeFile(orders, Orders_name);
        new Serializator<ArrayList<MenuItem>>().writeFile(items, Items_name);
        new Serializator<OrderMap>().writeFile(ordersInfo, Ordersinf_name);
        new Serializator<ArrayList<Account>>().writeFile(accounts, Account_name);
    }

    @Override
    public void Importfunction(String path) {


        File file = new File(path);
        List<BaseProduct> productList = new ArrayList<>();
        try (Stream<String> linesStream = Files.lines(file.toPath())) {
            AtomicInteger aux = new AtomicInteger();
            linesStream.forEach(line -> {
                if (aux.get() == 0) {
                    aux.set(1);
                } else {
                    String[] read = line.split(",");
                    //System.out.println(read);
                    BaseProduct baseProduct = new BaseProduct(read[0], Double.parseDouble(read[1]), Integer.parseInt(read[2]), Integer.parseInt(read[3]), Integer.parseInt(read[4]), Integer.parseInt(read[5]), Integer.parseInt(read[6]));
                    productList.add(baseProduct);
                }
            });
            List<MenuItem> temp = productList.stream().filter(distinctByKey(BaseProduct::getName)).collect(Collectors.toList());
            items.addAll(temp);
            items = items.stream().filter(distinctByKey(MenuItem::toString)).collect(Collectors.toCollection(ArrayList::new));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    @Override
    public void insertMenuItem(MenuItem menuItem) {
        items.add(menuItem);
        items = items.stream().filter(distinctByKey(MenuItem::toString)).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Order> report1f(Date dateIn, Date dateOut) {
        return orders.stream()
                .filter(ord -> {
                    return (ord.getDate().compareTo(dateIn) >= 0) && (ord.getDate().compareTo(dateOut) <= 0);
                }).collect(Collectors.toList());
    }

    @Override
    public List<MenuItem> report2f(Date date, int moreOrders) {

        List<List<OrderedItem>> ords = orders.stream()
                .filter(ord -> (ord.getDate().compareTo(date) == 0)).map(order -> ordersInfo.get(order)).collect(Collectors.toList());
        List<OrderedItem> pb = new ArrayList<>();
        for (List<OrderedItem> l : ords) {
            for (OrderedItem i : l) {
                int index = pb.indexOf(i);
                if (index != -1) {
                    pb.add(i);
                    i.x = i.getQuantity();
                } else {
                    pb.get(index).x += i.getQuantity();
                }
            }
        }
        return pb.stream()
                .filter(orderedItem -> orderedItem.x >= moreOrders).map(orderedItem -> orderedItem.getItem()).collect(Collectors.toList());
    }
    @Override
    public List<Account> report3f(int moreOrders, int muchvalue) {
        return accounts.stream()
                .filter(client -> {
                    if (client.isEmployee())
                        return false;
                    List<Order> clientOrders = orders.stream()
                            .filter(order -> order.getClient().equals(client)).collect(Collectors.toList());
                    int nrOFOrders = 0;
                    int totalValue = 0;
                    for (Order order : clientOrders) {
                        ArrayList<OrderedItem> orderedItemList = ordersInfo.get(order);
                        nrOFOrders++;
                        for (OrderedItem orderedItem : orderedItemList) {
                            totalValue += orderedItem.getQuantity() * orderedItem.getItem().getPrice();
                        }
                    }
                    return nrOFOrders >= moreOrders && totalValue >= muchvalue;
                }).collect(Collectors.toList());
    }

    @Override
    public void createNewOrder(Account client, List<OrderedItem> list) {
        int newprice = 0;
        for (OrderedItem item : list) {
            newprice += item.getItem().getPrice();
        }
        Order order = new Order(client, new Date(), newprice, 2);
        //System.out.println(order.toString());
        orders.add(order);
        ordersInfo.put(order, (ArrayList<OrderedItem>) list);
    }


}
