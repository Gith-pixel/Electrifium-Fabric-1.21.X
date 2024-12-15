package net.woolvex.electrifium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.woolvex.electrifium.block.ModBlocks;

public class ElectrifiumClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COMPRESSED_ELECTRIFIUM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COMPRESSED_ELECTRIFIUM_TRAPDOOR, RenderLayer.getCutout());
    }
}