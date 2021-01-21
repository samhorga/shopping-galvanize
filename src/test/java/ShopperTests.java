import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ShopperTests {

    Shopper shopper = new Shopper();

    Item item1 = new Item("Item 1", 24, 1, false);
    Item item2 = new Item("Item 2", 30, 2, true);
    Item item3 = new Item("Item 3", 35, 4, false);

    List<Item> allItems = Arrays.asList(item1, item2, item3);

    int total = 0;

    @Test
    public void isEmpty() {
        assertTrue(shopper.isEmpty());
    }

    @Test
    public void addItem() {

        shopper.add(item1);

        assertEquals(shopper.getTotal(), item1.getItemPrice());

        shopper.add(item2);
        shopper.add(item3);

        allItems.forEach(item -> total += item.getItemPrice());
        assertEquals(shopper.getTotal(), total);
    }

    @Test
    public void quantityList() {
        shopper.add(item1);
        shopper.add(item1);
        assertEquals(2, shopper.itemsList.get(0).getQuantity());
        shopper.add(item1);
        assertEquals(3, shopper.itemsList.get(0).getQuantity());
    }

    @Test
    public void listItems() {
        shopper.add(item1);
        shopper.add(item2);

       List<Item> itemList =  shopper.displayItems();
       List<Item> actual = new ArrayList<>();
       actual.add(item1);
       actual.add(item2);

       assertEquals(itemList.get(0), actual.get(0));
    }

    @Test
    public void isOnSale() {
        shopper.add(item1);
        shopper.add(item2);
        shopper.add(item3);

        List<Item> itemList =  shopper.displayItems();

        List<Item> itemsOnSale = itemList.stream().filter(Item::getIsOnSale).collect(Collectors.toList());

        assertTrue(itemsOnSale.get(0).getIsOnSale());
    }

    @Test
    public void removeItem() {
        shopper.add(item1);
        shopper.add(item2);
        shopper.add(item3);

        shopper.remove(item2);

        assertEquals(2, shopper.itemsList.size());
    }

    @Test
    public void removeQuantity() {
        shopper.add(item2);
        item2.removeQuantity();
        assertEquals(1, item2.getQuantity());
    }
}
