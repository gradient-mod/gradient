package gradientmod.gradient.core;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GradientCore.MOD_ID)
public class GradientCore {
  public static final String MOD_ID = "gradient-core";

  public static final Logger LOGGER = LogManager.getLogger();

  public static ResourceLocation loc(final String path) {
    return new ResourceLocation(MOD_ID, path);
  }
}
