package com.gildedrose.updater;

import com.gildedrose.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultItemTest {

    @Test
    @DisplayName ("Default item: sellIn decreases by 1 each day")
    void updateSellInDaysForDefaultItem() {

        Item item = new Item("Elixir of the Mongoose", 10, 20);
        DefaultItem defaultItem = new DefaultItem();
        defaultItem.update(item);
        assertEquals(9, item.sellIn);
    }

    @Test
    @DisplayName("Default item: quality decreases by 1 before sellIn date")
    void qualityDecreasesByOneBeforeSellIn() {
        Item item = new Item("Elixir of the Mongoose", 5, 10);
        DefaultItem defaultItem = new DefaultItem();
        defaultItem.update(item);
        assertEquals(9, item.quality);
    }

    @Test
    @DisplayName("Default item: quality decreases by 2 after sellIn date")
    void qualityDecreasesByTwoAfterSellIn() {
        Item item = new Item("Elixir of the Mongoose", 0, 10);
        DefaultItem defaultItem = new DefaultItem();
        defaultItem.update(item);
        assertEquals(8, item.quality);
    }

    @Test
    @DisplayName("Default item: quality never goes below 0")
    void qualityNeverGoesBelowZero() {
        Item item = new Item("Elixir of the Mongoose", 0, 0);
        DefaultItem defaultItem = new DefaultItem();
        defaultItem.update(item);
        assertEquals(0, item.quality);
    }
}
