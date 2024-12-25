package net.woolvex.electrifium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.woolvex.electrifium.item.ModItems;
import net.woolvex.electrifium.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.ELECTRIFIED_COPPER_SWORD)
                .add(ModItems.WOODEN_LONGSWORD)
                .add(ModItems.STONE_LONGSWORD)
                .add(ModItems.GOLDEN_LONGSWORD)
                .add(ModItems.IRON_LONGSWORD)
                .add(ModItems.DIAMOND_LONGSWORD)
                .add(ModItems.NETHERITE_LONGSWORD)
                .add(ModItems.ELECTRIFIED_COPPER_LONGSWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.ELECTRIFIED_COPPER_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.ELECTRIFIED_COPPER_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.ELECTRIFIED_COPPER_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.ELECTRIFIED_COPPER_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ELECTRIFIED_COPPER_HELMET)
                .add(ModItems.ELECTRIFIED_COPPER_CHESTPLATE)
                .add(ModItems.ELECTRIFIED_COPPER_LEGGINGS)
                .add(ModItems.ELECTRIFIED_COPPER_BOOTS);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.ELECTRIFIED_COPPER_HELMET)
                .add(ModItems.ELECTRIFIED_COPPER_CHESTPLATE)
                .add(ModItems.ELECTRIFIED_COPPER_LEGGINGS)
                .add(ModItems.ELECTRIFIED_COPPER_BOOTS);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.ELECTRIFIED_COPPER_HELMET);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.ELECTRIFIED_COPPER_CHESTPLATE);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.ELECTRIFIED_COPPER_LEGGINGS);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.ELECTRIFIED_COPPER_BOOTS);


    }
}