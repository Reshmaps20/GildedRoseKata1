package com.gildedrose.updater;

import com.gildedrose.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    @Test
    @DisplayName("Aged Brie sellIn value reduces by one")
    void updateSellInDaysForAgedBrie () {

        Item item = new Item ("Aged Brie", 1, 1);
        AgedBrie agedBrie = new AgedBrie();
        agedBrie.update (item);
        assertEquals (0, item.sellIn);
    }

    @Test
    @DisplayName("Quality of Aged Brie increases by 1 each day before the sellIn date")
    void updateQualityBeforeSellInDayForAgedBrie () {

        Item item = new Item ("Aged Brie", 5, 10);
        AgedBrie agedBrie = new AgedBrie();
        agedBrie.update (item);
        assertEquals (11, item.quality);
    }

    @Test
    @DisplayName("Quality of Aged Brie increases by 2 each day after the sellIn date")
    void updateQualityAfterSellInDayForAgedBrie () {

        Item item = new Item ("Aged Brie", 0, 10);
        AgedBrie agedBrie = new AgedBrie();
        agedBrie.update (item);
        assertEquals (12, item.quality);

    }

    @Test
    @DisplayName("Maximum quality of Aged Brie is 50")
    void qualityNeverExceedsFiftyForAgedBrie () {

        Item item = new Item ("Aged Brie", 2, 50);
        AgedBrie agedBrie = new AgedBrie();
        agedBrie.update (item);
        assertEquals (50, item.quality);
    }
}
