package businessModel;

import java.io.Serializable;

public class OrderedItem implements Serializable {

    final private MenuItem item;
    final private int quantity;
    public int x;

    public OrderedItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() { return item; }
    public int getQuantity() { return quantity; }
}
