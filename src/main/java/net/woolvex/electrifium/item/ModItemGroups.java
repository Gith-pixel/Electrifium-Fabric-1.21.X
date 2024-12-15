package net.woolvex.electrifium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.woolvex.electrifium.Electrifium;
import net.woolvex.electrifium.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup ELECTRIFIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Electrifium.MOD_ID, "electrifium_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(net.woolvex.electrifium.item.ModItems.ELECTRIFIUM))
                    .displayName(Text.translatable("itemgroup.electrifium.Electrifium"))
                    .entries((displayContext, entries) -> {
                        entries.add(net.woolvex.electrifium.item.ModItems.ELECTRIFIED_COPPER_INGOT);
                        entries.add(net.woolvex.electrifium.item.ModItems.ELECTRIFIUM);
                        entries.add(ModBlocks.COMPRESSED_ELECTRIFIUM);
                        entries.add(ModBlocks.ELECTRIFIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ELECTRIFIUM_ORE);
                        entries.add(ModBlocks.COMPRESSED_ELECTRIFIUM_STAIRS);
                        entries.add(ModBlocks.COMPRESSED_ELECTRIFIUM_SLAB);

                        entries.add(ModBlocks.COMPRESSED_ELECTRIFIUM_BUTTON);
                        entries.add(ModBlocks.COMPRESSED_ELECTRIFIUM_PRESSURE_PLATE);

                        entries.add(ModBlocks.COMPRESSED_ELECTRIFIUM_FENCE);
                        entries.add(ModBlocks.COMPRESSED_ELECTRIFIUM_FENCE_GATE);
                        entries.add(ModBlocks.COMPRESSED_ELECTRIFIUM_WALL);

                        entries.add(ModBlocks.COMPRESSED_ELECTRIFIUM_DOOR);
                        entries.add(ModBlocks.COMPRESSED_ELECTRIFIUM_TRAPDOOR);
                        entries.add(ModItems.ELECTRIFIED_COPPER_SWORD);
                        entries.add(ModItems.ELECTRIFIED_COPPER_AXE);
                        entries.add(ModItems.ELECTRIFIED_COPPER_PICKAXE);
                        entries.add(ModItems.ELECTRIFIED_COPPER_HOE);
                        entries.add(ModItems.ELECTRIFIED_COPPER_SHOVEL);

                        entries.add(ModItems.ELECTRIFIED_COPPER_HELMET);
                        entries.add(ModItems.ELECTRIFIED_COPPER_CHESTPLATE);
                        entries.add(ModItems.ELECTRIFIED_COPPER_LEGGINGS);
                        entries.add(ModItems.ELECTRIFIED_COPPER_BOOTS);

                        entries.add(ModItems.WARNED_SMITHING_TEMPLATE);

                    }).build());

    public static void registerItemGroups(){
        Electrifium.LOGGER.info("Registering Item  Groups for"+Electrifium.MOD_ID);
    }
}
