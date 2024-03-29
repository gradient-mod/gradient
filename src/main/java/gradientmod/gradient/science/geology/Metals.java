package gradientmod.gradient.science.geology;

import gradientmod.gradient.science.chemistry.Element;
import gradientmod.gradient.science.chemistry.Elements;
import net.minecraft.util.NonNullList;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public final class Metals {
  private Metals() { }

  private static final Map<String, Metal> metals = new LinkedHashMap<>();

  public static final Metal INVALID_METAL = new Metal("invalid", Float.POSITIVE_INFINITY, 0.0f, 0.0f, false, 0, 0, 0, 0, 0, 0, 0, NonNullList.create());

  public static final Metal AZURITE     = add("azurite",     m -> m.meltTemp(1165.00f).hardness(3.5f).weight(344.67f).colours(0xFF2E01E2, 0xFF9B81D8, 0xFF2901B9, 0xFF271770, 0xFF231C3D, 0xFF1C1630, 0xFF130F21).element(Elements.COPPER, 0.55f).element(Elements.OXYGEN, 0.37f).element(Elements.CARBON, 0.07f).element(Elements.HYDROGEN, 0.01f));
  public static final Metal BRONZE      = add("bronze",      m -> m.meltTemp( 950.00f).hardness(3.5f).weight(182.26f).colours(0xFFFFE48B, 0xFFFFEAA8, 0xFFFFC400, 0xFFDEAA00, 0xFFDB7800, 0xFF795D00, 0xFF795D00).element(Elements.COPPER, 0.75f).element(Elements.TIN, 0.25f));
  public static final Metal CASSITERITE = add("cassiterite", m -> m.meltTemp(1127.00f).hardness(6.5f).weight(150.71f).colours(0xFF7F7F7F, 0xFFB9B9B9, 0xFF707070, 0xFF676767, 0xFF6D6D6D, 0xFF595959, 0xFF505050).element(Elements.TIN, 1.0f));
  public static final Metal COPPER      = add("copper",      m -> m.meltTemp(1085.00f).hardness(3.0f).weight( 63.55f).colours(0xFFFFB88B, 0xFFFFB88B, 0xFFFF6300, 0xFFDE5600, 0xFFDB2400, 0xFF792F00, 0xFF492914).element(Elements.COPPER, 1.0f));
  public static final Metal GOLD        = add("gold",        m -> m.meltTemp(1064.00f).hardness(2.0f).weight(196.97f).colours(0xFFFFFF8B, 0xFFFFFFFF, 0xFFDEDE00, 0xFFDC7613, 0xFF868600, 0xFF505000, 0xFF3C3C00).element(Elements.GOLD, 1.0f));
  public static final Metal GRAPHITE    = add("graphite",    m -> m.meltTemp(3730.00f).hardness(1.5f).weight( 12.01f).colours(0xFF807875, 0xFFBDBDBD, 0xFF383431, 0xFF222222, 0xFF4F4D50, 0xFF404050, 0xFF2F2D30).element(Elements.CARBON, 1.0f));
  public static final Metal HEMATITE    = add("hematite",    m -> m.meltTemp(1548.00f).hardness(4.0f).weight( 55.85f).colours(0xFFB8B8B8, 0xFFDFDFDF, 0xFF767676, 0xFF525252, 0xFF5F5F5F, 0xFF242424, 0xFF151515).element(Elements.IRON, 1.0f));
  public static final Metal IRON        = add("iron",        m -> m.meltTemp(1538.00f).hardness(4.0f).weight( 55.85f).colours(0xFFD8D8D8, 0xFFFFFFFF, 0xFF969696, 0xFF727272, 0xFF7F7F7F, 0xFF444444, 0xFF353535).element(Elements.IRON, 1.0f));
  public static final Metal LEAD        = add("lead",        m -> m.meltTemp( 327.50f).hardness(1.5f).weight(207.20f).colours(0xFF949489, 0xFFD7DBCA, 0xFF727169, 0xFF4C4B41, 0xFF2F3C3D, 0xFF121D1A, 0xFF0C0D0C).element(Elements.LEAD, 1.0f));
  public static final Metal MAGNESIUM   = add("magnesium",   m -> m.meltTemp( 650.00f).hardness(2.5f).weight( 24.31f).colours(0xFFF9F9F9, 0xFFFFFFFF, 0xFFCCCCCC, 0xFFB7B7B7, 0xFF727272, 0xFF444444, 0xFF262626).element(Elements.MAGNESIUM, 1.0f));
  public static final Metal PYRITE      = add("pyrite",      m -> m.meltTemp(1188.00f).hardness(6.0f).weight(119.98f).colours(0xFFAFA67F, 0xFFFFF098, 0xFF736C4F, 0xFF5F5941, 0xFF44453F, 0xFF40413C, 0xFF3D3E39).element(Elements.IRON, 0.5f).element(Elements.SULFUR, 0.5f));
  public static final Metal SPHALERITE  = add("sphalerite",  m -> m.meltTemp(1830.00f).hardness(3.5f).weight( 96.98f).colours(0xFF5C615B, 0xFF73736B, 0xFF3B3D28, 0xFF1F2825, 0xFF151108, 0xFF0D0900, 0xFF010101).element(Elements.ZINC, 0.75f).element(Elements.SULFUR, 0.25f));
  public static final Metal TIN         = add("tin",         m -> m.meltTemp( 231.93f).hardness(1.5f).weight(118.71f).colours(0xFFEFEFEF, 0xFFF9F9F9, 0xFFCCCCCC, 0xFFB7B7B7, 0xFFADADAD, 0xFF8E8E8E, 0xFF777777).element(Elements.TIN, 1.0f));
  public static final Metal ZINC        = add("zinc",        m -> m.meltTemp( 419.53f).hardness(2.5f).weight( 65.38f).colours(0xFFB3B3BB, 0xFFF7FBFA, 0xFF727179, 0xFF4C4B51, 0xFF2F3C42, 0xFF121D1F, 0xFF0C0D11).element(Elements.ZINC, 1.0f));

  public static final Metal GLASS = add("glass", m -> m.meltTemp(1200.00f).hardness(1.0f).weight(50.0f).noIngots());

  public static Metal add(final String name, final Consumer<MetalBuilder> builder) {
    final MetalBuilder mb = new MetalBuilder();
    builder.accept(mb);
    final Metal metal = new Metal(name, mb.meltTemp, mb.hardness, mb.weight, mb.canMakeIngots, mb.colourDiffuse, mb.colourSpecular, mb.colourShadow1, mb.colourShadow2, mb.colourEdge1, mb.colourEdge2, mb.colourEdge3, mb.elements);
    metals.put(name, metal);
    return metal;
  }

  public static Collection<Metal> all() {
    return metals.values();
  }

  public static final class MetalBuilder {
    private float meltTemp;
    private float hardness;
    private float weight;

    private boolean canMakeIngots = true;

    private int colourDiffuse = 0xFFFF00FF;
    private int colourSpecular = 0xFFFFFFFF;
    private int colourShadow1 = 0xFF00FF00;
    private int colourShadow2 = 0xFF007F00;
    private int colourEdge1 = 0xFF3F3F3F;
    private int colourEdge2 = 0xFF2F2F2F;
    private int colourEdge3 = 0xFF1F1F1F;

    private MetalBuilder meltTemp(final float meltTemp) {
      this.meltTemp = meltTemp;
      return this;
    }

    private MetalBuilder hardness(final float hardness) {
      this.hardness = hardness;
      return this;
    }

    private MetalBuilder weight(final float weight) {
      this.weight = weight;
      return this;
    }

    private MetalBuilder noIngots() {
      this.canMakeIngots = false;
      return this;
    }

    public MetalBuilder colours(final int colourDiffuse, final int colourSpecular, final int colourShadow1, final int colourShadow2, final int colourEdge1, final int colourEdge2, final int colourEdge3) {
      this.colourDiffuse = colourDiffuse;
      this.colourSpecular = colourSpecular;
      this.colourShadow1 = colourShadow1;
      this.colourShadow2 = colourShadow2;
      this.colourEdge1 = colourEdge1;
      this.colourEdge2 = colourEdge2;
      this.colourEdge3 = colourEdge3;
      return this;
    }

    private final NonNullList<Metal.MetalElement> elements = NonNullList.create();

    public MetalBuilder element(final Element element, final float percentage) {
      this.elements.add(new Metal.MetalElement(element, percentage));
      return this;
    }
  }
}
