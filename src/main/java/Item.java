
public class Item {

    private boolean isOnSale;
    private int quantity;
    private String itemName;
    private int itemPrice;

    public Item(String itemName, int itemPrice, int quantity, boolean isOnSale) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.isOnSale = isOnSale;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public boolean getIsOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void removeQuantity() {
        this.quantity--;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "isOnSale=" + isOnSale +
                ", quantity=" + quantity +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
