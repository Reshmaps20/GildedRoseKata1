package com.gildedrose.factory;

import com.gildedrose.ItemType;
import com.gildedrose.updater.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ItemUpdaterFactory {

    private static final Map<String, Supplier<ItemUpdater>> ITEM_SUPPLIER = createItemsMap ();

    private static Map<String, Supplier<ItemUpdater>> createItemsMap () {
        Map<String, Supplier<ItemUpdater>> map = new HashMap<> ();
        map.put (ItemType.AGED_BRIE.getItemName (), AgedBrie::new);
        map.put(ItemType.BACK_STAGE_PASSES.getItemName(), BackStagePasses::new);
        map.put(ItemType.SULFURAS.getItemName(), Sulfuras::new);
        return map;
    }

    public static ItemUpdater getItems (String itemType) {
        return ITEM_SUPPLIER.getOrDefault(itemType, DefaultItem::new).get();
    }
}
