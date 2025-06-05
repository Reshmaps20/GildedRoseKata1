package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    private static Stream<Arguments> getItemsForValidateSellIDays() {
        return Stream.of(
                Arguments.of(new Item[] { new Item(ItemType.AGED_BRIE.getItemName (), 1, 1) }, 0)
        );
    }

    @ParameterizedTest(name = "Verify SellIn days for items - {index}")
    @MethodSource("getItemsForValidateSellIDays")
    void updateSellInDaysForItems(Item[] items, int expectedSellinDays) {

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedSellinDays, items[0].sellIn);
    }

    private static Stream<Arguments> getItemsForValidateQuality() {
        return Stream.of(
                Arguments.of(new Item[] { new Item(ItemType.AGED_BRIE.getItemName(), 1, 1) }, 2),
                Arguments.of(new Item[] { new Item(ItemType.AGED_BRIE.getItemName(), 0, 10) }, 12),
                Arguments.of(new Item[] { new Item(ItemType.AGED_BRIE.getItemName(), 2, 50) }, 50)
        );
    }

    @ParameterizedTest(name = "Verify Quality  for items - {index}")
    @MethodSource("getItemsForValidateQuality")
    void updateQualityForItems(Item[] items, int expectedQuality) {

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, items[0].quality);
    }
}

