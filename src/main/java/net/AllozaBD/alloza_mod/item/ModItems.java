package net.AllozaBD.alloza_mod.item;

import net.AllozaBD.alloza_mod.AllozaMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AllozaMod.MODID);

    public static final RegistryObject<Item> EGGOT = ITEMS.register("eggot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRACKED_EGGOT = ITEMS.register("cracked_eggot",
            () -> new Item(new Item.Properties()));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
