import java.util.ArrayList;
import java.util.List;

public class Shopper {

    List<Item> itemsList;

    int totalPrice = 0;

    public Shopper() {
        itemsList = new ArrayList<>();
    }

    public boolean isEmpty() {
        return itemsList.isEmpty();
    }

    public void add(Item item) {
        if (itemsList.contains(item)) {
            item.setQuantity(item.getQuantity() + 1);
        } else {
            itemsList.add(item);
        }
    }

    public int getTotal() {
        this.totalPrice = 0;
        itemsList.forEach(item -> {
            totalPrice += item.getItemPrice();
        });
        return totalPrice;
    }

    public List<Item> displayItems() {
        return itemsList;
    }

    public void remove(Item item2) {
        itemsList.remove(item2);
    }
}
