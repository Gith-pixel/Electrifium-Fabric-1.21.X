package net.woolvex.electrifium.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;
import net.woolvex.electrifium.Electrifium;
import net.woolvex.electrifium.item.custom.ModArmorItem;

public class ModItems {
    public static final Item ELECTRIFIUM  = registerItems("electrifium", new Item(new Item.Settings()));
    public static final Item ELECTRIFIED_COPPER_INGOT  = registerItems("electrified_copper_ingot", new Item(new Item.Settings()));
    public static final Item ELECTRIFIED_COPPER_SWORD = registerItems("electrified_copper_sword",
            new SwordItem(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, 4, -1.4F))));
    public static final Item ELECTRIFIED_COPPER_PICKAXE = registerItems("electrified_copper_pickaxe",
            new PickaxeItem(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, 2.5F, -2.0F))));
    public static final Item ELECTRIFIED_COPPER_SHOVEL = registerItems("electrified_copper_shovel",
            new ShovelItem(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, 2.0F, -1.8F))));
    public static final Item ELECTRIFIED_COPPER_AXE = registerItems("electrified_copper_axe",
            new AxeItem(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ELECTRIFIED_COPPER_INGOT, 6.0F, -2.0F))));
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

    public static final Item WARNED_SMITHING_TEMPLATE = registerItems("warned_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(Electrifium.MOD_ID, "warned"), FeatureFlags.VANILLA));


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

