package gradientmod.gradient;

import gradientmod.gradient.entities.PebbleEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = GradientMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(GradientMod.MOD_ID)
public final class CoreEntities {
  private CoreEntities() { }

  public static final EntityType<? extends ProjectileItemEntity> PEBBLE = null;

  @SubscribeEvent
  public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
    GradientMod.LOGGER.info("Registering entities...");

    event.getRegistry().register(EntityType.Builder.<PebbleEntity>create(PebbleEntity::new, EntityClassification.MISC).build(GradientMod.loc(CoreIds.PEBBLE).toString()).setRegistryName(CoreIds.PEBBLE));
  }
}
