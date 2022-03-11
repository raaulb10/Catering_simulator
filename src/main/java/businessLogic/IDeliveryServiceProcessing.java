package businessLogic;

import businessModel.*;

import java.util.Date;
import java.util.List;

public interface IDeliveryServiceProcessing {

    void Importfunction(String path);
    void insertMenuItem(MenuItem menuItem);

    List<Order> report1f(Date dateIn , Date dateOut);
    List<MenuItem> report2f(Date date , int moreOrders);

    List<Account> report3f(int moreOrders, int muchvalue);

    void createNewOrder(Account client, List<OrderedItem> list);


}
