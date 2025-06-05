package com.gildedrose.updater;

import com.gildedrose.Item;
import static com.gildedrose.validation.ItemValidator.*;

public class BackStagePasses implements ItemUpdater{
    @Override
    public void update (Item item) {
        updateSellInDays(item);

        if(item.sellIn > 5 && item.sellIn <=10)
            incrementQuality(item,2);
        else
            incrementQuality(item,1);
    }
}
