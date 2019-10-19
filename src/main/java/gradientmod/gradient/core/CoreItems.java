package gradientmod.gradient.core;

import gradientmod.gradient.core.items.PebbleItem;
import gradientmod.gradient.core.utils.RegistryHelper;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = GradientCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(GradientCore.MOD_ID)
public final class CoreItems {
  private CoreItems() { }

  public static final Item SALT_BLOCK = null;
  public static final Item SALT = null;
  public static final PebbleItem PEBBLE = null;

  @SubscribeEvent
  public static void registerItems(final RegistryEvent.Register<Item> event) {
    GradientCore.LOGGER.info("Registering items...");

    final RegistryHelper<Item> registry = new RegistryHelper<>(event.getRegistry());

    registry.register(new BlockItem(CoreBlocks.SALT_BLOCK, new Item.Properties().group(ItemGroup.MATERIALS)), CoreIds.SALT_BLOCK);
    registry.register(new Item(new Item.Properties().group(ItemGroup.FOOD)), CoreIds.SALT);
    registry.register(new PebbleItem(CoreBlocks.PEBBLE), CoreIds.PEBBLE);
  }
}
