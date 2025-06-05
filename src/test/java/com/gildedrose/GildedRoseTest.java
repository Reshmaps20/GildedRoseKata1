package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    @DisplayName("Aged Brie sellIn value reduces by one")
    void updateSellInDaysForAgedBrie () {

        Item[] items = new Item[]{new Item ("Aged Brie", 1, 1)};
        GildedRose app = new GildedRose (items);
        app.updateQuality ();
        assertEquals (0, items[0].sellIn);
    }

    @Test
    @DisplayName("Quality of Aged Brie increases by 1 each day before the sellIn date")
    void updateQualityBeforeSellInDayForAgedBrie () {

        Item[] items = new Item[]{new Item ("Aged Brie", 5, 10)};
        GildedRose app = new GildedRose (items);
        app.updateQuality ();
        assertEquals (11, items[0].quality);
    }
}

