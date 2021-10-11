package Market;

public abstract class Merchandise {
    protected String name;
    protected int price;
    protected int amount;

    public Merchandise(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
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

    public boolean availabilitySale(int amount) {
        return true;
    };

//    public void output (int quantity){};
}
