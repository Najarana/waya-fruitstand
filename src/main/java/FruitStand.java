import java.util.HashSet;
import java.util.Set;

public class FruitStand {

    int standNumber;
    String name;
    Set<FruitBasket> availableFruitsBaskets = new HashSet<>();

    public FruitStand(int standNumber, String name) {
        this.standNumber = standNumber;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStandNumber() {
        return standNumber;
    }

    public Set<FruitBasket> getAvailableFruitsBaskets() {
        return availableFruitsBaskets;
    }

    public void setAvailableFruitsBaskets(Set<FruitBasket> availableFruitsBaskets) {
        this.availableFruitsBaskets = availableFruitsBaskets;
    }

    public void addFruitBaskets(Set<FruitBasket> fruitBasket) {
        this.availableFruitsBaskets.addAll(fruitBasket);
    }

    public int basketsTotalCost() {
        return this.availableFruitsBaskets.stream().map(FruitBasket::getPrice).reduce(0, Integer::sum);
    }

    public FruitBasket getBasketOf(FruitBasket.Fruit fruit) {
        return this.availableFruitsBaskets.stream().filter(fruitBasket -> fruitBasket.getFruitType() == fruit).findFirst().orElseThrow();
    }

}
