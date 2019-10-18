package gradientmod.gradient.core;

import gradientmod.gradient.core.utils.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = GradientCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(GradientCore.MOD_ID)
public final class CoreBlocks {
  private CoreBlocks() { }

  public static final Block SALT_BLOCK = null;

  @SubscribeEvent
  public static void registerBlocks(final RegistryEvent.Register<Block> event) {
    GradientCore.LOGGER.info("Registering blocks...");

    final RegistryHelper<Block> registry = new RegistryHelper<>(event.getRegistry());

    registry.register(new Block(Block.Properties.create(Material.SAND, MaterialColor.QUARTZ).hardnessAndResistance(0.5f).sound(SoundType.SAND)), CoreIds.SALT_BLOCK);
  }
}
