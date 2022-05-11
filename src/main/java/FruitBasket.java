public class FruitBasket {

    public enum  Fruit {
        CHERRY,
        PEACH,
        PEAR;
    }

    public FruitBasket(int price, Fruit fruitType) {
        this.price = price;
        this.fruitType = fruitType;
    }

    int price;
    Fruit fruitType;

    public int getPrice() {
        return price;
    }

    public Fruit getFruitType() {
        return fruitType;
    }
}
