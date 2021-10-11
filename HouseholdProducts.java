package Market;

public class HouseholdProducts extends Merchandise {

    public HouseholdProducts(String name, int price, int amount) {
        super(name, price, amount);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean availabilitySale(int amount) {
        if (amount > this.amount)
            return false;
        else
            return true;
    }
}
