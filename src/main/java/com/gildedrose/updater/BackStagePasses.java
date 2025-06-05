package com.gildedrose.updater;

import com.gildedrose.Item;
import static com.gildedrose.constant.Constants.*;
import static com.gildedrose.validation.ItemValidator.*;
import static com.gildedrose.validation.ItemValidator.setQualityToMinimalQuality;

public class BackStagePasses implements ItemUpdater{
    @Override
    public void update (Item item) {
        incrementQuality (item, calculateIncrementValue (item));
        updateSellInDays(item);
        updateQualityForExpiredItem (item);
    }

    private static int calculateIncrementValue (Item item) {
        return isWithinLimit (item.sellIn, ZERO_DAYS, FIVE_DAYS) ? EXTRA_QUALITY_HIKE :
                isWithinLimit (item.sellIn, FIVE_DAYS, TEN_DAYS) ? DOUBLE_QUALITY_HIKE : SINGLE_QUALITY_HIKE;
    }

    private static boolean isWithinLimit(int value, int lower, int upper) {
        return value > lower && value <= upper;
    }

    private static void updateQualityForExpiredItem (Item item) {
        if (isExpired (item))
            setQualityToMinimalQuality (item);
    }
}
