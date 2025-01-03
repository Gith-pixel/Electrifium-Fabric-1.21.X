package net.woolvex.electrifium.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.woolvex.electrifium.Electrifium;
import net.woolvex.electrifium.item.custom.ModArmorItem;

public class ModItems {
    public static final Item ELECTRIFIUM  = registerItems("electrifium", new Item(new Item.Settings()));
    public static final Item ELECTRIFIED_COPPER_INGOT  = registerItems("electrified_copper_ingot", new Item(new Item.Settings()));

    public static final Item ELECTRIFIED_COPPER_SWORD = registerItems("electrified_copper_sword",
            new SwordItem(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, 20, -1.4F))));

    public static final Item ELECTRIFIED_COPPER_PICKAXE = registerItems("electrified_copper_pickaxe",
            new PickaxeItem(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, 2.5F, -2.0F))));

    public static final Item ELECTRIFIED_COPPER_SHOVEL = registerItems("electrified_copper_shovel",
            new ShovelItem(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, new Item.Settings()
                                        .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, 2.0F, -1.8F))));

    public static final Item ELECTRIFIED_COPPER_AXE = registerItems("electrified_copper_axe",
            new AxeItem(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, 24.0F, -2.0F))));

    public static final Item ELECTRIFIED_COPPER_HOE = registerItems("electrified_copper_hoe",
            new HoeItem(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, 0.0F, 0.0F))));

    public static final Item ELECTRIFIED_COPPER_HELMET = registerItems("electrified_copper_helmet",
            new ModArmorItem(ModArmorMaterials.ELECTRIFIED_COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40))));

    public static final Item ELECTRIFIED_COPPER_CHESTPLATE = registerItems("electrified_copper_chestplate",
            new ArmorItem(ModArmorMaterials.ELECTRIFIED_COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(40))));

    public static final Item ELECTRIFIED_COPPER_LEGGINGS = registerItems("electrified_copper_leggings",
            new ArmorItem(ModArmorMaterials.ELECTRIFIED_COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40))));

    public static final Item ELECTRIFIED_COPPER_BOOTS = registerItems("electrified_copper_boots",
            new ArmorItem(ModArmorMaterials.ELECTRIFIED_COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40))));

    public static final Item WOODEN_LONGSWORD = registerItems("wooden_longsword",
            new SwordItem(ToolMaterials.WOOD, new Item.Settings()
                    .attributeModifiers(AttributeModifiersComponent.builder()
                                    .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                            new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_damage")
                                                    , 4.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                                    .add(EntityAttributes.GENERIC_ATTACK_SPEED,
                                            new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_speed")
                                                    , -0.2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                                    .add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                            new EntityAttributeModifier(Identifier.ofVanilla("player.player_entity_interaction_range")
                                                    , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                                    .add(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                                            new EntityAttributeModifier(Identifier.ofVanilla("player.player_block_interaction_range")
                                                    , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                                    .build()
                    )
            )
    );


    public static final Item STONE_LONGSWORD = registerItems("stone_longsword",
            new SwordItem(ToolMaterials.STONE, new Item.Settings()
                    .attributeModifiers(AttributeModifiersComponent.builder()
                            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_damage")
                                            , 4.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.GENERIC_ATTACK_SPEED,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_speed")
                                            , -0.2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_entity_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_block_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .build()
                    )
            ));

    public static final Item GOLDEN_LONGSWORD = registerItems("golden_longsword",
            new SwordItem(ToolMaterials.GOLD, new Item.Settings()
                    .attributeModifiers(AttributeModifiersComponent.builder()
                            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_damage")
                                            , 4.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.GENERIC_ATTACK_SPEED,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_speed")
                                            , -0.2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_entity_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_block_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .build()
                    )
            ));

    public static final Item IRON_LONGSWORD = registerItems("iron_longsword",
            new SwordItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(AttributeModifiersComponent.builder()
                            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_damage")
                                            , 4.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.GENERIC_ATTACK_SPEED,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_speed")
                                            , -0.2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_entity_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_block_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .build()
                    )
            ));

    public static final Item DIAMOND_LONGSWORD = registerItems("diamond_longsword",
            new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(AttributeModifiersComponent.builder()
                            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_damage")
                                            , 4.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.GENERIC_ATTACK_SPEED,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_speed")
                                            , -0.2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_entity_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_block_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .build()
                    )
            ));

    public static final Item NETHERITE_LONGSWORD = registerItems("netherite_longsword",
            new SwordItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(AttributeModifiersComponent.builder()
                            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_damage")
                                            , 4.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.GENERIC_ATTACK_SPEED,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_speed")
                                            , -0.2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_entity_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_block_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .build()
                    )
            ));

    public static final Item ELECTRIFIED_COPPER_LONGSWORD = registerItems("electrified_copper_longsword",
            new SwordItem(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, new Item.Settings()
                    .attributeModifiers(AttributeModifiersComponent.builder()
                            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_damage")
                                            , 4.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.GENERIC_ATTACK_SPEED,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.generic_attack_speed")
                                            , -0.2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_entity_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .add(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                                    new EntityAttributeModifier(Identifier.ofVanilla("player.player_block_interaction_range")
                                            , 2, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.ANY)
                            .build()
                    )
            ));


    private static Item registerItems(String name , Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Electrifium.MOD_ID, name),item );
    }
    public static void registerModItems() {
        Electrifium.LOGGER.info("Registering Mod Items for " + Electrifium.MOD_ID );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ELECTRIFIUM);
            fabricItemGroupEntries.add(ELECTRIFIED_COPPER_INGOT);
        });
    }
}

