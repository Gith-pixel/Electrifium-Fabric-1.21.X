package net.woolvex.electrifium.datagen;

import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.woolvex.electrifium.Electrifium;
import net.woolvex.electrifium.item.ModItems;
import net.woolvex.electrifium.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        // Smelting and blasting recipes for electrifium ores
        List<ItemConvertible> ELECTRIFIUM_SMELTABLES = List.of(ModBlocks.ELECTRIFIUM_ORE, ModBlocks.DEEPSLATE_ELECTRIFIUM_ORE);
        offerSmelting(recipeExporter, ELECTRIFIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ELECTRIFIUM, 1.5001f, 200, "electrifium");
        offerBlasting(recipeExporter, ELECTRIFIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ELECTRIFIUM, 1.5001f, 100, "electrifium");

        // Crafting recipe for Electrified Copper Ingot
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_INGOT)
                .pattern("BBB")
                .pattern("BDC")
                .pattern("AAA")
                .input('A', Items.COPPER_INGOT)
                .input('B', ModItems.ELECTRIFIUM)
                .input('C', Items.RAW_COPPER)
                .input('D', Items.NETHERITE_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_ingot"));

        // Compacting and unpacking recipes (manual, with unique identifiers)
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_ELECTRIFIUM)
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .input('E', ModItems.ELECTRIFIUM)
                .criterion("has_electrifium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .offerTo(recipeExporter, Identifier.of("compressed_electrifium_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.ELECTRIFIUM, 9)
                .input(ModBlocks.COMPRESSED_ELECTRIFIUM)
                .criterion("has_compressed_electrifium", conditionsFromItem(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .offerTo(recipeExporter, Identifier.of("compressed_electrifium_unpacking"));

        // Crafting recipes for compressed electrifium variations
        createFenceRecipe(ModBlocks.COMPRESSED_ELECTRIFIUM_FENCE, Ingredient.ofItems(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .criterion("has_compressed_electrifium", conditionsFromItem(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .offerTo(recipeExporter, Identifier.of("compressed_electrifium_fence"));

        createFenceGateRecipe(ModBlocks.COMPRESSED_ELECTRIFIUM_FENCE_GATE, Ingredient.ofItems(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .criterion("has_compressed_electrifium", conditionsFromItem(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .offerTo(recipeExporter, Identifier.of("compressed_electrifium_fence_gate"));

        createDoorRecipe(ModBlocks.COMPRESSED_ELECTRIFIUM_DOOR, Ingredient.ofItems(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .criterion("has_compressed_electrifium", conditionsFromItem(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .offerTo(recipeExporter, Identifier.of("compressed_electrifium_door"));

        createTrapdoorRecipe(ModBlocks.COMPRESSED_ELECTRIFIUM_TRAPDOOR, Ingredient.ofItems(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .criterion("has_compressed_electrifium", conditionsFromItem(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .offerTo(recipeExporter, Identifier.of("compressed_electrifium_trapdoor"));

        createStairsRecipe(ModBlocks.COMPRESSED_ELECTRIFIUM_STAIRS, Ingredient.ofItems(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .criterion("has_compressed_electrifium", conditionsFromItem(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .offerTo(recipeExporter, Identifier.of("compressed_electrifium_stairs"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_ELECTRIFIUM_BUTTON)
                .input(ModBlocks.COMPRESSED_ELECTRIFIUM)
                .criterion("has_compressed_electrifium", conditionsFromItem(ModBlocks.COMPRESSED_ELECTRIFIUM))
                .offerTo(recipeExporter, Identifier.of("compressed_electrifium_button"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_SWORD)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .input('B', Items.STICK)
                .input('A', ModItems.ELECTRIFIED_COPPER_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion("has_electrified_copper_ingot", conditionsFromItem(ModItems.ELECTRIFIED_COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_ingot_sword"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_AXE)
                .pattern(" AA")
                .pattern(" BA")
                .pattern(" B ")
                .input('B', Items.STICK)
                .input('A', ModItems.ELECTRIFIED_COPPER_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion("has_electrified_copper_ingot", conditionsFromItem(ModItems.ELECTRIFIED_COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_ingot_axe_1"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_AXE)
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .input('B', Items.STICK)
                .input('A', ModItems.ELECTRIFIED_COPPER_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion("has_electrified_copper_ingot", conditionsFromItem(ModItems.ELECTRIFIED_COPPER_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_ingot_axe_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_PICKAXE)
                .pattern("BBB")
                .pattern(" A ")
                .pattern(" A ")
                .input('A', Items.STICK)
                .input('B', ModItems.ELECTRIFIED_COPPER_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_ingot_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_SHOVEL)
                .pattern(" B ")
                .pattern(" A ")
                .pattern(" A ")
                .input('A', Items.STICK)
                .input('B', ModItems.ELECTRIFIED_COPPER_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_ingot_shovel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_HOE)
                .pattern(" BB")
                .pattern(" A ")
                .pattern(" A ")
                .input('A', Items.STICK)
                .input('B', ModItems.ELECTRIFIED_COPPER_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_ingot_hoe_1"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_HOE)
                .pattern("BB ")
                .pattern(" A ")
                .pattern(" A ")
                .input('A', Items.STICK)
                .input('B', ModItems.ELECTRIFIED_COPPER_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_ingot_hoe_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_HELMET)
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .input('B', ModItems.ELECTRIFIED_COPPER_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_helmet"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_CHESTPLATE)
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', ModItems.ELECTRIFIED_COPPER_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_chestplate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_LEGGINGS)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.ELECTRIFIED_COPPER_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_ingot_leggings"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELECTRIFIED_COPPER_BOOTS)
                .pattern("   ")
                .pattern("B B")
                .pattern("B B")
                .input('B', ModItems.ELECTRIFIED_COPPER_INGOT)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_electrifiium", conditionsFromItem(ModItems.ELECTRIFIUM))
                .criterion("has_raw_copper", conditionsFromItem(Items.RAW_COPPER))
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(recipeExporter, Identifier.of("electrified_copper_ingot_boots"));

        offerSmithingTrimRecipe(recipeExporter, ModItems.WARNED_SMITHING_TEMPLATE, Identifier.of(Electrifium.MOD_ID, "warned"));

    }
}
