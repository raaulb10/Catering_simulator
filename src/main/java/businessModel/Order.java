package businessModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {

    private Account client;
    private Date date;
    private int price;
    private int status;


    public Order(Account client, Date date, int price, int status) {
        this.client = client;
        this.date = date;
        this.price = price;
        this.status = status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, price, client);
    }

    public Account getClient() {
        return client;
    }

    public void setClient(Account client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "order | date - " + date + " | price - " + price + "\n";
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Order)) return false;
//        Order order=(Order) o;
//        //return status
//    }

}
