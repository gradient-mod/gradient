package gradientmod.gradient;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GradientMod.MOD_ID)
public class GradientMod {
  public static final String MOD_ID = "gradient";

  public static final Logger LOGGER = LogManager.getLogger();

  public static ResourceLocation loc(final String path) {
    return new ResourceLocation(MOD_ID, path);
  }
}
