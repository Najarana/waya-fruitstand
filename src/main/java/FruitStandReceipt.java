import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FruitStandReceipt {
    private final int fruitStandNumber;
    private final String fruitStandName;
    private final Map<String, Number> boughtFruits;
    private final int total;

    public FruitStandReceipt(int fruitStandNumber, String fruitStandName, List<FruitBasket> fruitBaskets, int total) {
        this.fruitStandNumber = fruitStandNumber;
        this.fruitStandName = fruitStandName;
        this.boughtFruits = fruitBaskets.stream()
            .collect(Collectors.toMap(fruitBasket -> fruitBasket.getFruitType().toString(), FruitBasket::getPrice));
        this.total = total;
    }

    public int getFruitStandNumber() {
        return fruitStandNumber;
    }

    public String getFruitStandName() {
        return fruitStandName;
    }

    public Map<String, Number> getBoughtFruits() {
        return boughtFruits;
    }

    public int getTotal() {
        return total;
    }

    public Set<String> getFruitNames() {
        return boughtFruits.keySet();
    }
}
