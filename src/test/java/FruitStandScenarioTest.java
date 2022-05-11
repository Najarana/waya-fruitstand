import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitStandScenarioTest {

    FruitStandScenario fruitStandScenario = new FruitStandScenario();
    FruitStand fruitStand1 = new FruitStand(1, "Marco's fruit stand");
    FruitStand fruitStand2 = new FruitStand(2, "Jan's fruit emporium");
    FruitStand fruitStand3 = new FruitStand(3, "Roberto's fruits");

    @Test
    public void testLowestTotalFruitStand() {
        FruitStand fruitStand1 = new FruitStand(1, "Marco's fruit stand");
        FruitStand fruitStand2 = new FruitStand(2, "Jan's fruit emporium");
        FruitStand fruitStand3 = new FruitStand(3, "Roberto's fruits");

        fruitStand1.addFruitBaskets(Set.of(new FruitBasket(7, FruitBasket.Fruit.CHERRY), new FruitBasket(15, FruitBasket.Fruit.PEACH)));
        fruitStand2.addFruitBaskets(Set.of(new FruitBasket(5, FruitBasket.Fruit.CHERRY), new FruitBasket(20, FruitBasket.Fruit.PEACH)));
        fruitStand3.addFruitBaskets(Set.of(new FruitBasket(10, FruitBasket.Fruit.CHERRY), new FruitBasket(25, FruitBasket.Fruit.PEACH)));

        FruitStandReceipt fruitStandReceipt = fruitStandScenario.findLowestTotalFruitStand(List.of(fruitStand1, fruitStand2, fruitStand3), 2);
        assertEquals(fruitStandReceipt.getFruitStandNumber(), fruitStand1.getStandNumber());
        assertEquals( 7+15, fruitStandReceipt.getTotal());
    }



    @Test
    public void testLowestFruitStandTotalForRequiredFruits() {

        fruitStand1.addFruitBaskets(Set.of(
            new FruitBasket(7, FruitBasket.Fruit.CHERRY),
            new FruitBasket(5, FruitBasket.Fruit.PEACH),
            new FruitBasket(12, FruitBasket.Fruit.PEAR)));
        fruitStand2.addFruitBaskets(Set.of(
            new FruitBasket(5, FruitBasket.Fruit.CHERRY),
            new FruitBasket(5, FruitBasket.Fruit.PEACH),
            new FruitBasket(60, FruitBasket.Fruit.PEAR)));
        fruitStand3.addFruitBaskets(Set.of(
            new FruitBasket(10, FruitBasket.Fruit.CHERRY),
            new FruitBasket(25, FruitBasket.Fruit.PEACH),
            new FruitBasket(3, FruitBasket.Fruit.PEAR)));

        FruitStandReceipt lowestCostFruitStand = fruitStandScenario.findLowestTotalFruitStand(List.of(fruitStand1, fruitStand2, fruitStand3), Set.of(FruitBasket.Fruit.PEAR), 2);
        assertEquals(fruitStand3.getStandNumber(), lowestCostFruitStand.getFruitStandNumber());

        lowestCostFruitStand = fruitStandScenario.findLowestTotalFruitStand(List.of(fruitStand1, fruitStand2, fruitStand3), Set.of(FruitBasket.Fruit.PEAR, FruitBasket.Fruit.PEACH), 2);
        assertEquals(fruitStand1.getStandNumber(), lowestCostFruitStand.getFruitStandNumber());

        lowestCostFruitStand = fruitStandScenario.findLowestTotalFruitStand(List.of(fruitStand1, fruitStand2, fruitStand3), Set.of(), 2);
        assertEquals(fruitStand2.getStandNumber(), lowestCostFruitStand.getFruitStandNumber());
    }

    @Test
    public void testFruitNotInStand() {
        fruitStand1.addFruitBaskets(Set.of(
            new FruitBasket(7, FruitBasket.Fruit.CHERRY),
            new FruitBasket(5, FruitBasket.Fruit.PEACH)));
        fruitStand2.addFruitBaskets(Set.of(
            new FruitBasket(5, FruitBasket.Fruit.CHERRY),
            new FruitBasket(5, FruitBasket.Fruit.PEACH),
            new FruitBasket(60, FruitBasket.Fruit.PEAR)));
        fruitStand3.addFruitBaskets(Set.of(
            new FruitBasket(10, FruitBasket.Fruit.CHERRY),
            new FruitBasket(3, FruitBasket.Fruit.PEAR)));

        FruitStandReceipt lowestCostFruitStand = fruitStandScenario.findLowestTotalFruitStand(List.of(fruitStand1, fruitStand2, fruitStand3), Set.of(FruitBasket.Fruit.PEAR), 2);
        assertEquals(fruitStand3.getStandNumber(), lowestCostFruitStand.getFruitStandNumber());

        lowestCostFruitStand = fruitStandScenario.findLowestTotalFruitStand(List.of(fruitStand1, fruitStand2, fruitStand3), Set.of(FruitBasket.Fruit.PEACH), 2);
        assertEquals(fruitStand2.getStandNumber(), lowestCostFruitStand.getFruitStandNumber());
    }

    @Test
    public void testFindFruitStandsWithrRequiredFruits() {
        fruitStand1.addFruitBaskets(Set.of(
            new FruitBasket(7, FruitBasket.Fruit.CHERRY),
            new FruitBasket(5, FruitBasket.Fruit.PEACH)));
        fruitStand2.addFruitBaskets(Set.of(new FruitBasket(60, FruitBasket.Fruit.PEAR)));
        fruitStand3.addFruitBaskets(Set.of(
            new FruitBasket(10, FruitBasket.Fruit.CHERRY),
            new FruitBasket(3, FruitBasket.Fruit.PEAR)));

        List<FruitStandReceipt> fruitStandReceiptList = fruitStandScenario.getFruitStandReceiptList(List.of(fruitStand1, fruitStand2, fruitStand3), Set.of(FruitBasket.Fruit.PEAR), 2);
        assertEquals(1, fruitStandReceiptList.size());
        assertEquals(fruitStand3.getStandNumber(), fruitStandReceiptList.get(0).getFruitStandNumber());

    }

}