package net.woolvex.electrifium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Hand;
import net.woolvex.electrifium.effect.ModEffects;
import net.woolvex.electrifium.item.ModArmorMaterials;
import net.woolvex.electrifium.item.ModItemGroups;
import net.woolvex.electrifium.item.ModItems;
import net.woolvex.electrifium.block.ModBlocks;
import net.woolvex.electrifium.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Electrifium implements ModInitializer {
	public static final String MOD_ID = "electrifium";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerEffects();

		List<Item> restrictedItems = List.of(
				Items.BEEF,
				Items.CHICKEN,
				Items.PORKCHOP,
				Items.MUTTON,
				Items.RABBIT,
				Items.SALMON,
				Items.COD,
				Items.COOKED_BEEF,
				Items.COOKED_CHICKEN,
				Items.COOKED_PORKCHOP,
				Items.COOKED_MUTTON,
				Items.COOKED_RABBIT,
				Items.COOKED_SALMON,
				Items.COOKED_COD,
				Items.TROPICAL_FISH,
				Items.APPLE,
				Items.GOLDEN_APPLE,
				Items.ENCHANTED_GOLDEN_APPLE,
				Items.MELON_SLICE,
				Items.CARROT,
				Items.GOLDEN_CARROT,
				Items.BAKED_POTATO,
				Items.POTATO,
				Items.BEETROOT,
				Items.BREAD,
				Items.COOKIE,
				Items.PUMPKIN_PIE,
				Items.DRIED_KELP
		);



		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof HostileEntity hostileEntity) {
				if (player.getMainHandStack().getItem() == ModItems.ELECTRIFIED_COPPER_AXE) {

					hostileEntity.addStatusEffect(new StatusEffectInstance(ModEffects.RADIATED, 600, 1));
					return ActionResult.SUCCESS;
				}
			}
			return ActionResult.PASS;
		});

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof HostileEntity hostileEntity) {
				if (player.getMainHandStack().getItem() == ModItems.ELECTRIFIED_COPPER_SWORD) {

					hostileEntity.addStatusEffect(new StatusEffectInstance(ModEffects.RADIATED, 640, 1)); // Level 0 is appropriate for Glowing
					return ActionResult.SUCCESS;
				}
			}
			return ActionResult.PASS;
		});

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof HostileEntity hostileEntity) {
				if (player.getMainHandStack().getItem() == ModItems.ELECTRIFIED_COPPER_PICKAXE) {

					hostileEntity.addStatusEffect(new StatusEffectInstance(ModEffects.RADIATED, 640, 1)); // Level 0 is appropriate for Glowing
					return ActionResult.SUCCESS;
				}
			}
			return ActionResult.PASS;
		});

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof HostileEntity hostileEntity) {
				if (player.getMainHandStack().getItem() == ModItems.ELECTRIFIED_COPPER_HOE) {

					hostileEntity.addStatusEffect(new StatusEffectInstance(ModEffects.RADIATED, 640, 1)); // Level 0 is appropriate for Glowing
					return ActionResult.SUCCESS;
				}
			}
			return ActionResult.PASS;
		});

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof HostileEntity hostileEntity) {
				if (player.getMainHandStack().getItem() == ModItems.ELECTRIFIED_COPPER_SHOVEL) {

					hostileEntity.addStatusEffect(new StatusEffectInstance(ModEffects.RADIATED, 640, 1)); // Level 0 is appropriate for Glowing
					return ActionResult.SUCCESS;
				}
			}
			return ActionResult.PASS;
		});

		UseItemCallback.EVENT.register((player, world, hand) -> {
			ItemStack stack = player.getStackInHand(hand);
			if (player.hasStatusEffect(ModEffects.RADIATED)){
			if (restrictedItems.contains(stack.getItem())) {
				return TypedActionResult.fail(stack);
			}
			return TypedActionResult.pass(stack);

		}
            return TypedActionResult.pass(stack);
        });

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.ELECTRIFIUM, ModPotions.RADIATED_POTION);
		});

	}
}
