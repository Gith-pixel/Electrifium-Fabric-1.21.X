package net.woolvex.electrifium.datagen;

import net.woolvex.electrifium.item.ModItems;
import net.woolvex.electrifium.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;


public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.COMPRESSED_ELECTRIFIUM);


        addDrop(ModBlocks.ELECTRIFIUM_ORE, oreDrops(ModBlocks.ELECTRIFIUM_ORE, ModItems.ELECTRIFIUM));
        addDrop(ModBlocks.DEEPSLATE_ELECTRIFIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_ELECTRIFIUM_ORE, ModItems.ELECTRIFIUM));

        addDrop(ModBlocks.COMPRESSED_ELECTRIFIUM_STAIRS);
        addDrop(ModBlocks.COMPRESSED_ELECTRIFIUM_SLAB, slabDrops(ModBlocks.COMPRESSED_ELECTRIFIUM_SLAB));

        addDrop(ModBlocks.COMPRESSED_ELECTRIFIUM_BUTTON);
        addDrop(ModBlocks.COMPRESSED_ELECTRIFIUM_PRESSURE_PLATE);

        addDrop(ModBlocks.COMPRESSED_ELECTRIFIUM_WALL);
        addDrop(ModBlocks.COMPRESSED_ELECTRIFIUM_FENCE);
        addDrop(ModBlocks.COMPRESSED_ELECTRIFIUM_FENCE_GATE);

        addDrop(ModBlocks.COMPRESSED_ELECTRIFIUM_DOOR, doorDrops(ModBlocks.COMPRESSED_ELECTRIFIUM_DOOR));
        addDrop(ModBlocks.COMPRESSED_ELECTRIFIUM_TRAPDOOR);
    }
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));

    }
}
