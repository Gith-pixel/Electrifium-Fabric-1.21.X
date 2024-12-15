package net.woolvex.electrifium.datagen;

import net.woolvex.electrifium.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.woolvex.electrifium.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.COMPRESSED_ELECTRIFIUM)
                .add(ModBlocks.ELECTRIFIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ELECTRIFIUM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.COMPRESSED_ELECTRIFIUM)
                .add(ModBlocks.ELECTRIFIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ELECTRIFIUM_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.COMPRESSED_ELECTRIFIUM_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.COMPRESSED_ELECTRIFIUM_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.COMPRESSED_ELECTRIFIUM_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ELECTRIFIED_COPPER_INGOT_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}