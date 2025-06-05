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

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 15, 10);
        BackStagePasses backStagePasses = new BackStagePasses();
        backStagePasses.update (item);
        assertEquals (11, item.quality);
    }

    @Test
    @DisplayName("Backstage Pass: Maximum quality  is 50")
    void qualityNeverExceedsFiftyForBackStagePass () {

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 6, 50);
        BackStagePasses backStagePasses = new BackStagePasses();
        backStagePasses.update (item);
        assertEquals (50, item.quality);
    }

    @Test
    @DisplayName("Backstage Pass: quality increases by 2 when sellIn is between 6 and 10")
    void updateQualityWhenSellInBetweenFiveAndTen () {

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 8, 10);
        BackStagePasses backStagePasses = new BackStagePasses();
        backStagePasses.update (item);
        assertEquals (12, item.quality);
    }

    @Test
    @DisplayName("Backstage Pass: quality increases by 3 when sellIn less than 5")
    void updateQualityWhenSellInLessThanFive () {

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 4, 12);
        BackStagePasses backStagePasses = new BackStagePasses();
        backStagePasses.update (item);
        assertEquals (15, item.quality);
    }
}
