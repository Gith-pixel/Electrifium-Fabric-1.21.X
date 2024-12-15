package net.woolvex.electrifium.trim;

import net.woolvex.electrifium.Electrifium;
import net.woolvex.electrifium.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> WARNED = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(Electrifium.MOD_ID, "warned"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context) {
        register(context, ModItems.WARNED_SMITHING_TEMPLATE, WARNED);
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(), Registries.ITEM.getEntry(item),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);

        context.register(key, trimPattern);
    }
}