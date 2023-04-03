package be.pxl.ja.knapsack;

import be.pxl.ja.knapsack.Item;
import be.pxl.ja.knapsack.Knapsack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnapsackTest {

    class MockItem implements Item {

        private String name;
        private double weight;

        public MockItem(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }

        @Override
        public double getWeight() {
            return 0;
        }

        @Override
        public String getName() {
            return null;
        }
    }

    @BeforeEach
    void Setup() {
        Item product1 = new MockItem("fake1", 5);
        Item product2 = new MockItem("fake2", 6);
    }

    @Test
    void it_should_return_a_list_with_2_itmes() throws KnapsackFullException {
        Knapsack<Item> sack = new Knapsack<>(100);

        Item product1 = new MockItem("fake1", 5);
        Item product2 = new MockItem("fake2", 6);

        sack.add(product1);
        sack.add(product2);

        assertEquals(Arrays.asList(product1, product2), sack.getItems());
    }
}
