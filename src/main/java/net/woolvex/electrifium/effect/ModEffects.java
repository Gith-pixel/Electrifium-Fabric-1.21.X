package net.woolvex.electrifium.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.woolvex.electrifium.Electrifium;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> RADIATED = registerStatusEffect("radiated",
            new RadiatedEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(Electrifium.MOD_ID, "radiated"), -0.75f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));




    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Electrifium.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Electrifium.LOGGER.info("Registering Mod Effects for " + Electrifium.MOD_ID);
    }
}