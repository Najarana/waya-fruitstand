import java.util.ArrayList;
import java.util.Comparator;
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
        FruitStandReceipt lowestTotal = findLowestTotalFruitStand(fruitStands,2);
        System.out.println("Base");
        System.out.println("Stand: " + lowestTotal.getFruitStandNumber());
        System.out.println("----------------------");


    }

    public void extension1() {
        fruitStand1.addFruitBaskets(Set.of(new FruitBasket(7, FruitBasket.Fruit.CHERRY), new FruitBasket(15, FruitBasket.Fruit.PEACH), new FruitBasket(3, FruitBasket.Fruit.PEAR)));
        fruitStand2.addFruitBaskets(Set.of(new FruitBasket(5, FruitBasket.Fruit.CHERRY), new FruitBasket(20, FruitBasket.Fruit.PEACH), new FruitBasket(20, FruitBasket.Fruit.PEAR)));
        fruitStand3.addFruitBaskets(Set.of(new FruitBasket(10, FruitBasket.Fruit.CHERRY), new FruitBasket(25, FruitBasket.Fruit.PEACH), new FruitBasket(4, FruitBasket.Fruit.PEAR)));
        fruitStand4.addFruitBaskets(Set.of(new FruitBasket(15, FruitBasket.Fruit.CHERRY), new FruitBasket(10, FruitBasket.Fruit.PEACH), new FruitBasket(7, FruitBasket.Fruit.PEAR)));
        fruitStand5.addFruitBaskets(Set.of(new FruitBasket(20, FruitBasket.Fruit.CHERRY), new FruitBasket(5, FruitBasket.Fruit.PEACH), new FruitBasket(22, FruitBasket.Fruit.PEAR)));

        List<FruitStand> fruitStands = List.of(fruitStand1, fruitStand2, fruitStand3, fruitStand4, fruitStand5);
        FruitStandReceipt receipt = findLowestTotalFruitStand(fruitStands, Set.of(FruitBasket.Fruit.PEAR), 2);
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
        FruitStandReceipt receipt = findLowestTotalFruitStand(fruitStands, Set.of(FruitBasket.Fruit.PEAR), 2);
        System.out.println("Extension2");
        System.out.println("Stand: " + receipt.getFruitStandNumber());
        receipt.getBoughtFruits().entrySet().forEach(fruitEntry -> {
            System.out.println(fruitEntry.getKey() + ": " + fruitEntry.getValue());
        } );
        System.out.println("Total: " + receipt.getTotal());
        System.out.println("----------------------");
    }

    public void extension3() {
        fruitStand1.addFruitBaskets(Set.of(new FruitBasket(7, FruitBasket.Fruit.CHERRY), new FruitBasket(15, FruitBasket.Fruit.PEACH), new FruitBasket(3, FruitBasket.Fruit.PEAR)));
        fruitStand2.addFruitBaskets(Set.of(new FruitBasket(5, FruitBasket.Fruit.CHERRY), new FruitBasket(20, FruitBasket.Fruit.PEAR)));
        fruitStand3.addFruitBaskets(Set.of(new FruitBasket(10, FruitBasket.Fruit.CHERRY), new FruitBasket(25, FruitBasket.Fruit.PEACH)));
        fruitStand4.addFruitBaskets(Set.of(new FruitBasket(10, FruitBasket.Fruit.PEACH)));
        fruitStand5.addFruitBaskets(Set.of(new FruitBasket(20, FruitBasket.Fruit.CHERRY), new FruitBasket(5, FruitBasket.Fruit.PEACH), new FruitBasket(22, FruitBasket.Fruit.PEAR)));

        List<FruitStand> fruitStands = List.of(fruitStand1, fruitStand2, fruitStand3, fruitStand4, fruitStand5);
        List<FruitStandReceipt> fruitStandReceiptList = getFruitStandReceiptList(fruitStands, Set.of(FruitBasket.Fruit.PEAR), 2);

        System.out.println("Extension3");
        fruitStandReceiptList.forEach(receipt -> {
            System.out.println("Stand: " + receipt.getFruitStandNumber());
            receipt.getBoughtFruits().entrySet().forEach(fruitEntry -> {
                System.out.println(fruitEntry.getKey() + ": " + fruitEntry.getValue());
            } );
            System.out.println("Total: " + receipt.getTotal());
            System.out.println("-------");
        });
    }

    public FruitStandReceipt findLowestTotalFruitStand(List<FruitStand> fruitStands, int numberOfBasketsToBuy) {
        return findLowestTotalFruitStand(fruitStands, Set.of(), numberOfBasketsToBuy);
    }

    public FruitStandReceipt findLowestTotalFruitStand(List<FruitStand> fruitStands, Set<FruitBasket.Fruit> requiredFruits, int numberOfBasketsToBuy) {
        return getFruitStandReceiptList(fruitStands, requiredFruits, numberOfBasketsToBuy).get(0);
    }

    public List<FruitStandReceipt> getFruitStandReceiptList(List<FruitStand> fruitStands, Set<FruitBasket.Fruit> requiredFruits, int numberOfBasketsToBuy) {
        List<FruitStandReceipt> receipts = new ArrayList<>();

        for (FruitStand currentFruitStand : fruitStands) {
            List<FruitBasket> boughtBaskets = findLowestCostBaskets(currentFruitStand.getAvailableFruitsBaskets(), requiredFruits, numberOfBasketsToBuy);
            if (numberOfBasketsToBuy == boughtBaskets.size() && boughtBaskets.stream().map(FruitBasket::getFruitType).collect(Collectors.toList()).containsAll(requiredFruits)) {
                receipts.add(new FruitStandReceipt( currentFruitStand.getStandNumber(), currentFruitStand.getName(), boughtBaskets, totalCostForBaskets(boughtBaskets)));
            }
        }
        return receipts.stream().sorted(Comparator.comparingInt(FruitStandReceipt::getTotal)).collect(Collectors.toList());
    }

    private List<FruitBasket> findLowestCostBaskets(Set<FruitBasket> fruitBaskets, Set<FruitBasket.Fruit> requiredFruits, int numberOfBasketsToBuy) {
        Set<FruitBasket> requiredBaskets = fruitBaskets.stream().filter(fruitBasket -> requiredFruits.contains(fruitBasket.getFruitType())).collect(Collectors.toSet());

        if (requiredBaskets.size() < requiredFruits.size()) {
           return List.of();
        }

        int endIndex = numberOfBasketsToBuy - requiredBaskets.size();
        List<FruitBasket> lowestCostBaskets = fruitBaskets.stream()
            .filter(fruitBasket -> !requiredFruits.contains(fruitBasket.getFruitType()))
            .sorted(Comparator.comparingInt(FruitBasket::getPrice))
            .collect(Collectors.toList());

        if(lowestCostBaskets.size() < endIndex) {
            return List.of();
        }
        lowestCostBaskets = lowestCostBaskets.subList(0, endIndex);
        lowestCostBaskets.addAll(requiredBaskets);
        return lowestCostBaskets;

    }

    private Integer totalCostForBaskets(List<FruitBasket> fruitBaskets) {
        return fruitBaskets.stream().map(FruitBasket::getPrice).reduce(0, Integer::sum);
    }
}
