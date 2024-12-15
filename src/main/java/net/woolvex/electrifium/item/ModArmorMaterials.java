package net.woolvex.electrifium.item;

import net.woolvex.electrifium.Electrifium;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final RegistryEntry<ArmorMaterial> ELECTRIFIED_COPPER_ARMOR_MATERIAL = registerArmorMaterial("electrified_copper_ingot",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 5);
                map.put(ArmorItem.Type.LEGGINGS, 8);
                map.put(ArmorItem.Type.CHESTPLATE, 10);
                map.put(ArmorItem.Type.HELMET, 5);
                map.put(ArmorItem.Type.BODY, 13);
            }), 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.ELECTRIFIED_COPPER_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Electrifium.MOD_ID, "electrified_copper_ingot"))), 4,0.009F));


    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Electrifium.MOD_ID, name), material.get());
    }

}
