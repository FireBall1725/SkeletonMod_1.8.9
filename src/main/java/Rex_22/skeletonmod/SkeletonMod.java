package Rex_22.skeletonmod;

import Rex_22.skeletonmod.proxy.IProxy;
import Rex_22.skeletonmod.reference.ModInfo;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.MOD_ID, name =  ModInfo.MOD_NAME, version = ModInfo.VERSION)

public class SkeletonMod {
    @Mod.Instance(ModInfo.MOD_ID)
    public static SkeletonMod instance;

    @SidedProxy(clientSide = ModInfo.CLIENT_SIDE_CLASS, serverSide = ModInfo.SERVER_SIDE_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        //Register Items
        proxy.registerItems();
        //Register Blocks
        proxy.registerBlocks();
        //Register Fuel
        proxy.registerFuel();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        //Register Recipes
        proxy.registerRecipes();
        //Register World Gen
        proxy.registerWorldGen();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){

    }

}
