package com.gildedrose.updater;

import com.gildedrose.Item;
import static com.gildedrose.validation.ItemValidator.*;

public class Conjured implements ItemUpdater{
    @Override
    public void update (Item item) {
        updateSellInDays(item);
        if (item.sellIn >= 0)
            decrementQuality (item, 2);
        else
            decrementQuality (item, 4);
    }
}
