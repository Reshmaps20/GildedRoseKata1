package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredTest {

    @Test
    @DisplayName("Conjured sellIn value reduces by one")
    void updateSellInDaysForConjured () {

        Item item = new Item (ItemType.CONJURED.getItemName (), 1, 1);
        Conjured conjured = new Conjured();
        conjured.update (item);
        assertEquals (0, item.sellIn);
    }
}
