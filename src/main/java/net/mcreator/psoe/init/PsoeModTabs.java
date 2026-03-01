/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.psoe.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.psoe.PsoeMod;

public class PsoeModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PsoeMod.MODID);
	public static final RegistryObject<CreativeModeTab> PSOE_TAB = REGISTRY.register("psoe_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.psoe.psoe_tab")).icon(() -> new ItemStack(PsoeModBlocks.CINNABAR.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PsoeModBlocks.CINNABAR.get().asItem());
				tabData.accept(PsoeModItems.MERCURY.get());
				tabData.accept(PsoeModItems.SULFUR_ACID.get());
			}).build());
}