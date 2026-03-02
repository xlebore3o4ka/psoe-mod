/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.psoe.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.psoe.block.TestBlock;
import net.mcreator.psoe.block.GexBlockBlock;
import net.mcreator.psoe.block.FurnaceInterfaceBlock;
import net.mcreator.psoe.block.CinnabarBlock;
import net.mcreator.psoe.PsoeMod;

public class PsoeModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, PsoeMod.MODID);
	public static final RegistryObject<Block> TEST;
	public static final RegistryObject<Block> CINNABAR;
	public static final RegistryObject<Block> FURNACE_INTERFACE;
	public static final RegistryObject<Block> GEX_BLOCK;
	static {
		TEST = REGISTRY.register("test", TestBlock::new);
		CINNABAR = REGISTRY.register("cinnabar", CinnabarBlock::new);
		FURNACE_INTERFACE = REGISTRY.register("furnace_interface", FurnaceInterfaceBlock::new);
		GEX_BLOCK = REGISTRY.register("gex_block", GexBlockBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}