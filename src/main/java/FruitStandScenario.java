import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FruitStandScenario {

    FruitStand fruitStand1 = new FruitStand(1, "Marco's fruit stand");
    FruitStand fruitStand2 = new FruitStand(2, "Jan's fruit emporium");
    FruitStand fruitStand3 = new FruitStand(3, "Roberto's fruits");
    FruitStand fruitStand4 = new FruitStand(4, "ACME fruit");
    FruitStand fruitStand5 = new FruitStand(5, "Fruit on the loose");


    public void base() {
        fruitStand1.addFruitBaskets(Set.of(new FruitBasket(7, FruitBasket.Fruit.CHERRY), new FruitBasket(17, FruitBasket.Fruit.PEACH)));
        fruitStand2.addFruitBaskets(Set.of(new FruitBasket(5, FruitBasket.Fruit.CHERRY), new FruitBasket(13, FruitBasket.Fruit.PEACH)));
        fruitStand3.addFruitBaskets(Set.of(new FruitBasket(10, FruitBasket.Fruit.CHERRY), new FruitBasket(25, FruitBasket.Fruit.PEACH)));
        fruitStand4.addFruitBaskets(Set.of(new FruitBasket(15, FruitBasket.Fruit.CHERRY), new FruitBasket(10, FruitBasket.Fruit.PEACH)));
        fruitStand5.addFruitBaskets(Set.of(new FruitBasket(20, FruitBasket.Fruit.CHERRY), new FruitBasket(5, FruitBasket.Fruit.PEACH)));

        List<FruitStand> fruitStands = List.of(fruitStand1, fruitStand2, fruitStand3, fruitStand4, fruitStand5);
        FruitStand lowestTotal = findLowestTotalFruitStand(fruitStands);
        System.out.println("Base");
        System.out.println("Stand: " + lowestTotal.getStandNumber());
        System.out.println("----------------------");


    }

    public void extension1() {
        fruitStand1.addFruitBaskets(Set.of(new FruitBasket(7, FruitBasket.Fruit.CHERRY), new FruitBasket(15, FruitBasket.Fruit.PEACH), new FruitBasket(3, FruitBasket.Fruit.PEAR)));
        fruitStand2.addFruitBaskets(Set.of(new FruitBasket(5, FruitBasket.Fruit.CHERRY), new FruitBasket(20, FruitBasket.Fruit.PEACH), new FruitBasket(20, FruitBasket.Fruit.PEAR)));
        fruitStand3.addFruitBaskets(Set.of(new FruitBasket(10, FruitBasket.Fruit.CHERRY), new FruitBasket(25, FruitBasket.Fruit.PEACH), new FruitBasket(4, FruitBasket.Fruit.PEAR)));
        fruitStand4.addFruitBaskets(Set.of(new FruitBasket(15, FruitBasket.Fruit.CHERRY), new FruitBasket(10, FruitBasket.Fruit.PEACH), new FruitBasket(7, FruitBasket.Fruit.PEAR)));
        fruitStand5.addFruitBaskets(Set.of(new FruitBasket(20, FruitBasket.Fruit.CHERRY), new FruitBasket(5, FruitBasket.Fruit.PEACH), new FruitBasket(22, FruitBasket.Fruit.PEAR)));

        List<FruitStand> fruitStands = List.of(fruitStand1, fruitStand2, fruitStand3, fruitStand4, fruitStand5);
        FruitStandReceipt receipt = findLowestTotalFruitStandWithRequiredFruits(fruitStands, Set.of(FruitBasket.Fruit.PEAR), 2);
        System.out.println("Extension1");
        System.out.println("Stand: " + receipt.getFruitStandNumber());
        System.out.println("Total: " + receipt.getTotal());
        System.out.println("----------------------");

    }

    public void extension2() {
        fruitStand1.addFruitBaskets(Set.of(new FruitBasket(7, FruitBasket.Fruit.CHERRY), new FruitBasket(15, FruitBasket.Fruit.PEACH), new FruitBasket(3, FruitBasket.Fruit.PEAR)));
        fruitStand2.addFruitBaskets(Set.of(new FruitBasket(5, FruitBasket.Fruit.CHERRY), new FruitBasket(20, FruitBasket.Fruit.PEACH), new FruitBasket(20, FruitBasket.Fruit.PEAR)));
        fruitStand3.addFruitBaskets(Set.of(new FruitBasket(10, FruitBasket.Fruit.CHERRY), new FruitBasket(25, FruitBasket.Fruit.PEACH), new FruitBasket(4, FruitBasket.Fruit.PEAR)));
        fruitStand4.addFruitBaskets(Set.of(new FruitBasket(15, FruitBasket.Fruit.CHERRY), new FruitBasket(10, FruitBasket.Fruit.PEACH), new FruitBasket(7, FruitBasket.Fruit.PEAR)));
        fruitStand5.addFruitBaskets(Set.of(new FruitBasket(20, FruitBasket.Fruit.CHERRY), new FruitBasket(5, FruitBasket.Fruit.PEACH), new FruitBasket(22, FruitBasket.Fruit.PEAR)));

        List<FruitStand> fruitStands = List.of(fruitStand1, fruitStand2, fruitStand3, fruitStand4, fruitStand5);
        FruitStandReceipt receipt = findLowestTotalFruitStandWithRequiredFruits(fruitStands, Set.of(FruitBasket.Fruit.PEAR), 2);
        System.out.println("Stand: " + receipt.getFruitStandNumber());
        System.out.println("Total: " + receipt.getTotal());
        receipt.getBoughtFruits().entrySet().forEach(fruitEntry -> {
            System.out.println(fruitEntry.getKey() + ": " + fruitEntry.getValue());
        } );
    }

    public void extension3() {

    }

    public FruitStand findLowestTotalFruitStand(List<FruitStand> fruitStands) {
        FruitStand lowest = null;
        Integer lowestTotal = null;

        for (int i = 0; i < fruitStands.size(); i++) {
            FruitStand currentFruitStand = fruitStands.get(i);
            if(lowestTotal == null || lowest.basketsTotalCost() > currentFruitStand.basketsTotalCost()) {
                lowest = fruitStands.get(i);
                lowestTotal = currentFruitStand.basketsTotalCost();
            }
        }
        return lowest;
    }

    public FruitStandReceipt findLowestTotalFruitStandWithRequiredFruits(List<FruitStand> fruitStands, Set<FruitBasket.Fruit> requiredFruits, int totalBaskets) {
        List<FruitStandReceipt> receipts = new ArrayList<>();

        for (FruitStand currentFruitStand : fruitStands) {
            Set<FruitBasket> boughtBaskets = findLowestCostBaskets(currentFruitStand.getAvailableFruitsBaskets(), requiredFruits, totalBaskets);
            if (totalBaskets == boughtBaskets.size() && boughtBaskets.stream().map(FruitBasket::getFruitType).collect(Collectors.toList()).containsAll(requiredFruits)) {
                receipts.add(new FruitStandReceipt( currentFruitStand.getStandNumber(), currentFruitStand.getName(), boughtBaskets, totalCostForBaskets(boughtBaskets)));
            }
        }

        return getFruitStandReceiptList(fruitStands, requiredFruits, totalBaskets).get(0);
    }

    private List<FruitStandReceipt> getFruitStandReceiptList(List<FruitStand> fruitStands, Set<FruitBasket.Fruit> requiredFruits, int totalBaskets) {
        List<FruitStandReceipt> receipts = new ArrayList<>();

        for (FruitStand currentFruitStand : fruitStands) {
            Set<FruitBasket> boughtBaskets = findLowestCostBaskets(currentFruitStand.getAvailableFruitsBaskets(), requiredFruits, totalBaskets);
            if (totalBaskets == boughtBaskets.size() && boughtBaskets.stream().map(FruitBasket::getFruitType).collect(Collectors.toList()).containsAll(requiredFruits)) {
                receipts.add(new FruitStandReceipt( currentFruitStand.getStandNumber(), currentFruitStand.getName(), boughtBaskets, totalCostForBaskets(boughtBaskets)));
            }
        }
        return receipts.stream().sorted(Comparator.comparingInt(FruitStandReceipt::getTotal)).collect(Collectors.toList());
    }

    public Set<FruitBasket> findLowestCostBaskets(Set<FruitBasket> fruitBaskets, Set<FruitBasket.Fruit> requiredFruits, int numberOfBasketsToBuy) {
        Set<FruitBasket> requiredBaskets = fruitBaskets.stream().filter(fruitBasket -> requiredFruits.contains(fruitBasket.getFruitType())).collect(Collectors.toSet());

        if (requiredBaskets.size() < requiredFruits.size()) {
           return Set.of();
        }

        List<FruitBasket> lowestCostBaskets = fruitBaskets.stream()
            .filter(fruitBasket -> !requiredFruits.contains(fruitBasket.getFruitType()))
            .sorted(Comparator.comparingInt(FruitBasket::getPrice))
            .collect(Collectors.toList())
            .subList(0, numberOfBasketsToBuy - requiredBaskets.size());

        requiredBaskets.addAll(lowestCostBaskets);
        return requiredBaskets;

    }

    public int getFruitStandTotal(FruitStand fruitStand, Set<FruitBasket.Fruit> requiredFruits, int numberOfBaskets) {
        Set<FruitBasket> requiredBaskets = fruitStand.getAvailableFruitsBaskets().stream().filter(fruitBasket -> EnumSet.copyOf(requiredFruits).contains(fruitBasket.getFruitType())).collect(Collectors.toSet());
        Integer requiredBasketsCost = totalCostForBaskets(requiredBaskets);

        Set<FruitBasket> otherBaskets = fruitStand.getAvailableFruitsBaskets().stream().filter(fruitBasket -> !EnumSet.copyOf(requiredFruits).contains(fruitBasket.getFruitType())).collect(Collectors.toSet());
        List<FruitBasket> lowestCostBaskets = otherBaskets.stream()
            .sorted(Comparator.comparingInt(FruitBasket::getPrice))
            .collect(Collectors.toList())
        .subList(0, numberOfBaskets - requiredBaskets.size());

        findLowestCostBaskets(fruitStand.getAvailableFruitsBaskets(), requiredFruits, numberOfBaskets);

        int otherBaskestsTotal = totalCostForBaskets(Set.copyOf(lowestCostBaskets));

        return otherBaskestsTotal + requiredBasketsCost;
    }

    private Integer totalCostForBaskets(Set<FruitBasket> fruitBaskets) {
        return fruitBaskets.stream().map(FruitBasket::getPrice).reduce(0, Integer::sum);
    }
}
