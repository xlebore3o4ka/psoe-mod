/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.psoe.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.psoe.PsoeMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PsoeModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PsoeMod.MODID);
	public static final RegistryObject<CreativeModeTab> PSOE_TAB = REGISTRY.register("psoe_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.psoe.psoe_tab")).icon(() -> new ItemStack(PsoeModBlocks.CINNABAR.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PsoeModBlocks.CINNABAR.get().asItem());
				tabData.accept(PsoeModItems.MERCURY.get());
				tabData.accept(PsoeModItems.HYDROGEN.get());
				tabData.accept(PsoeModBlocks.FURNACE_INTERFACE.get().asItem());
				tabData.accept(PsoeModItems.OXYGEN.get());
				tabData.accept(PsoeModBlocks.GEX_BLOCK.get().asItem());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(PsoeModBlocks.GEX_BLOCK.get().asItem());
		}
	}
}