package net.woolvex.electrifium.block;

import net.minecraft.block.*;
import net.woolvex.electrifium.Electrifium;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block COMPRESSED_ELECTRIFIUM = registerblock("compressed_electrifium",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static final Block ELECTRIFIUM_ORE = registerblock("electrifium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 3),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block DEEPSLATE_ELECTRIFIUM_ORE = registerblock("deepslate_electrifium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 3),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block COMPRESSED_ELECTRIFIUM_STAIRS = registerblock("compressed_electrifium_stairs",
            new StairsBlock(ModBlocks.COMPRESSED_ELECTRIFIUM.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block COMPRESSED_ELECTRIFIUM_SLAB = registerblock("compressed_electrifium_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block COMPRESSED_ELECTRIFIUM_BUTTON = registerblock("compressed_electrifium_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));

    public static final Block COMPRESSED_ELECTRIFIUM_PRESSURE_PLATE = registerblock("compressed_electrifium_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block COMPRESSED_ELECTRIFIUM_FENCE = registerblock("compressed_electrifium_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block COMPRESSED_ELECTRIFIUM_FENCE_GATE = registerblock("compressed_electrifium_fence_gate",
            new FenceGateBlock(WoodType.CRIMSON, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block COMPRESSED_ELECTRIFIUM_WALL = registerblock("compressed_electrifium_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block COMPRESSED_ELECTRIFIUM_DOOR = registerblock("compressed_electrifium_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block COMPRESSED_ELECTRIFIUM_TRAPDOOR = registerblock("compressed_electrifium_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));




    private static Block registerblock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Electrifium.MOD_ID, name), block);

    }

    private static void registerBlockItem(String name, Block block){

        Registry.register(Registries.ITEM, Identifier.of(Electrifium.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks(){
        Electrifium.LOGGER.info("Registering Mod Blocks for " + Electrifium.MOD_ID );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.COMPRESSED_ELECTRIFIUM);
            fabricItemGroupEntries.add(ModBlocks.ELECTRIFIUM_ORE);
            fabricItemGroupEntries.add(ModBlocks.DEEPSLATE_ELECTRIFIUM_ORE);
        });
    }


}
