package Rex_22.skeletonmod.blocks;

import Rex_22.skeletonmod.reference.LogHelper;
import Rex_22.skeletonmod.reference.ModInfo;
import Rex_22.skeletonmod.util.IBlockRenderer;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.common.registry.GameRegistry;

public enum Blocks {
    //ADD BLOCKS HERE
    EXAMPLE_BLOCK("example_block", new BlockExampleBlock(), CreativeTabs.tabBlock)
    ;

    public final Block block;
    private final String internalName;
    private final Class<? extends ItemBlock> itemBlockClass;
    private final CreativeTabs creativeTabs;
    private final boolean defaultRenderer;

    Blocks(String internalName, Block block) {
        this(internalName, block, ItemBlock.class, null, true);
    }

    Blocks(String internalName, Block block, CreativeTabs creativeTabs) {
        this(internalName, block, ItemBlock.class, creativeTabs, true);
    }

    Blocks(String internalName, Block block, Class<? extends ItemBlock> itemBlockClass) {
        this(internalName, block, itemBlockClass, null, true);
    }

    Blocks(String internalName, Block block, Class<? extends ItemBlock> itemBlockClass, CreativeTabs creativeTabs) {
        this(internalName, block, itemBlockClass, creativeTabs, true);
    }

    Blocks(String internalName, Block block, Class<? extends ItemBlock> itemBlockClass, CreativeTabs creativeTabs, boolean useDefaultRenderer) {
        this.internalName = internalName;
        this.block = block;
        this.itemBlockClass = itemBlockClass;
        this.creativeTabs = creativeTabs;
        this.defaultRenderer = useDefaultRenderer;
    }

    public static void registerBlocks() {
        for (Blocks b : Blocks.values()) {
            b.registerBlock();
        }
    }


    public String getInternalName() {
        return internalName;
    }

    public String getStatName() {
        return StatCollector.translateToLocal(block.getUnlocalizedName().replace("tileentities.", "blocks."));
    }

    private void registerBlock() {
        // Register Block in Game Registry
        GameRegistry.registerBlock(block.setCreativeTab(creativeTabs).setUnlocalizedName(internalName), itemBlockClass, internalName);

        // If block has Render Info, Register Renderer
        if (block instanceof IBlockRenderer) {
            ((IBlockRenderer) block).registerBlockRenderer();
        }

        LogHelper.info("Registered Block: " + internalName);
    }

}
