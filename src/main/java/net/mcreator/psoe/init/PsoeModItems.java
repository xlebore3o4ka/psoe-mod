/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.psoe.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.psoe.item.SulfurAcidItem;
import net.mcreator.psoe.item.MercuryItem;
import net.mcreator.psoe.PsoeMod;

public class PsoeModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PsoeMod.MODID);
	public static final RegistryObject<Item> TEST;
	public static final RegistryObject<Item> CINNABAR;
	public static final RegistryObject<Item> MERCURY;
	public static final RegistryObject<Item> SULFUR_ACID;
	static {
		TEST = block(PsoeModBlocks.TEST);
		CINNABAR = block(PsoeModBlocks.CINNABAR);
		MERCURY = REGISTRY.register("mercury", MercuryItem::new);
		SULFUR_ACID = REGISTRY.register("sulfur_acid", SulfurAcidItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return block(block, new Item.Properties());
	}

	private static RegistryObject<Item> block(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}