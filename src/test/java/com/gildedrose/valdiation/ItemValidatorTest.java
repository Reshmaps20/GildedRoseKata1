package com.gildedrose.valdiation;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import com.gildedrose.validation.ItemValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemValidatorTest {

    private static Stream<Arguments> getQualityForItems () {

        return Stream.of (
                Arguments.of (new Item (ItemType.AGED_BRIE.getItemName (), 5, 10), 2, 12),
                Arguments.of (new Item (ItemType.AGED_BRIE.getItemName (), 5, 50), 2, 50)
        );
    }

    private static Stream<Arguments> getItemsToCheckExpiration () {

        return Stream.of (
                Arguments.of (new Item (ItemType.AGED_BRIE.getItemName (), 0, 10), false),
                Arguments.of (new Item (ItemType.AGED_BRIE.getItemName (), -1, 50), true)
        );
    }

    @Test
    @DisplayName("SellIn day of items should decrease by 1")
    void updateSellInDays () {

        Item item = new Item (ItemType.AGED_BRIE.getItemName (), 5, 10);
        ItemValidator itemValidator = new ItemValidator ();
        itemValidator.updateSellInDays (item);
        assertEquals (4, item.sellIn);
    }

    @ParameterizedTest(name = "Increment item quality - {index} ")
    @MethodSource("getQualityForItems")
    @DisplayName("Increment item quality")
    void incrementQualityForItems (Item input, int amount, int expectedQuality) {

        ItemValidator itemValidator = new ItemValidator ();
        itemValidator.incrementQuality (input, amount);
        assertEquals (expectedQuality, input.quality);
    }

    @ParameterizedTest(name = "Verify item is expired - {index}")
    @MethodSource("getItemsToCheckExpiration")
    void verifyItemExpiration (Item input, boolean expectedValue) {

        ItemValidator itemValidator = new ItemValidator ();
        boolean result = itemValidator.isExpired (input);
        assertEquals (expectedValue, result);
    }
}
