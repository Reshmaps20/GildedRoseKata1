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
}
