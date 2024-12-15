package net.woolvex.electrifium.datagen;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.SmithingTemplateItem;
import net.woolvex.electrifium.item.ModItems;
import net.woolvex.electrifium.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ELECTRIFIUM_ORE);
        BlockStateModelGenerator.BlockTexturePool CompressedElectrifiumPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COMPRESSED_ELECTRIFIUM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ELECTRIFIUM_ORE);

        CompressedElectrifiumPool.stairs(ModBlocks.COMPRESSED_ELECTRIFIUM_STAIRS);
        CompressedElectrifiumPool.slab(ModBlocks.COMPRESSED_ELECTRIFIUM_SLAB);

        CompressedElectrifiumPool.button(ModBlocks.COMPRESSED_ELECTRIFIUM_BUTTON);
        CompressedElectrifiumPool.pressurePlate(ModBlocks.COMPRESSED_ELECTRIFIUM_PRESSURE_PLATE);

        CompressedElectrifiumPool.fence(ModBlocks.COMPRESSED_ELECTRIFIUM_FENCE);
        CompressedElectrifiumPool.fenceGate(ModBlocks.COMPRESSED_ELECTRIFIUM_FENCE_GATE);
        CompressedElectrifiumPool.wall(ModBlocks.COMPRESSED_ELECTRIFIUM_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.COMPRESSED_ELECTRIFIUM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.COMPRESSED_ELECTRIFIUM_TRAPDOOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ELECTRIFIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELECTRIFIED_COPPER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELECTRIFIED_COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELECTRIFIED_COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELECTRIFIED_COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELECTRIFIED_COPPER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELECTRIFIED_COPPER_PICKAXE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ELECTRIFIED_COPPER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ELECTRIFIED_COPPER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ELECTRIFIED_COPPER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ELECTRIFIED_COPPER_BOOTS));

        itemModelGenerator.register(ModItems.WARNED_SMITHING_TEMPLATE, Models.HANDHELD);



    }
}
