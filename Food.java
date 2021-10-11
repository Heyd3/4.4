package Market;

public class Food extends Merchandise {
    final int SHELFLIFE;

    public Food(String name, int price, int amount, int shelfLife) {
        super(name, price, amount);
        this.SHELFLIFE = shelfLife;
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

    public int getShelfLife() {
        return SHELFLIFE;
    }




    @Override
    public boolean availabilitySale(int amount) {
        Logger logger = Logger.getInstance();
        if (SHELFLIFE < logger.num) {
            return false;
        } else if (amount > this.amount)
            return false;
        else
            return true;
    }
}
