package com.robinb.modi;

import com.robinb.modi.items.GuiItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Modi implements ModInitializer {

    public static Item GUI_ITEM = new GuiItem(new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("modi", "gui_item"), GUI_ITEM);
    }
}
