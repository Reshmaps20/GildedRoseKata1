package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackStagePassesTest {

    @Test
    @DisplayName("BackStage Passes sellIn value reduces by one")
    void updateSellInDaysForBackStagePasses () {

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 1, 1);
        BackStagePasses backStagePasses = new BackStagePasses();
        backStagePasses.update (item);
        assertEquals (0, item.sellIn);
    }

    @Test
    @DisplayName("Quality of BackStage Passes increases by 1 each day before the sellIn date")
    void updateQualityBeforeSellInDayForBackStagePasses () {

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 5, 10);
        BackStagePasses backStagePasses = new BackStagePasses();
        backStagePasses.update (item);
        assertEquals (11, item.quality);
    }
}
