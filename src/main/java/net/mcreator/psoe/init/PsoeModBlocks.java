/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.psoe.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.psoe.block.TestBlock;
import net.mcreator.psoe.block.SfgdjkfgdnbhkjBlock;
import net.mcreator.psoe.block.CinnabarBlock;
import net.mcreator.psoe.PsoeMod;

public class PsoeModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, PsoeMod.MODID);
	public static final RegistryObject<Block> TEST;
	public static final RegistryObject<Block> CINNABAR;
	public static final RegistryObject<Block> SFGDJKFGDNBHKJ;
	static {
		TEST = REGISTRY.register("test", TestBlock::new);
		CINNABAR = REGISTRY.register("cinnabar", CinnabarBlock::new);
		SFGDJKFGDNBHKJ = REGISTRY.register("sfgdjkfgdnbhkj", SfgdjkfgdnbhkjBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}