package net.woolvex.electrifium.util;

import net.woolvex.electrifium.Electrifium;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ELECTRIFIED_COPPER_INGOT_TOOL = createTag("needs_electrified_copper_ingot_tool");
        public static final TagKey<Block> INCORRECT_FOR_ELECTRIFIED_COPPER_INGOT_TOOL = createTag("incorrect_for_electrified_copper_ingot_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Electrifium.MOD_ID, name));
        }
    }

    public static class Items {

        }
    }
