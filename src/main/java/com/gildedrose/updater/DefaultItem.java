package com.gildedrose.updater;

import com.gildedrose.Item;
import static com.gildedrose.validation.ItemValidator.*;

public class DefaultItem implements ItemUpdater{
    @Override
    public void update (Item item) {
        updateSellInDays(item);
        if (item.sellIn >= 0)
            item.quality--;
        else
            item.quality-=2;
    }
}
